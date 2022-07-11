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
        SeasonInfo currentSeasonInfo = nflService.getCurrentSeasonInfo();
        if(year == null)
            year = currentSeasonInfo.getYear();
        if(weekNumber == null)
            weekNumber = currentSeasonInfo.getWeek();
        if(seasonType == null)
            seasonType = currentSeasonInfo.getSeasonType();

        Schedule schedule = scheduleService.getStoredSchedule(year);
        boolean weekExists = schedule.getWeek(seasonType, weekNumber) != null;

        // If data for the given week already exists in the repo then return that data
        if(weekExists)
            return new ScheduleInfo(schedule, currentSeasonInfo());
        else
            return new ScheduleInfo(scheduleService.updateGames(year, weekNumber, seasonType), currentSeasonInfo());
    }
}
