package com.phillips.sportsanalytics.services.reposervice;

import com.phillips.sportsanalytics.repository.ScoreboardRepository;
import com.phillips.sportsanalytics.response.ScoreboardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreboardService {

    @Autowired
    private ScoreboardRepository scoreboardRepository;

    public ScoreboardResponse findScoreboard(Long year, Long type, Long week) {
        String id = "Y" + year + "S" + type + "W" + week;
        return scoreboardRepository.findById(id).orElse(null);
    }

    public ScoreboardResponse saveScoreboard(ScoreboardResponse scoreboardResponse){
        return scoreboardRepository.save(scoreboardResponse);
    }
}
