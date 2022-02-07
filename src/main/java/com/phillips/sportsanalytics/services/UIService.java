package com.phillips.sportsanalytics.services;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.phillips.sportsanalytics.helper.DataHelper;
import com.phillips.sportsanalytics.helper.ResponseDecoder;
import com.phillips.sportsanalytics.model.Event;
import com.phillips.sportsanalytics.model.Schedule;
import com.phillips.sportsanalytics.model.Week;
import com.phillips.sportsanalytics.response.PlayByPlayResponse;
import com.phillips.sportsanalytics.response.ScoreboardResponse;
import com.phillips.sportsanalytics.response.odds.OddsResponse;
import com.phillips.sportsanalytics.response.prediction.PredictionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UIService {
    private NFLService nflService;
    private ObjectMapper mapper;
    private Schedule schedule;

    @Autowired
    public void setNFLService(NFLService nflService) {
        this.nflService = nflService;
    }

    public UIService(){
        mapper = new ObjectMapper();
        schedule = new Schedule();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
    }

    public Schedule getAllGames(Long weekNumber, Long seasonType){

        ScoreboardResponse sr = nflService.getScoreboard(null, weekNumber, seasonType);
        schedule.setCurrentWeekNumber(sr.week.number);
        schedule.setCurrentSeasonType(sr.season.type);
        ArrayList<Event> events = ResponseDecoder.decode(sr);
        ArrayList<Event> newEvents = new ArrayList <>();

        //In this scenario, week and seasonType are null and not supplied which will default
        //to the current week and seasonType per ESPN API docs
        if(weekNumber == null || weekNumber.equals(schedule.getCurrentWeekNumber())) {
            weekNumber = sr.week.number;
            seasonType = sr.season.type;
            boolean weekExists = DataHelper.containsWeek(schedule, seasonType, weekNumber);

            for (Event event : events
            ) {
                String eventState = event.getState();
                if(!weekExists ||
                        eventState.equalsIgnoreCase("in") ||
                        eventState.equalsIgnoreCase("pre") ||
                !eventState.equalsIgnoreCase(DataHelper.getEventState(events, event.getEventId()))){
                    OddsResponse or = nflService.getOdds(event.getEventId());
                    ResponseDecoder.updateOdds(or, event);
                    PredictionResponse pr = nflService.getPrediction(event.getEventId());
                    ResponseDecoder.updatePredictions(pr, event);
                    PlayByPlayResponse pbpr = nflService.getPlayByPlay(event.getEventId());
                    ResponseDecoder.updatePlays(pbpr, event);
                }else {
                    Week week = schedule.getSeason().get(seasonType).get(weekNumber);
                    newEvents.add(week.getEvents().stream().filter(e -> e.getEventId()
                            .equals(event.getEventId())).collect(Collectors.toList()).get(0));
                }
            }

            Week week = new Week();
            week.setWeekNumber(weekNumber);
            events.removeIf(e -> newEvents.stream().anyMatch(ne -> e.getEventId().equalsIgnoreCase(ne.getEventId())));
            events.addAll(newEvents);
            week.setEvents(events);

            schedule.setDate(LocalDate.now());
            schedule.addWeek(seasonType, week);

        }else{
            //In this scenario, week and seasonType will be supplied
            boolean weekExists = DataHelper.containsWeek(schedule, seasonType, weekNumber);
            for (Event event : events
            ) {
                if(!weekExists || event.getState().equalsIgnoreCase("pre")){
                    OddsResponse or = nflService.getOdds(event.getEventId());
                    ResponseDecoder.updateOdds(or, event);
                    PredictionResponse pr = nflService.getPrediction(event.getEventId());
                    ResponseDecoder.updatePredictions(pr, event);

                    Week week = new Week();
                    week.setWeekNumber(weekNumber);
                    week.setEvents(events);

                    schedule.setDate(LocalDate.now());
                    schedule.addWeek(seasonType, week);
                }
            }

        }
        return schedule;
    }
}
