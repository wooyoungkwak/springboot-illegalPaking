$(function (){
    let zoneSeq = [];
    let zoneType = [];
    let zonePolygon = [];
    let zoneArea = [];
    let polygonList = `${polygonList}`;

    // for( polygon in polygonList ) {
    // zoneSeq.push(polygon.zoneSeq);
    // zoneType.push(polygon.zoneType);
    // zonePolygon.push(polygon.zonePolygon);
    // }

    pathInBounds();
});

// Drawing Manager로 도형을 그릴 지도 div
var drawingMapContainer = document.getElementById('drawingMap'),
    drawingMap = {
        center: new kakao.maps.LatLng(35.02035492064902, 126.79383256393594), // 지도의 중심좌표
        level: 3, // 지도의 확대 레벨
        disableDoubleClickZoom: true
    };

// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
var drawingMap = new kakao.maps.Map(drawingMapContainer, drawingMap)
    , overlays = [] // 지도에 그려진 도형을 담을 배열
    , customOverlay = new kakao.maps.CustomOverlay({})
    , infowindow = new kakao.maps.InfoWindow({removable: true});

var options = { // Drawing Manager를 생성할 때 사용할 옵션입니다
    map: drawingMap, // Drawing Manager로 그리기 요소를 그릴 map 객체입니다
    drawingMode: [ // Drawing Manager로 제공할 그리기 요소 모드입니다
        kakao.maps.drawing.OverlayType.POLYGON
    ],
    // 사용자에게 제공할 그리기 가이드 툴팁입니다
    // 사용자에게 도형을 그릴때, 드래그할때, 수정할때 가이드 툴팁을 표시하도록 설정합니다
    guideTooltip: ['draw', 'drag', 'edit'],
    polygonOptions: {
        draggable: true,
        removable: true,
        editable: true,
        strokeColor: '#a2a0a0',
        fillColor: '#FF3333',
        fillOpacity: 0.5,
        hintStrokeStyle: 'dash',
        hintStrokeOpacity: 0.5
    }
};

// 다각형에 마우스오버 이벤트가 발생했을 때 변경할 채우기 옵션입니다
var mouseoverOption = {
    fillColor: '#EFFFED', // 채우기 색깔입니다
    fillOpacity: 0.8 // 채우기 불투명도 입니다
};

// 다각형에 마우스아웃 이벤트가 발생했을 때 변경할 채우기 옵션입니다
var mouseoutOption = function(area) {
    return {fillColor: fillColorSetting(area), // 채우기 색깔입니다
        fillOpacity: 0.5} // 채우기 불투명도 입니다
};

// 위에 작성한 옵션으로 Drawing Manager를 생성합니다
var manager = new kakao.maps.drawing.DrawingManager(options);

// 버튼 클릭 시 호출되는 핸들러 입니다
function selectOverlay(type) {
    // 그리기 중이면 그리기를 취소합니다
    manager.cancel();

    // 클릭한 그리기 요소 타입을 선택합니다
    manager.select(kakao.maps.drawing.OverlayType[type]);
}

// Drawing Manager에서 데이터를 가져와 도형을 표시할 아래쪽 지도 div
/*
var mapContainer = document.getElementById('map'),
    mapOptions = {
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };
*/

function zoneInitialize(data) {
    zonePolygon = []; zoneSeq = []; zoneType = [];
    data.polygonList.forEach(function (element) {
        zonePolygon.push(element.zonePolygon);
        zoneSeq.push(element.zoneSeq);
        zoneType.push(element.zoneType);
    });
}

// 폴리곤 생성 후 새로 그릴 때 생성된 폴리곤 삭제를 위해 manager 데이터 저장
let drawingDataTargets = [];
manager.addListener('drawend', function(data) {
    drawingDataTargets.push(data.target);
});

let searchZoneType ='';
$('input:radio[name=searchZoneType]').change(function(){
    searchZoneType = $('input:radio[name=searchZoneType]:checked').val();

    searchZone(searchZoneType);
});

function searchZone(searchZoneType){
    let param = {'searchZoneType': searchZoneType}
    let callBackFn = function (data) {
        removeOverlays();
        zoneInitialize(data);
        drawingPolygon(getPolygonData(), 'load');
    }
    commonAjax("/admin/map/polygonList", callBackFn, 'GET', param, '에러');
}


