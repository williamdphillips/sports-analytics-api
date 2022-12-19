package com.phillips.sportsanalytics.scheduler;

import com.phillips.sportsanalytics.services.reposervice.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

@Component
public class ApplicationShutdownHook {

    @Autowired
    ScoreboardService scoreboardService;
    @Autowired
    ScheduleService scheduleService;
    @Autowired
    OddsService oddsService;
    @Autowired
    PlayByPlayService playByPlayService;
    @Autowired
    PredictionService predictionService;

    @PreDestroy
    public void saveDataToRepo(){
        scheduleService.saveSchedulesToRepo();
        scoreboardService.saveScoreboardsToRepo();
        oddsService.saveOddsToRepo();
        playByPlayService.savePlayByPlaysToRepo();
        predictionService.savePredictionsToRepo();
    }
}
