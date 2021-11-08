package com.phillips.sportsanalytics.model;

import java.time.LocalDate;
import java.util.HashMap;

public class Schedule {
    private LocalDate date;
    private String currentWeekNumber;
    private HashMap <String, Week> weeks;

    public Schedule(){
        date = LocalDate.now();
        weeks = new HashMap <String, Week>();
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCurrentWeekNumber() {
        return currentWeekNumber;
    }

    public void setCurrentWeekNumber(String currentWeekNumber) {
        this.currentWeekNumber = currentWeekNumber;
    }

    public HashMap <String, Week> getWeeks() {
        return weeks;
    }

    public void setWeeks(HashMap <String, Week> weeks) {
        this.weeks = weeks;
    }

    public void addWeek(String weekNumber, Week week){
        this.weeks.put(weekNumber, week);
    }
}