// 가져오기 버튼을 클릭하면 호출되는 핸들러 함수입니다
// Drawing Manager로 그려진 객체 데이터를 가져와 아래 지도에 표시합니다
function getDataFromDrawingMap() {

    // Drawing Manager에서 그려진 데이터 정보를 가져옵니다
    var data = manager.getData();

    let param = {
        'polygonData': data[kakao.maps.drawing.OverlayType.POLYGON]
        , 'searchZoneType': searchZoneType
    };

    let errorMsg = '실패';
    let callBackFn = function (data) {
        if (param.length === 0) {
            alert('구역을 지정하시기 바랍니다.');
            return false;
        } else {
            // 아래 지도에 그려진 도형이 있다면 모두 지웁니다
            removeOverlays();
            // 지도에 가져온 데이터로 도형들을 그립니다
            zoneInitialize(data);
            drawingPolygon(param.polygonData, 'drawing');
            // 생성한 폴리곤 삭제
            removeDrawingOverlays();
        }
    }
    commonAjax("/admin/map/insertPolygon", callBackFn, 'POST', JSON.stringify(param), errorMsg);

}

// 생성한 그리기 도형 삭제
function removeDrawingOverlays() {
    drawingDataTargets.forEach(function (element) {
        manager.remove(element);
    })
}

// 아래 지도에 그려진 도형이 있다면 모두 지웁니다
function removeOverlays() {
    var len = overlays.length, i = 0;

    for (; i < len; i++) {
        overlays[i].setMap(null);
    }

    overlays = [];
}

function drawingPolygon(polygons, stat) {
    let areas = getPolygonData();
    if(stat === 'drawing') {
        areas.forEach(function (element) {
            polygons.push(element);
        })
    }
    removeOverlays();

    // 지도에 영역데이터를 폴리곤으로 표시합니다
    for (let i = 0; i< polygons.length; i++) {
        displayArea(polygons[i]);
    }
}

function fillColorSetting(area){
    let fillColor;
    if(area.type === 'F') fillColor = '#ffff22';
    else if(area.type === 'Y') fillColor = '#ff6f00';
    else fillColor = '#FF3333';

    return fillColor;
}

// 다각형을 생상하고 이벤트를 등록하는 함수입니다
function displayArea(area) {

    var path = pointsToPath(area.points);
    var style = area.options;

    // 다각형을 생성합니다
    var polygon = new kakao.maps.Polygon({
        map: drawingMap, // 다각형을 표시할 지도 객체
        path: path,
        strokeColor: style.strokeColor,
        strokeOpacity: style.strokeOpacity,
        strokeStyle: style.strokeStyle,
        strokeWeight: style.strokeWeight,
        fillColor: fillColorSetting(area),
        fillOpacity: style.fillOpacity
    });

    console.log(centroid(area.points));

    // 다각형에 mouseover 이벤트를 등록하고 이벤트가 발생하면 폴리곤의 채움색을 변경합니다
    // 지역명을 표시하는 커스텀오버레이를 지도위에 표시합니다
    kakao.maps.event.addListener(polygon, 'mouseover', function(mouseEvent) {
        polygon.setOptions(mouseoverOption);
    });

    // 다각형에 mouseout 이벤트를 등록하고 이벤트가 발생하면 폴리곤의 채움색을 원래색으로 변경합니다
    // 커스텀 오버레이를 지도에서 제거합니다
    kakao.maps.event.addListener(polygon, 'mouseout', function() {
        polygon.setOptions(mouseoutOption(area));
    });

    // 다각형에 마우스다운 이벤트를 등록합니다
    var upCount = 0;
    kakao.maps.event.addListener(polygon, 'click', function(mouseEvent) {
        var resultDiv = document.getElementById('result');
        resultDiv.innerHTML = '다각형에 mouseup 이벤트가 발생했습니다!' + (++upCount);
        coordinatesToDongCodeKakaoApi();
        showModal(area.seq);
    });
    overlays.push(polygon);
}

