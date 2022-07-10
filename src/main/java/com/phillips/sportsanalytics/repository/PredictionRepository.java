package com.phillips.sportsanalytics.repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.phillips.sportsanalytics.response.prediction.PredictionResponse;
import org.springframework.stereotype.Repository;

@Repository
public interface PredictionRepository extends CosmosRepository<PredictionResponse, String> {
    Iterable<PredictionResponse> findByEventId(String eventId);
}
