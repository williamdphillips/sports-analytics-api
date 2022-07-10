package com.phillips.sportsanalytics.services.reposervice;

import com.phillips.sportsanalytics.repository.ScoreboardRepository;
import com.phillips.sportsanalytics.response.ScoreboardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ScoreboardService {

    @Autowired
    private ScoreboardRepository scoreboardRepository;

    public Mono<ScoreboardResponse> findScoreboard(Long year, Long type, Long week) {
        String id = "Y" + year + "S" + type + "W" + week;
        return scoreboardRepository.findById(id);
    }

    public Mono<ScoreboardResponse> saveScoreboard(ScoreboardResponse scoreboardResponse){
        return scoreboardRepository.save(scoreboardResponse);
    }
}
