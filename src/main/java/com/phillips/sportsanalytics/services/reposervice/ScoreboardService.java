package com.phillips.sportsanalytics.services.reposervice;

import com.phillips.sportsanalytics.repository.ScoreboardRepository;
import com.phillips.sportsanalytics.response.ScoreboardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class ScoreboardService {

    @Autowired
    private ScoreboardRepository scoreboardRepository;
    private static final Map<String, ScoreboardResponse> inMemoryScoreboards = new HashMap<>();

    public ScoreboardResponse findScoreboard(Long year, Long type, Long week) {
        String id = "Y" + year + "S" + type + "W" + week;
        ScoreboardResponse scoreboardResponse = inMemoryScoreboards.get(id);
        if(scoreboardResponse == null) {
            scoreboardResponse = scoreboardRepository.findById(id).block();
        }
        return scoreboardResponse;
    }

    /**
     * Saves scoreboard to in-memory collection
     * @param scoreboardResponse response from ESPN scoreboard API
     */
    public void saveScoreboard(ScoreboardResponse scoreboardResponse){
        String id = "Y" + scoreboardResponse.season.year
                + "S" + scoreboardResponse.season.type
                + "W" + scoreboardResponse.week.number;
        inMemoryScoreboards.put(id, scoreboardResponse);
    }

    public void saveScoreboardsToRepo(){
        inMemoryScoreboards.values().forEach(sc -> scoreboardRepository.save(sc).block());
    }
}
