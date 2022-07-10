package com.phillips.sportsanalytics.services;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.phillips.sportsanalytics.helper.ResponseDecoder;
import com.phillips.sportsanalytics.model.*;
import com.phillips.sportsanalytics.response.ScoreboardResponse;
import com.phillips.sportsanalytics.response.odds.OddsResponse;
import com.phillips.sportsanalytics.response.playbyplay.PlayByPlayResponse;
import com.phillips.sportsanalytics.response.prediction.PredictionResponse;
import com.phillips.sportsanalytics.services.reposervice.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UIService {
    private NFLService nflService;
    private ScheduleService scheduleService;
    private ObjectMapper mapper;

    @Autowired
    public void setNFLService(@Qualifier("NFLService") NFLService nflService) {
        this.nflService = nflService;
    }
    @Autowired
    public void setScheduleService(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    public UIService(){
        mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }

    private SeasonInfo currentSeasonInfo(){
        return nflService.getCurrentSeasonInfo();
    }

    /**
     * Serves as entrypoint for the UI
     * @param year
     * @param weekNumber
     * @param seasonType
     * @return Returns all games in an easily digestible format
     */
    public ScheduleInfo getAllGames(Long year, Long weekNumber, Long seasonType){
        ScoreboardResponse sr = nflService.getScoreboard(year, weekNumber, seasonType, true, false);
        year = sr.season.year;
        weekNumber = sr.week.number;
        seasonType = sr.season.type;
        ArrayList<Event> events = ResponseDecoder.decode(sr);
        Schedule schedule = getStoredSchedule(year);
        boolean weekExists = schedule.getWeek(seasonType, weekNumber) != null;

        // If data for the given week already exists in the repo then return that data
        if(weekExists && events.stream().allMatch(e -> e.getState().equalsIgnoreCase("post")) &&
                events.size() == schedule.getWeek(seasonType, weekNumber).getEvents().size())
            return new ScheduleInfo(schedule, currentSeasonInfo());

        for (Event event : events
        ) {
            String eventState = event.getState();
            Event matchingEvent = null;
            if(weekExists) {
                ArrayList<Event> matchingEvents = (ArrayList<Event>) schedule.getWeek(seasonType, weekNumber).getEvents()
                        .stream()
                        .filter(e -> e.getEventId().equalsIgnoreCase(event.getEventId()))
                        .collect(Collectors.toList());
                if (matchingEvents.size() == 1)
                    matchingEvent = matchingEvents.get(0);
            }
            boolean inGame = eventState.equalsIgnoreCase("in") || eventState.equalsIgnoreCase("pre");

            if(inGame ||
                matchingEvent == null ||
                !matchingEvent.getState().equalsIgnoreCase(eventState)
            ){
                OddsResponse or = nflService.getOdds(event.getEventId(), true, !inGame);
                ResponseDecoder.updateOdds(or, event);
                PredictionResponse pr = nflService.getPrediction(event.getEventId(), true, !inGame);
                ResponseDecoder.updatePredictions(pr, event);
                PlayByPlayResponse pbpr = nflService.getPlayByPlay(event.getEventId(), true, !inGame);
                ResponseDecoder.updatePlays(pbpr, event);
            }
        }
        return new ScheduleInfo(addWeekToSchedule(schedule, seasonType, weekNumber, events), currentSeasonInfo());
    }

    private Schedule addWeekToSchedule(Schedule schedule, Long seasonType, Long weekNumber, ArrayList<Event> events){
        Week week = new Week();
        week.setWeekNumber(weekNumber);
        week.setEvents(events);
        schedule.putWeek(seasonType, week);
        if(events.stream().allMatch(e -> e.getState().equalsIgnoreCase("post")))
            return scheduleService.saveSchedule(schedule);
        else
            return schedule;
    }

    private Schedule getStoredSchedule(Long year){
        Schedule schedule = scheduleService.findSchedule(year);
        if(schedule == null){
            schedule = new Schedule();
            schedule.setYear(year);
        }
        return schedule;
    }
}
