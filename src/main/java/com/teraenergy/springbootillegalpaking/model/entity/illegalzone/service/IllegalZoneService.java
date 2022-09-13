package com.teraenergy.springbootillegalpaking.model.entity.illegalzone.service;

import com.teraenergy.springbootillegalpaking.model.entity.illegalzone.domain.IllegalZone;

import java.util.List;

/**
 * Date : 2022-09-12
 * Author : zilet
 * Project : springboot-illegalPaking
 * Description :
 */
public interface IllegalZoneService {

    public List<IllegalZone> gets(Integer lawDongSeq);

    public IllegalZone set(IllegalZone illegalZone);

    public List<IllegalZone> sets(List<IllegalZone> illegalZones);
}
