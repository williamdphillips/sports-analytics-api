package com.phillips.sportsanalytics.scheduler;

import com.phillips.sportsanalytics.helper.ResponseDecoder;
import com.phillips.sportsanalytics.model.Event;
import com.phillips.sportsanalytics.model.Schedule;
import com.phillips.sportsanalytics.model.SeasonInfo;
import com.phillips.sportsanalytics.model.Week;
import com.phillips.sportsanalytics.response.ScoreboardResponse;
import com.phillips.sportsanalytics.services.NFLService;
import com.phillips.sportsanalytics.services.reposervice.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

import static javax.management.timer.Timer.*;

@Component
public class ScheduleServiceScheduler extends ScheduleService {
    @Qualifier("NFLService")
    @Autowired
    NFLService nflService;

    /**
     * If any games for the week have started, update all games at a scheduled interval
     */
    @Scheduled(fixedRate = ONE_MINUTE)
    public void updateCurrentSchedule(){
        ScoreboardResponse sr = nflService.getCurrentScoreboard();
        ArrayList<Event> events = ResponseDecoder.decode(sr);
        boolean inGame = events.stream().anyMatch(e -> e.getState().equalsIgnoreCase("in"));
        Map<Long, Map<Long, Week>> storedSchedule = getStoredSchedule(sr.season.year).getSeason();
        boolean mismatch = storedSchedule.get(sr.season.type).get(sr.week.number).getEvents()
                .stream().anyMatch(e -> events.stream().anyMatch(ce -> Objects.equals(ce.getEventId(), e.getEventId())
                        && !Objects.equals(ce.getState(), e.getState())));
        if(inGame || mismatch)
            updateGames(null, null, null);
    }

    /**
     * Updates games for current week if games have not yet started
     */
    @Scheduled(fixedRate = ONE_HOUR)
    public void updateFutureSchedule(){
        ScoreboardResponse sr = nflService.getCurrentScoreboard();
        ArrayList<Event> events = ResponseDecoder.decode(sr);
        boolean futureGame = events.stream().anyMatch(e -> e.getState().equalsIgnoreCase("pre"));
        if(futureGame)
            updateGames(null, null, null);
    }

    /**
     * If next week's games are future, provide updates every twenty-four hours
     */
    @Scheduled(fixedRate = ONE_HOUR * 24)
    public void updateNextWeekSchedule(){
        SeasonInfo si = nflService.getCurrentSeasonInfo();
        ScoreboardResponse sr = nflService.getScoreboard(si.getYear(), si.getWeek()+1, si.getSeasonType(), true);
        ArrayList<Event> events = ResponseDecoder.decode(sr);
        boolean futureGame = events.stream().anyMatch(e -> e.getState().equalsIgnoreCase("pre"));
        if(futureGame)
            updateGames(null, si.getWeek()+1, null);
    }

    /**
     * In some cases ESPN sends the incorrect season type, so this accounts for that issue.
     * For example, the ESPN API response may say that the current season type is '2' which
     * indicates that it is regular season. However, at the time it may still be preseason.
     */
    @Scheduled(fixedRate = ONE_HOUR * 24)
    public void updatePreseasonTypeSchedule(){
        SeasonInfo si = nflService.getCurrentSeasonInfo();
        if(si.getWeek() > 4)
            return;
        ScoreboardResponse sr = nflService.getScoreboard(si.getYear(), si.getWeek(), 1L, true);
        ArrayList<Event> events = ResponseDecoder.decode(sr);
        boolean futureGame = events.stream().anyMatch(e -> e.getState().equalsIgnoreCase("pre"));
        if(futureGame){
            updateGames(si.getYear(), 1L, 1L);
            updateGames(si.getYear(), 2L, 1L);
            updateGames(si.getYear(), 3L, 1L);
            updateGames(si.getYear(), 4L, 1L);
        }
    }

    //@Scheduled(fixedRate = ONE_HOUR * 24)
    public void updateAllSchedules(){
        SeasonInfo si = nflService.getCurrentSeasonInfo();
        Schedule schedule = getStoredSchedule(si.getYear());

        // preseason
        for(int i = 1; i <= 4; i++){
            if(schedule.getWeek(1L, (long)i) == null)
                updateGames(si.getYear(), (long)i, 1L);
        }

        for(int i = 1; i <= 18; i++){
            if(schedule.getWeek(2L, (long)i) == null)
                updateGames(si.getYear(), (long)i, 2L);
        }

        for(int i = 1; i <= 5; i++){
            if(schedule.getWeek(3L, (long)i) == null)
                updateGames(si.getYear(), (long)i, 3L);
        }
    }
}
