package com.teraenergy.springbootillegalpaking.model.mapper.illegalzone.service;

import com.teraenergy.springbootillegalpaking.model.mapper.illegalzone.domain.IllegalZone;
import com.teraenergy.springbootillegalpaking.model.mapper.illegalzone.repository.IllegalZoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Date : 2022-09-12
 * Author : zilet
 * Project : springboot-illegalPaking
 * Description :
 */

@RequiredArgsConstructor
@Service
public class IllegalZoneServiceImpl implements IllegalZoneService {

    private final IllegalZoneRepository illegalZoneRepository;

    @Override
    public List<IllegalZone> gets(Integer lawDongSeq) {
        return illegalZoneRepository.findById(lawDongSeq);
    }

    @Override
    public List<IllegalZone> gets() {
        return illegalZoneRepository.findAll();
    }

    @Override
    public void set(IllegalZone illegalZone) {
        illegalZoneRepository.save(illegalZone);
    }

    @Override
    public void sets(List<IllegalZone> illegalZones) {
        illegalZoneRepository.saveAll(illegalZones);
    }
}