function showModal(seq){
    let callBackFn = function(data) {
        let result = data.result;

        $('#polySeq').val(result.zoneSeq);
        let zoneType = result.zoneType;

        $('input:radio[name=zoneType]:input[value="' + zoneType + '"]').prop('checked', true);

        let checkVal = $('input:radio[name="zoneType"]:checked').val();
        timeHideAndShow(checkVal);
        timeSetting(result);

        // alert(result.zoneSeq);0
        $('#areaSettingModal').modal('show');
    }

    let param = {'polySeq': seq};
    commonAjax("/admin/map/polygonDetail", callBackFn, "GET", param, "서버에러");
}
// 탄력적 가능 시간 설정
$('input:radio[name=zoneType]').click(function() {
    let checkVal = $('input:radio[name=zoneType]:checked').val();
    timeHideAndShow(checkVal);
});

function timeHideAndShow(checkVal) {
    if(checkVal === 'Y'){ //탄력적 가능일 경우
        $('#timeRow').css('display', 'block');
        $('#startTime, #endTime').attr('disabled', false);
    } else {
        $('#timeRow').css('display', 'none');
        $('#startTime, #endTime').attr('disabled', true);
    }
}
function timeSetting(result) {
    let startTime = result.startTime;
    let endTime = result.endTime;
    if(startTime === null || endTime === null) {
        startTime = 9;
        endTime = 18;
    }
    $('#startTime').val(startTime).prop('selected', true);
    $('#endTime').val(endTime).prop('selected', true);
}
// 폴리곤 삭제
$('#btnDelete').click(function(){
    let param = {
        'polySeq': $('#polySeq').val()
        , 'searchZoneType': searchZoneType
    };
    if(confirm("삭제하시겠습니까?")){
        let callBackFn = function(data) {
            zoneInitialize(data);
            drawingPolygon(getPolygonData(), 'load');
            $('#areaSettingModal').modal('hide');
            alert("삭제되었습니다.");
        }
        commonAjax("/admin/map/deletePolygon", callBackFn, "DELETE", JSON.stringify(param), "에러");
    }
});

// 구역 설정
$('#btnUpdate').click(function(){
    if(confirm("설정하시겠습니까?")){
        let param = $('#formAreaSetting').serializeObject();
        param.searchZoneType = searchZoneType;
        let callBackFn = function(data) {
            zoneInitialize(data);
            drawingPolygon(getPolygonData(), 'load');
            $('#areaSettingModal').modal('hide');
            alert("설정되었습니다.");
        }
        commonAjax("/admin/map/updatePolygon", callBackFn, "PUT", JSON.stringify(param), "에러");
    }
});


/**************************************
 * ****** 폴리곤 내부 포함여부 확인 ******
 **************************************/
kakao.maps.event.addListener(drawingMap, 'click', function(mouseEvent) {
    var latlng = mouseEvent.latLng;
    console.log('click! ' + latlng.toString());
    console.log("x : " + latlng.getLat() + ", y : " + latlng.getLng());
    let p = new Point(latlng.getLng(), latlng.getLat());
    let polys = getPolygonData();
    var len = polys.length;
    for (let i = 0; i < len; i++) {
        let onePolygon = polys[i].points;
        let n = onePolygon.length;
        if (isInside(onePolygon, n, p)) {
            console.log(i + " : Yes");
        } else {
            // console.log(i + " : No");
        }
    }
});

// 지도에 마우스 오른쪽 클릭 이벤트를 등록합니다
// 선을 그리고있는 상태에서 마우스 오른쪽 클릭 이벤트가 발생하면 그리기를 종료합니다
kakao.maps.event.addListener(drawingMap, 'rightclick', function (mouseEvent) {
    // 그리기 중이면 그리기를 취소합니다
    manager.cancel();
});

kakao.maps.event.addListener(drawingMap, 'dblclick', function(mouseEvent) {
    selectOverlay('POLYGON');
});

// 지도가 이동, 확대, 축소로 인해 중심좌표가 변경되면 마지막 파라미터로 넘어온 함수를 호출하도록 이벤트를 등록합니다
/*kakao.maps.event.addListener(drawingMap, 'center_changed', function() {

    // 지도의  레벨을 얻어옵니다
    var level = drawingMap.getLevel();

    if(level > 3) {
        removeOverlays();
    } else {
        pathInBounds();
    }

    // 지도의 중심좌표를 얻어옵니다
    var latlng = drawingMap.getCenter();

    //폴리곤 점들이 다 포함되면 표시되게... 할수있음 ?



    var message = '<p>지도 레벨은 ' + level + ' 이고</p>';
    message += '<p>중심 좌표는 위도 ' + latlng.getLat() + ', 경도 ' + latlng.getLng() + '입니다</p>';

    var resultDiv = document.getElementById('result');
    resultDiv.innerHTML = message;

});*/

