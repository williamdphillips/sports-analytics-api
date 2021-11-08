package com.phillips.sportsanalytics.services;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    public Schedule getAllGames(String weekNumber){

        ScoreboardResponse sr = nflService.getScoreboard(null, weekNumber);
        ArrayList<Event> events = ResponseDecoder.decode(sr);
        ArrayList<Event> newEvents = new ArrayList <>();

        if(weekNumber == null) {
            weekNumber = String.valueOf(sr.week.number);
            for (Event event : events
            ) {
                if(!schedule.getWeeks().containsKey(weekNumber)){
                    OddsResponse or = nflService.getOdds(event.getEventId());
                    ResponseDecoder.updateOdds(or, event);
                    PredictionResponse pr = nflService.getPrediction(event.getEventId());
                    ResponseDecoder.updatePredictions(pr, event);
                    PlayByPlayResponse pbpr = nflService.getPlayByPlay(event.getEventId());
                    ResponseDecoder.updatePlays(pbpr, event);
                }else if(schedule.getWeeks().containsKey(weekNumber) && event.getState().equalsIgnoreCase("in")) {
                    OddsResponse or = nflService.getOdds(event.getEventId());
                    ResponseDecoder.updateOdds(or, event);
                    PredictionResponse pr = nflService.getPrediction(event.getEventId());
                    ResponseDecoder.updatePredictions(pr, event);
                    PlayByPlayResponse pbpr = nflService.getPlayByPlay(event.getEventId());
                    ResponseDecoder.updatePlays(pbpr, event);
                }else if(schedule.getWeeks().containsKey(weekNumber)){
                     newEvents.add(schedule.getWeeks().get(weekNumber).getEvents().stream()
                            .filter(e -> e.getEventId().equals(event.getEventId())).collect(Collectors.toList()).get(0));
                }

                //WinProbabilityResponse wpr = nflService.getWinProbability(event.getEventId());
                //ResponseDecoder.updateWinPercentage(wpr, event);
            }

            Week week = new Week();
            week.setWeekNumber(weekNumber);
            events.removeIf(e -> newEvents.stream().anyMatch(ne -> e.getEventId().equalsIgnoreCase(ne.getEventId())));
            events.addAll(newEvents);
            week.setEvents(events);

            schedule.setDate(LocalDate.now());
            schedule.addWeek(weekNumber, week);
            schedule.setCurrentWeekNumber(weekNumber);

        }else{
            for (Event event : events
            ) {
                OddsResponse or = nflService.getOdds(event.getEventId());
                ResponseDecoder.updateOdds(or, event);
                PredictionResponse pr = nflService.getPrediction(event.getEventId());
                ResponseDecoder.updatePredictions(pr, event);
            }

            Week week = new Week();
            week.setWeekNumber(weekNumber);
            week.setEvents(events);

            schedule.setDate(LocalDate.now());
            schedule.addWeek(weekNumber, week);

        }
        return schedule;
    }
}
