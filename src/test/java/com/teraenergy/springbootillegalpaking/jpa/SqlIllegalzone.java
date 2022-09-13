package com.teraenergy.springbootillegalpaking.jpa;


import com.teraenergy.springbootillegalpaking.ApplicationTests;
import com.teraenergy.springbootillegalpaking.model.entity.illegalzone.domain.IllegalZone;
import com.teraenergy.springbootillegalpaking.model.entity.illegalzone.service.IllegalZoneService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.locationtech.jts.geom.*;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ActiveProfiles(value = "debug")
@SpringBootTest(classes = ApplicationTests.class)
@RunWith(SpringRunner.class)
public class SqlIllegalzone {

    @Autowired
    IllegalZoneService illegalZoneService;

    @Test
    public void insert() {
//        GeometryFactory geometryFactory = new GeometryFactory();
//        String polygonPoints = "126.567668343956 33.451276403135246,126.56935715259203 33.45123719996867,126.56834423197559 33.451621366446425,126.56966217559021 33.45045386564941,126.567668343956 33.451276403135246";
//        String[] polygonPointArr = polygonPoints.split(",");
//        Coordinate[] coordinates = new Coordinate[polygonPointArr.length];
//        for (int i = 0; i < polygonPointArr.length; i++) {
//            String[] test = polygonPointArr[i].split(" ");
//            coordinates[i] = new Coordinate(Double.parseDouble(test[0]), Double.parseDouble(test[1]));
//        }
//
//        List<Coordinate> coordinateList = Arrays.stream(coordinates).sequential().collect(Collectors.toList());
//        Polygon polygon = geometryFactory.createPolygon(coordinates);

        Geometry geometry = null;
        try {
            geometry = new WKTReader().read(String.format("POLYGON((126.567668343956 33.451276403135246,126.56935715259203 33.45123719996867,126.56834423197559 33.451621366446425,126.56966217559021 33.45045386564941,126.567668343956 33.451276403135246))"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        Polygon polygon = geometry.getFactory().createPolygon();
        if ( !polygon.isEmpty() ) {

//        ST_GeomFromText('POLYGON((126.567668343956 33.451276403135246,126.56935715259203 33.45123719996867,126.56834423197559 33.451621366446425,126.56966217559021 33.45045386564941,126.567668343956 33.451276403135246))')
//        POLYGONFROMTEXT

            IllegalZone illegalZone = new IllegalZone();
            illegalZone.setName("샘플");
            illegalZone.setLawDongSeq(1);
            illegalZone.setPolygon(polygon);
            illegalZone.setIsDel(false);
            illegalZoneService.set(illegalZone);
        } else {
            System.out.println(" empty .... ");
        }
    }

    @Test
    void select() {
        List<IllegalZone> illegalZones = illegalZoneService.gets(1);

        GeometryFactory geometryFactory = new GeometryFactory();
        Point polyInnerPoint = geometryFactory.createPoint(new Coordinate(126.56866907996265,33.451180712229686));
        Point polyInnerPoint2 = geometryFactory.createPoint(new Coordinate(126.56915449563454,33.450893887400085));
        Point polyInnerPoint3 = geometryFactory.createPoint(new Coordinate(126.56826037812841,33.45117928982703));
        Point polyInnerPoint4 = geometryFactory.createPoint(new Coordinate(126.56816407185906,33.451079778302194));
        Point polyOuterPoint = geometryFactory.createPoint(new Coordinate(126.56916190732109,33.45157011423124));
        Point polyOuterPoint2 = geometryFactory.createPoint(new Coordinate(126.56652326588099,33.45011835549815));
        Point polyOuterPoint3 = geometryFactory.createPoint(new Coordinate(126.56601552728885,33.450567380165516));

        IllegalZone illegalZone = illegalZones.get(0);
        boolean innerWithin = polyInnerPoint.within(illegalZone.getPolygon());
        boolean innerWithin2 = polyInnerPoint2.within(illegalZone.getPolygon());
        boolean innerWithin3 = polyInnerPoint3.within(illegalZone.getPolygon());
        boolean innerWithin4 = polyInnerPoint4.within(illegalZone.getPolygon());
        boolean outerWithin = polyOuterPoint.within(illegalZone.getPolygon());
        boolean outerWithin2 = polyOuterPoint2.within(illegalZone.getPolygon());
        boolean outerWithin3 = polyOuterPoint3.within(illegalZone.getPolygon());

        System.out.println("innerWithin :" + innerWithin);
        System.out.println("innerWithin2 :" + innerWithin2);
        System.out.println("innerWithin3 :" + innerWithin3);
        System.out.println("innerWithin4 :" + innerWithin4);
        System.out.println("outerWithin :" + outerWithin);
        System.out.println("outerWithin2 :" + outerWithin2);
        System.out.println("outerWithin3 :" + outerWithin3);

    }
}
