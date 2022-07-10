package com.phillips.sportsanalytics.scheduler;

import com.phillips.sportsanalytics.services.NFLService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import static javax.management.timer.Timer.ONE_MINUTE;

@Component
public class NFLServiceScheduler extends NFLService{
    @Scheduled(fixedRate = ONE_MINUTE)
    public void updateCurrentScoreboard(){
        updateScoreboard();
    }
}
