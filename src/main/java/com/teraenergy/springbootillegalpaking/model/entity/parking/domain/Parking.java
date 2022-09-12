package com.teraenergy.springbootillegalpaking.model.entity.parking.domain;

import com.teraenergy.springbootillegalpaking.model.entity.lawdong.domain.LawDong;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Date : 2022-09-11
 * Author : zilet
 * Project : springboot-illegalPaking
 * Description :
 */

@Getter
@Setter
@Entity (name = "parking")
public class Parking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer PrkSeq;

    @Column
    String PrkplceNo;

    @Column
    String PrkplceNm;

    @Column
    String PrkplceSe;

    @Column
    String PrkplceType;

    @Column
    String Rdnmadr;

    @Column
    String Lnmadr;

    @Column
    Integer Prkcmprt;

    @Column
    Integer FeedingSe;

    @Column
    String EnforceSe;

    @Column
    String OperDay;

    @Column
    String WeekdayOperOpenHhmm;

    @Column
    String WeekdayOperColseHhmm;

    @Column
    String SatOperOpenHhmm;

    @Column
    String SatOperCloseHhmm;

    @Column
    String HolidayOperOpenHhmm;

    @Column
    String HolidayOperCloseHhmm;

    @Column
    String ParkingchrgeInfo;

    @Column
    String BasicTime;

    @Column
    Integer BasicCharge;

    @Column
    String AddUnitTime;

    @Column
    Integer AddUnitCharge;

    @Column
    String DayCmmtktAdjTime;

    @Column
    Integer DayCmmtkt;

    @Column
    Integer MonthCmmtkt;

    @Column
    String Metpay;

    @Column
    String Spcmnt;

    @Column
    String InstitutionNm;

    @Column
    String PhoneNumber;

    @Column
    Double Latitude;

    @Column
    Double Longitude;

    @Column
    LocalDate ReferenceDate;

    @ManyToOne
    @JoinColumn(name = "LawDongSeq")
    LawDong lawDong;
}
