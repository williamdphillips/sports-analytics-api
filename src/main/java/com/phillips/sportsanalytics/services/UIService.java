package com.phillips.sportsanalytics.services;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.phillips.sportsanalytics.helper.ResponseDecoder;
import com.phillips.sportsanalytics.model.Event;
import com.phillips.sportsanalytics.model.Week;
import com.phillips.sportsanalytics.response.PlayByPlayResponse;
import com.phillips.sportsanalytics.response.ScoreboardResponse;
import com.phillips.sportsanalytics.response.odds.OddsResponse;
import com.phillips.sportsanalytics.response.prediction.PredictionResponse;
import com.phillips.sportsanalytics.response.winprobability.WinProbabilityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UIService {
    private NFLService nflService;
    private ObjectMapper mapper;

    @Autowired
    public void setNFLService(NFLService nflService) {
        this.nflService = nflService;
    }

    public UIService(){
        mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
    }

    public Week getAllGames(String weekNumber){


        ScoreboardResponse sr = nflService.getScoreboard(null, weekNumber);
        ArrayList<Event> events = ResponseDecoder.decode(sr);

        if(weekNumber == null)
            weekNumber = String.valueOf(sr.week.number);

        for (Event event : events
             ) {
            OddsResponse or = nflService.getOdds(event.getEventId());
            ResponseDecoder.updateOdds(or, event);
            PredictionResponse pr = nflService.getPrediction(event.getEventId());
            ResponseDecoder.updatePredictions(pr, event);
            PlayByPlayResponse pbpr = nflService.getPlayByPlay(event.getEventId());
            ResponseDecoder.updatePlays(pbpr, event);
            WinProbabilityResponse wpr = nflService.getWinProbability(event.getEventId());
            ResponseDecoder.updateWinPercentage(wpr, event);
        }

        Week week = new Week();
        week.setWeekNumber(weekNumber);
        week.setEvents(events);

        return week;
    }
}
