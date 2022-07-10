package com.phillips.sportsanalytics.repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.phillips.sportsanalytics.model.Schedule;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends CosmosRepository<Schedule, String> {
    Iterable<Schedule> findByYear(Long year);
}