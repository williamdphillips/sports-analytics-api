package com.phillips.sportsanalytics.repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.phillips.sportsanalytics.response.ScoreboardResponse;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ScoreboardRepository extends CosmosRepository<ScoreboardResponse, String> {
    Optional<ScoreboardResponse> findById(String id);
}
