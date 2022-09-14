package com.teraenergy.springbootillegalpaking.model.mapper.illegalzone.service;

import com.teraenergy.springbootillegalpaking.model.mapper.illegalzone.domain.IllegalZone;

import java.util.List;

/**
 * Date : 2022-09-12
 * Author : zilet
 * Project : springboot-illegalPaking
 * Description :
 */
public interface IllegalZoneService {

    public List<IllegalZone> gets(Integer lawDongSeq);

    public List<IllegalZone> gets();

    public void set(IllegalZone illegalZone);

    public void sets(List<IllegalZone> illegalZones);
}
