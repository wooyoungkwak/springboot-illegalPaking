package com.teraenergy.springbootillegalpaking.model.entity.parking.service;

import com.teraenergy.springbootillegalpaking.model.entity.parking.domain.Parking;
import com.teraenergy.springbootillegalpaking.model.entity.parking.repository.ParkingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Date : 2022-09-11
 * Author : zilet
 * Project : springboot-illegalPaking
 * Description :
 */

@RequiredArgsConstructor
@Service
public class ParkingServiceImpl implements ParkingService{

    final private ParkingRepository parkingRepository;

    @Override
    public List<Parking> gets() {
        return parkingRepository.findAll();
    }

    @Override
    public Parking get(Integer prkingSeq) {
        return parkingRepository.findById(prkingSeq).get();
    }

    @Override
    public List<Parking> sets(List<Parking> parkings) {
        return parkingRepository.saveAll(parkings);
    }

    @Override
    public Parking set(Parking parking) {
        return parkingRepository.save(parking);
    }

    @Override
    public Parking delete(Parking parking) {
        return parkingRepository.save(parking);
    }
}
