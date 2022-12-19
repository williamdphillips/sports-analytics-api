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
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;
    @Qualifier("NFLService")
    @Autowired
    private NFLService nflService;
    private static final Map<Long, Schedule> inMemorySchedules = new HashMap<>();

    private Schedule addWeekToSchedule(Schedule schedule, Long seasonType, Long weekNumber, ArrayList<Event> events){
        Week week = new Week();
        week.setWeekNumber(weekNumber);
        week.setEvents(events);
        schedule.putWeek(seasonType, week);
        saveSchedule(schedule);
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

        ScoreboardResponse sr = nflService.getScoreboard(year, weekNumber, seasonType, true);
        ArrayList<Event> events = ResponseDecoder.decode(sr);
        for (Event event : events
        ) {
            OddsResponse or = nflService.getOdds(event.getEventId(), true);
            ResponseDecoder.updateOdds(or, event);
            PredictionResponse pr = nflService.getPrediction(event.getEventId(), true);
            ResponseDecoder.updatePredictions(pr, event);
            PlayByPlayResponse pbpr = nflService.getPlayByPlay(event.getEventId(), true);
            ResponseDecoder.updatePlays(pbpr, event);
        }
        return new ScheduleInfo(addWeekToSchedule(schedule, seasonType, weekNumber, events), nflService.getCurrentSeasonInfo());
    }

    /**
     * Returns stored schedule from memory or storage if not exists in memory
     * @param year schedule's year
     * @return schedule
     */
    public Schedule getStoredSchedule(Long year) {
        Schedule schedule = inMemorySchedules.get(year);
        if (schedule == null){
            schedule = scheduleRepository.findById(year.toString()).block();
            if(schedule == null){
                schedule = new Schedule();
                schedule.setYear(year);
            }
        }

        return schedule;
    }

    /**
     * Saves schedule to in-memory collection
     * @param schedule schedule to save
     */
    public void saveSchedule(Schedule schedule){
        long year = schedule.getYear();
        inMemorySchedules.put(year, schedule);
    }

    public void saveSchedulesToRepo(){
        List<Schedule> storedSchedules = scheduleRepository.findAll().toStream().collect(Collectors.toList());

        inMemorySchedules.values().forEach(schedule -> {
            //1999
            AtomicReference<Integer> matchingScheduleIndex = new AtomicReference<>();
            storedSchedules.stream().filter(s -> s.getYear().equals(schedule.getYear()))
                    .forEach(s -> matchingScheduleIndex.set(storedSchedules.indexOf(s)));
            if(matchingScheduleIndex.get() != null) {
                schedule.getSeason().forEach((seasonType, weekMap) ->
                        weekMap.values().forEach(week ->
                                storedSchedules.get(matchingScheduleIndex.get()).putWeek(seasonType, week)));
            }else{
                storedSchedules.add(schedule);
            }

        });
        storedSchedules.forEach(s -> scheduleRepository.save(s).block());
    }
}
