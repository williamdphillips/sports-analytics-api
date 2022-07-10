package com.phillips.sportsanalytics.repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.phillips.sportsanalytics.response.odds.OddsResponse;
import org.springframework.stereotype.Repository;

@Repository
public interface OddsRepository extends CosmosRepository<OddsResponse, String> {
    Iterable<OddsResponse> findByEventId(String eventId);
}