package com.phillips.sportsanalytics.repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.phillips.sportsanalytics.response.playbyplay.PlayByPlayResponse;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayByPlayRepository  extends CosmosRepository<PlayByPlayResponse, String> {
    Iterable<PlayByPlayResponse> findByEventId(String eventId);
}

