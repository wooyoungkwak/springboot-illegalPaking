package com.teraenergy.springbootillegalpaking.model.entity.illegalzone.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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
    Integer ZoneSeq;

    @Column
    String ZoneName;

//    @Column
//    ZonePolygon

    @Column
    Integer LawDongSeq;

}
