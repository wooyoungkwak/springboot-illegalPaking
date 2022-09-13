package com.teraenergy.springbootillegalpaking.model.entity.illegalzone.domain;

import lombok.Getter;
import lombok.Setter;
import org.locationtech.jts.geom.Polygon;

import javax.persistence.*;
import java.awt.*;

/**
 * Date : 2022-09-09
 * Author : zilet
 * Project : springboot-illegalPaking
 * Description :
 */

@Getter
@Setter
@Entity(name = "illegal_zone")
public class IllegalZone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer zoneSeq;

    @Column (nullable = false)
    String name;

    @Column (nullable = false)
    Polygon polygon;

    @Column (nullable = false)
    Boolean isDel;

    @Column (nullable = false)
    Integer lawDongSeq;

}
