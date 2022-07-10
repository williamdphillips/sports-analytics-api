package com.phillips.sportsanalytics.repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.azure.spring.data.cosmos.repository.ReactiveCosmosRepository;
import com.phillips.sportsanalytics.model.Schedule;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ScheduleRepository extends ReactiveCosmosRepository<Schedule, String> {
    Flux<Schedule> findByYear(Long year);
}