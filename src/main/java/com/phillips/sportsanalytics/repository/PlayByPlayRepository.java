package com.phillips.sportsanalytics.repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.azure.spring.data.cosmos.repository.ReactiveCosmosRepository;
import com.phillips.sportsanalytics.response.playbyplay.PlayByPlayResponse;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface PlayByPlayRepository  extends ReactiveCosmosRepository<PlayByPlayResponse, String> {
    Flux<PlayByPlayResponse> findByEventId(String eventId);
}

