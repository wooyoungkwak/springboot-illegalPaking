package com.teraenergy.springbootillegalpaking.model.entity.illegalzone.service;

import com.querydsl.jpa.JPQLQueryFactory;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.teraenergy.springbootillegalpaking.model.entity.illegalzone.domain.IllegalZone;
import com.teraenergy.springbootillegalpaking.model.entity.illegalzone.domain.QIllegalZone;
import com.teraenergy.springbootillegalpaking.model.entity.illegalzone.repository.IllegalZoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Date : 2022-09-12
 * Author : zilet
 * Project : springboot-illegalPaking
 * Description :
 */

@RequiredArgsConstructor
@Service
public class IllegalZoneServiceImpl implements IllegalZoneService{

    private final IllegalZoneRepository illegalZoneRepository;

    private final EntityManager entityManager;

    @Override
    public List<IllegalZone> gets(Integer lawdongSeq) {
        JPQLQueryFactory query = new JPAQueryFactory(entityManager);
        return query.selectFrom(QIllegalZone.illegalZone).where(QIllegalZone.illegalZone.LawDongSeq.eq(lawdongSeq))
                .fetch();
    }

    @Override
    public IllegalZone set(IllegalZone illegalZone) {
        return illegalZoneRepository.save(illegalZone);
    }

    @Override
    public List<IllegalZone> sets(List<IllegalZone> illegalZones) {
        return illegalZoneRepository.saveAll(illegalZones);
    }
}
