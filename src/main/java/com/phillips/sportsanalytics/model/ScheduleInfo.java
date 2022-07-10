package com.phillips.sportsanalytics.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
public class ScheduleInfo extends Schedule {
    private LocalDate date = LocalDate.now();
    private Long currentYearNumber;
    private Long currentWeekNumber;
    private Long currentSeasonType;

    public ScheduleInfo(Schedule schedule, SeasonInfo seasonInfo){
        setSeason(schedule.getSeason());
        setYear(schedule.getYear());
        this.currentYearNumber = seasonInfo.getYear();
        this.currentSeasonType = seasonInfo.getSeasonType();
        this.currentWeekNumber = seasonInfo.getWeek();
    }
}
