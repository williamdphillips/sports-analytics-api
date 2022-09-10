package com.phillips.sportsanalytics.repository;

import com.azure.spring.data.cosmos.repository.ReactiveCosmosRepository;
import com.phillips.sportsanalytics.response.odds.OddsResponse;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface OddsRepository extends ReactiveCosmosRepository<OddsResponse, String> {
    Flux<OddsResponse> findByEventId(String eventId);
}