package com.phillips.sportsanalytics.model;

import java.time.LocalDate;
import java.util.*;

public class Schedule {
    private LocalDate date;
    private Long currentWeekNumber;
    private Long currentSeasonType;
    private Map <Long, Map <Long, Week>> season;

    public Schedule(){
        date = LocalDate.now();
        season = new HashMap <>();

    }

    public Long getCurrentSeasonType() {
        return currentSeasonType;
    }

    public void setCurrentSeasonType(Long currentSeasonType) {
        this.currentSeasonType = currentSeasonType;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getCurrentWeekNumber() {
        return currentWeekNumber;
    }

    public void setCurrentWeekNumber(Long currentWeekNumber) {
        this.currentWeekNumber = currentWeekNumber;
    }

    public Map <Long, Map <Long, Week>> getSeason() {
        return season;
    }

    public void setSeason(Map <Long, Map<Long, Week>> season) {
        this.season = season;
    }

    public void addWeek(Long seasonType, Week week){
        if (!this.season.containsKey(seasonType)) {
            this.season.put(seasonType, new HashMap <>());
        }
        this.season.get(seasonType).put(week.getWeekNumber(), week);
    }
}
