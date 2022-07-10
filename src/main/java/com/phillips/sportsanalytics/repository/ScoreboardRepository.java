package com.phillips.sportsanalytics.repository;

import com.azure.spring.data.cosmos.repository.ReactiveCosmosRepository;
import com.phillips.sportsanalytics.response.ScoreboardResponse;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ScoreboardRepository extends ReactiveCosmosRepository<ScoreboardResponse, String> {
    Mono<ScoreboardResponse> findById(String id);
}