/*
kakao.maps.event.addListener(drawingMap, 'drag', function() {
    removeOverlays();
    console.log(overlays);
});
*/

// 중심 좌표나 확대 수준이 변경되면 발생한다.
kakao.maps.event.addListener(drawingMap, 'idle', function() {
    // 지도의  레벨을 얻어옵니다
    var level = drawingMap.getLevel();

    if(level > 5) {
        removeOverlays();
    } else {
        pathInBounds();
    }
})
// 보여지는 맵에 포함된 폴리곤 찾기
function pathInBounds(){
    //맵 구역
    let bounds = drawingMap.getBounds();
    let inBoundsPath = [];

    // 영역정보의 남서쪽 정보를 얻어옵니다
    var swLatLng = bounds.getSouthWest();
    // var swCoords = swLatLng.toCoords();
    // var south = swCoords.getY();
    // var west = swCoords.getX();
    var south = swLatLng.getLat();
    var west = swLatLng.getLng();

    // 영역정보의 북동쪽 정보를 얻어옵니다
    var neLatLng = bounds.getNorthEast();
    // var neCoords = neLatLng.toCoords();
    // var north = neCoords.getY();
    // var east = neCoords.getX();
    var north = neLatLng.getLat();
    var east = neLatLng.getLng();

    // 동, 서, 남, 북 좌표
    console.log(east, west, south, north);

    getPolygonData().filter(function(overlay) {
        let obj = {}, points = [];
        let paths = pointsToPath(overlay.points);
        //console.log(paths);
        paths.forEach(function(element){
            points.push(bounds.contain(element));
            obj.inBound = points;
        });
        // 맵 안에 포함되어있는지 확인
        if(obj.inBound.some(inBoundPoint => inBoundPoint === true)) {
            obj.overlay = overlay;
            inBoundsPath.push(obj.overlay);
            //console.log(inBoundsPath);
        }
        // console.log(obj.inBound.every(x => x === false));

    });
    drawingPolygon(inBoundsPath, 'load');
    console.log(inBoundsPath);
}

// Drawing Manager에서 가져온 데이터 중
// 선과 다각형의 꼭지점 정보를 kakao.maps.LatLng객체로 생성하고 배열로 반환하는 함수입니다
function pointsToPath(points) {
    var len = points.length,
        path = [],
        i = 0;

    for (; i < len; i++) {
        var latlng = new kakao.maps.LatLng(points[i].y, points[i].x);
        path.push(latlng);
    }

    return path;
}

let polygonStyle = {
    "draggable": true,
    "removable": true,
    "editable": true,
    "strokeColor": "#330000",
    "strokeWeight": 2,
    "strokeStyle": "solid",
    "strokeOpacity": 1,
    "fillColor": "#000000",
    "fillOpacity": 0.5
};

function getPolygonData() {
    let areas = [];
    for (let j = 0; j < zonePolygon.length; j++) {
        let pointsPoly = [], obj = {};
        let zonePolygonArr = zonePolygon[j].split(",");
        obj.type = zoneType[j];
        obj.seq = zoneSeq[j];
        for (let i = 0; i < zonePolygonArr.length - 1; i++) {
            let pathPoints = zonePolygonArr[i].split(" ");
            pointsPoly[i] = new Point(pathPoints[0], pathPoints[1]);
            obj.points = pointsPoly;
        }
        obj.coordinate = 'wgs84';
        obj.options = polygonStyle;
        areas.push(obj);
    }
    return areas;
}



//

function appendObjTo(thatArray, newObj) {
    const frozenObj = Object.freeze(newObj);
    return Object.freeze(thatArray.concat(frozenObj));
}

// serialize 맵형태로 변경
$.fn.serializeObject = function(){
    const o = {};
    const a = this.serializeArray();
    $.each(a, function() {
        const name = $.trim(this.name),
            value = $.trim(this.value);

        if (o[name]) {
            if (!o[name].push) {
                o[name] = [o[name]];
            }
            o[name].push(value || '');
        } else {
            o[name] = value || '';
        }
    });
    return o;
};

