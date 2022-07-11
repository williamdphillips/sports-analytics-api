package com.phillips.sportsanalytics.services.reposervice;

import com.phillips.sportsanalytics.helper.ResponseDecoder;
import com.phillips.sportsanalytics.model.*;
import com.phillips.sportsanalytics.repository.ScheduleRepository;
import com.phillips.sportsanalytics.response.ScoreboardResponse;
import com.phillips.sportsanalytics.response.odds.OddsResponse;
import com.phillips.sportsanalytics.response.playbyplay.PlayByPlayResponse;
import com.phillips.sportsanalytics.response.prediction.PredictionResponse;
import com.phillips.sportsanalytics.services.NFLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;
    @Qualifier("NFLService")
    @Autowired
    private NFLService nflService;

    private Schedule addWeekToSchedule(Schedule schedule, Long seasonType, Long weekNumber, ArrayList<Event> events){
        Week week = new Week();
        week.setWeekNumber(weekNumber);
        week.setEvents(events);
        schedule.putWeek(seasonType, week);
        saveSchedule(schedule).subscribe();
        return schedule;
    }

    public Schedule getStoredSchedule(Long year){
        Schedule schedule = findSchedule(year);
        if(schedule == null){
            schedule = new Schedule();
            schedule.setYear(year);
        }
        return schedule;
    }

    public ScheduleInfo updateGames(Long year, Long weekNumber, Long seasonType){
        SeasonInfo currentSeasonInfo = nflService.getCurrentSeasonInfo();
        if(year == null)
            year = currentSeasonInfo.getYear();
        if(weekNumber == null)
            weekNumber = currentSeasonInfo.getWeek();
        if(seasonType == null)
            seasonType = currentSeasonInfo.getSeasonType();

        Schedule schedule = getStoredSchedule(year);

        ScoreboardResponse sr = nflService.getScoreboard(year, weekNumber, seasonType, true, true);
        ArrayList<Event> events = ResponseDecoder.decode(sr);
        for (Event event : events
        ) {
            OddsResponse or = nflService.getOdds(event.getEventId(), true, true);
            ResponseDecoder.updateOdds(or, event);
            PredictionResponse pr = nflService.getPrediction(event.getEventId(), true, true);
            ResponseDecoder.updatePredictions(pr, event);
            PlayByPlayResponse pbpr = nflService.getPlayByPlay(event.getEventId(), true, true);
            ResponseDecoder.updatePlays(pbpr, event);
        }
        return new ScheduleInfo(addWeekToSchedule(schedule, seasonType, weekNumber, events), nflService.getCurrentSeasonInfo());
    }

    public Schedule findSchedule(Long year) {
        return scheduleRepository.findById(year.toString()).block();
    }

    public Mono<Schedule> saveSchedule(Schedule schedule){
        return scheduleRepository.save(schedule);
    }
}
