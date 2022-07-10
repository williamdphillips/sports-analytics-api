package com.phillips.sportsanalytics.repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.azure.spring.data.cosmos.repository.ReactiveCosmosRepository;
import com.phillips.sportsanalytics.response.prediction.PredictionResponse;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface PredictionRepository extends ReactiveCosmosRepository<PredictionResponse, String> {
    Flux<PredictionResponse> findByEventId(String eventId);
}
