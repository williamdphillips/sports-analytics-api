package com.phillips.sportsanalytics.model;

import java.time.LocalDate;
import java.util.*;

public class MasterSchedule {
    private LocalDate date = LocalDate.now();
    private Long currentYearNumber;
    private Long currentWeekNumber;
    private Long currentSeasonType;
    // year, schedule
    private Map <Long, Schedule> schedules;

    public MasterSchedule(){
        schedules = new HashMap<>();
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getCurrentYearNumber() {
        return currentYearNumber;
    }

    public void setCurrentYearNumber(Long currentYearNumber) {
        this.currentYearNumber = currentYearNumber;
    }

    public Long getCurrentWeekNumber() {
        return currentWeekNumber;
    }

    public void setCurrentWeekNumber(Long currentWeekNumber) {
        this.currentWeekNumber = currentWeekNumber;
    }

    public Long getCurrentSeasonType() {
        return currentSeasonType;
    }

    public void setCurrentSeasonType(Long currentSeasonType) {
        this.currentSeasonType = currentSeasonType;
    }

    public Map<Long, Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(Map<Long, Schedule> schedules) {
        this.schedules = schedules;
    }

    public void addWeek(Long year, Long seasonType, Week week){
        if(!schedules.containsKey(year)){
            schedules.put(year, new Schedule());
        }
        if (!schedules.get(year).season.containsKey(seasonType)) {
            schedules.get(year).season.put(seasonType, new HashMap <>());
        }
        schedules.get(year).season.get(seasonType).put(week.getWeekNumber(), week);
    }
}
