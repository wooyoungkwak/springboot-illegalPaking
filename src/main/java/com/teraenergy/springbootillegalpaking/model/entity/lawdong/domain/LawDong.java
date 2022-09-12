package com.teraenergy.springbootillegalpaking.model.entity.lawdong.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Date : 2022-09-10
 * Author : zilet
 * Project : springboot-illegalPaking
 * Description :
 */

@Getter
@Setter
@Entity(name = "law_dong")
public class LawDong {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer LawDongSeq;

    @Column
    Double Code;

    @Column
    String DongName;

    @Column
    Boolean isDel;
}
