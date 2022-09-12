package com.teraenergy.springbootillegalpaking.model.entity.illegalzone.repository;

import com.teraenergy.springbootillegalpaking.model.entity.illegalzone.domain.IllegalZone;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Date : 2022-09-12
 * Author : zilet
 * Project : springboot-illegalPaking
 * Description :
 */
public interface IllegalZoneRepository extends JpaRepository<IllegalZone, Integer> {
}
