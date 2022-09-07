<%--
  Created by IntelliJ IDEA.
  User: zilet
  Date: 2022-03-02
  Time: 오후 7:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://stripes.sourceforge.net/stripes.tld" prefix="stripes" %>
<% String contextPath = request.getContextPath(); %>

<stripes:layout-render name="/WEB-INF/views/layout/layout.jsp">

    <!-- nav -->
    <stripes:layout-component name="nav">
        <stripes:layout-render name="/WEB-INF/views/layout/nav.jsp"/>
    </stripes:layout-component>

    <!-- content -->
    <stripes:layout-component name="contents">
        <div id="layoutSidenav">

            <jsp:include page="side.jsp" flush="true" />

            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">공영주차장</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active">주차장 등록</li>
                        </ol>
                        <div class="card mb-2">
                            <div class="card-header">엑셀 파일 업로드</div>
                            <div class="card-body">
                                <div class="input-group">
                                    <input type="file" class="form-control" id="inputGroupFile04" aria-describedby="inputGroupFileAddon04" aria-label="Upload">
                                </div>
                            </div>
                        </div>
                        <div class="card shadow-sm rounded">
                            <div class="card-body">
                                <div class="row">
                                    <form class="row g-3">
                                        <div class="col-md-4">
                                            <label for="inputEmail4" class="form-label">* 주차장명</label>
                                            <input type="email" class="form-control" id="inputEmail4">
                                        </div>
                                        <div class="col-md-2">
                                            <label for="inputPassword4" class="form-label">* 주차장구분</label>
                                            <input type="password" class="form-control" id="inputPassword4">
                                        </div>
                                        <div class="col-md-2">
                                            <label for="inputAddress" class="form-label">* 주차장유형</label>
                                            <input type="text" class="form-control" id="inputAddress" placeholder="1234 Main St">
                                        </div>
                                        <div class="col-md-2">
                                            <label for="inputPrice" class="form-label">요금</label>
                                            <select id="inputPrice" class="form-select">
                                                <option selected>무료</option>
                                                <option>유료</option>
                                            </select>
                                        </div>
                                        <div class="col-md-2">
                                            <label for="inputCity" class="form-label">부제시행구분</label>
                                            <input type="text" class="form-control" id="inputCity">
                                        </div>
                                        <div class="col-md-2">
                                            <label for="inputState" class="form-label">운영요일</label>
                                            <select id="inputState" class="form-select">
                                                <option selected>평일+토요일+일요일</option>
                                                <option>평일+토요일</option>
                                                <option>평일</option>
                                            </select>
                                        </div>
                                        <div class="col-md-2">
                                            <label for="startTime" class="form-label">평일운영시작시간</label>
                                            <select id="startTime" class="form-select">
                                                <option selected>00:00</option>
                                                <option>01:00</option>
                                                <option>02:00</option>
                                                <option>03:00</option>
                                                <option>04:00</option>
                                                <option>05:00</option>
                                                <option>06:00</option>
                                                <option>07:00</option>
                                            </select>
                                        </div>
                                        <div class="col-md-2">
                                            <label for="endTime" class="form-label">평일운영종료시간</label>
                                            <select id="endTime" class="form-select">
                                                <option selected>23:59</option>
                                                <option>00:59</option>
                                                <option>01:59</option>
                                                <option>02:59</option>
                                                <option>03:59</option>
                                                <option>04:59</option>
                                                <option>05:59</option>
                                                <option>06:59</option>
                                            </select>
                                        </div>
                                        <div class="col-md-2">
                                            <label for="satStartTime" class="form-label">토요일운영시작시간</label>
                                            <select id="satStartTime" class="form-select">
                                                <option selected>00:00</option>
                                                <option>01:00</option>
                                                <option>02:00</option>
                                                <option>03:00</option>
                                                <option>04:00</option>
                                                <option>05:00</option>
                                                <option>06:00</option>
                                                <option>07:00</option>
                                            </select>
                                        </div>
                                        <div class="col-md-2">
                                            <label for="satEndTime" class="form-label">토요일운영종료시간</label>
                                            <select id="satEndTime" class="form-select">
                                                <option selected>23:59</option>
                                                <option>00:59</option>
                                                <option>01:59</option>
                                                <option>02:59</option>
                                                <option>03:59</option>
                                                <option>04:59</option>
                                                <option>05:59</option>
                                                <option>06:59</option>
                                            </select>
                                        </div>
                                        <div class="col-md-2">
                                            <label for="sunEndTime" class="form-label">일요일운영종료시간</label>
                                            <select id="sunEndTime" class="form-select">
                                                <option selected>23:59</option>
                                                <option>00:59</option>
                                                <option>01:59</option>
                                                <option>02:59</option>
                                                <option>03:59</option>
                                                <option>04:59</option>
                                                <option>05:59</option>
                                                <option>06:59</option>
                                            </select>
                                        </div>
                                        <div class="col-md-2">
                                            <label for="sunStartTime" class="form-label">일요일운영시작시간</label>
                                            <select id="sunStartTime" class="form-select">
                                                <option selected>23:59</option>
                                                <option>00:59</option>
                                                <option>01:59</option>
                                                <option>02:59</option>
                                                <option>03:59</option>
                                                <option>04:59</option>
                                                <option>05:59</option>
                                                <option>06:59</option>
                                            </select>
                                        </div>
                                        <div class="col-md-2">
                                            <label for="inputPhone" class="form-label">전화번호</label>
                                            <input type="text" class="form-control" id="inputPhone" placeholder="XXX-XXX-XXXX">
                                        </div>
                                        <div class="col-md-2">
                                            <label for="inputLat" class="form-label">위도</label>
                                            <input type="text" class="form-control" id="inputLat" placeholder="XX.XXXXXXXX">
                                        </div>
                                        <div class="col-md-2">
                                            <label for="inputLot" class="form-label">경도</label>
                                            <input type="text" class="form-control" id="inputLot" placeholder="XX.XXXXXXXX">
                                        </div>

                                        <div class="col-md-2">
                                            <label for="inputManager" class="form-label">* 관리기관명</label>
                                            <input type="text" class="form-control" id="inputManager" placeholder="예>전라남도 광양시청">
                                        </div>
                                        <div class="col-12">
                                            <label for="inputAddress2" class="form-label">소재지도로명 주소</label>
                                            <input type="text" class="form-control" id="inputAddress2" placeholder="Apartment, studio, or floor">
                                        </div>

<%--                                        <div class="col-12">--%>
<%--                                            <div class="form-check">--%>
<%--                                                <input class="form-check-input" type="checkbox" id="gridCheck">--%>
<%--                                                <label class="form-check-label" for="gridCheck">--%>
<%--                                                    등록--%>
<%--                                                </label>--%>
<%--                                            </div>--%>
<%--                                        </div>--%>
                                        <div class="col-12">
                                            <button type="submit" class="btn btn-primary">등록</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>

                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid px-4">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; Your Website 2021</div>
                            <div>
                                <a href="#">Privacy Policy</a>
                                &middot;
                                <a href="#">Terms &amp; Conditions</a>
                            </div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
    </stripes:layout-component>

    <!-- javascript -->
    <stripes:layout-component name="javascript">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
        <script src="<%=contextPath%>/resources/js/scripts.js"></script>
        <script src="<%=contextPath%>/resources/js/datatables-simple-demo.js"></script>
        <script src="<%=contextPath%>/resources/assets/demo/chart-area-demo.js"></script>
        <script src="<%=contextPath%>/resources/assets/demo/chart-bar-demo.js"></script>
    </stripes:layout-component>

</stripes:layout-render>