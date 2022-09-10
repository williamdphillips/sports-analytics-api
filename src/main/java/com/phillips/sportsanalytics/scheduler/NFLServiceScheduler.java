package com.phillips.sportsanalytics.scheduler;

import com.phillips.sportsanalytics.services.NFLService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import static javax.management.timer.Timer.ONE_MINUTE;
import static javax.management.timer.Timer.ONE_SECOND;

@Component
public class NFLServiceScheduler extends NFLService{
    /**
     * Update current scoreboard every 30 seconds
     * Direct correlation with how often ESPN APIs are queried
     */
    @Scheduled(fixedRate = ONE_SECOND * 30)
    public void updateCurrentScoreboard(){
        updateScoreboard();
    }
}
