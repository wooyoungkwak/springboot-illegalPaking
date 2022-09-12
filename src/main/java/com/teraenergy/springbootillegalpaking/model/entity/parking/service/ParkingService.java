package com.teraenergy.springbootillegalpaking.model.entity.parking.service;

import com.teraenergy.springbootillegalpaking.model.entity.parking.domain.Parking;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Date : 2022-09-11
 * Author : zilet
 * Project : springboot-illegalPaking
 * Description :
 */

@Service
public interface ParkingService {

    public List<Parking> gets();

    public Parking get(Integer prkingSeq);

    public List<Parking> sets(List<Parking> parkings);

    public Parking set(Parking parking);

    public Parking delete(Parking parking);

}