/******************************
 * 폴리곤 내 포함 여부 체크 start
 * ****************************/
let INF = 10000;

class Point {
    constructor(x, y) {
        this.x = x;
        this.y = y;
    }
}

function onSegment(p, q, r) {
    return q.x <= Math.max(p.x, r.x) &&
        q.x >= Math.min(p.x, r.x) &&
        q.y <= Math.max(p.y, r.y) &&
        q.y >= Math.min(p.y, r.y);

}

function orientation(p, q, r) {
    let val = (q.y - p.y) * (r.x - q.x)
        - (q.x - p.x) * (r.y - q.y);

    if (val === 0) {
        return 0; // collinear
    }
    return (val > 0) ? 1 : 2; // clock or counterclock wise
}

function doIntersect(p1, q1, p2, q2) {
    let o1 = orientation(p1, q1, p2);
    let o2 = orientation(p1, q1, q2);
    let o3 = orientation(p2, q2, p1);
    let o4 = orientation(p2, q2, q1);

    // General case
    if (o1 !== o2 && o3 !== o4) {
        return true;
    }

    // Special Cases
    // p1, q1 and p2 are collinear and
    // p2 lies on segment p1q1
    if (o1 === 0 && onSegment(p1, p2, q1)) {
        return true;
    }

    // p1, q1 and p2 are collinear and
    // q2 lies on segment p1q1
    if (o2 === 0 && onSegment(p1, q2, q1)) {
        return true;
    }

    // p2, q2 and p1 are collinear and
    // p1 lies on segment p2q2
    if (o3 === 0 && onSegment(p2, p1, q2)) {
        return true;
    }

    // p2, q2 and q1 are collinear and
    // q1 lies on segment p2q2
    if (o4 === 0 && onSegment(p2, q1, q2)) {
        return true;
    }

    // Doesn't fall in any of the above cases
    return false;
}


function isInside(polygon, n, p) {

    polygon.push(polygon[0]);

    // There must be at least 3 vertices in polygon[]
    if (n < 3) {
        return false;
    }

    // Create a point for line segment from p to infinite
    let extreme = new Point(INF, p.y);

    // Count intersections of the above line
    // with sides of polygon
    let count = 0, i = 0;
    do {
        let next = (i + 1) % n;

        // Check if the line segment from 'p' to
        // 'extreme' intersects with the line
        // segment from 'polygon[i]' to 'polygon[next]'
        if (doIntersect(polygon[i], polygon[next], p, extreme)) {
            // If the point 'p' is collinear with line
            // segment 'i-next', then check if it lies
            // on segment. If it lies, return true, otherwise false
            if (orientation(polygon[i], p, polygon[next]) === 0) {
                return onSegment(polygon[i], p,
                    polygon[next]);
            }

            count++;
        }
        i = next;
    } while (i !== 0);

    // Return true if count is odd, false otherwise
    return (count % 2 === 1); // Same as (count%2 == 1)
}
/*폴리곤 내 포함 여부 체크 end*/


/*폴리곤 중심 좌표 구하기*/
function centroid(points) {
    var i, j, len, p1, p2, f, area, x, y;

    area = x = y = 0;

    for (i = 0, len = points.length, j = len - 1; i < len; j = i++) {
        p1 = points[i];
        p2 = points[j];

        f = p1.y * p2.x - p2.y * p1.x;
        x += (parseFloat(p1.x) + parseFloat(p2.x)) * f;
        y += (parseFloat(p1.y) + parseFloat(p2.y)) * f;
        area += f * 3;
    }

    return [x / area, y / area];
}
/*폴리곤 중심 좌표 구하기 end*/


/* 좌표로 동코드 받기 카카오 REST API */
function coordinatesToDongCodeKakaoApi(){
    fetch("https://dapi.kakao.com/v2/local/geo/coord2regioncode.json?input_coord=WGS84&output_coord=WGS84&x=126.78416155710897&y=35.016484911425344", {
        headers: {
            Authorization: "KakaoAK 350a9e6cc59932a26806ab0c0b6fdd2e"
        }
    }).then((response) => response.json())
        .then((data) => {
            console.log('성공:', data.documents);
        });

    //console.log(documents);
}
/* 좌표로 동코드 받기 카카오 REST API end */


