package com.teraenergy.springbootillegalpaking.model.mapper.illegalzone.repository;

import com.teraenergy.springbootillegalpaking.model.mapper.illegalzone.domain.IllegalZone;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Date : 2022-09-12
 * Author : zilet
 * Project : springboot-illegalPaking
 * Description :
 */

@Mapper
public interface IllegalZoneRepository {

    List<IllegalZone> findById(Integer zoneSeq);

    List<IllegalZone> findByIdDong(Integer lawDongSeq);

    List<IllegalZone> findAll();

    void save(IllegalZone illegalZone);

    void saveAll(List<IllegalZone> illegalZones);

}
