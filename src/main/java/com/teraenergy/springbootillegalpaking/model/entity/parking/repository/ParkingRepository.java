package com.teraenergy.springbootillegalpaking.model.entity.parking.repository;

import com.teraenergy.springbootillegalpaking.model.entity.parking.domain.Parking;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Date : 2022-09-11
 * Author : zilet
 * Project : springboot-illegalPaking
 * Description :
 */
public interface ParkingRepository extends JpaRepository<Parking, Integer> {
}
