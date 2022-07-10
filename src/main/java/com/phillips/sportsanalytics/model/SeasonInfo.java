package com.phillips.sportsanalytics.model;

import lombok.Data;

@Data
public class SeasonInfo{
    private Long year;
    private Long seasonType;
    private Long week;

    public Boolean isCurrentWeek(Long year, Long weekNumber, Long seasonType){
        return weekNumber.equals(this.week) &&
                year.equals(this.year) &&
                seasonType.equals(this.seasonType);
    }

    /**
     * Note: During the offseason the seasonType can be incorrect (received from ESPN), so
     * seasonType is ignored
     * @param year
     * @param weekNumber
     * @param seasonType
     * @return
     */
    public Boolean isCurrentWeekOrFuture(Long year, Long weekNumber, Long seasonType){
        return year >= this.year && weekNumber >= this.week; //&& seasonType >= this.seasonType;
    }
}