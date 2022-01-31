package com.phillips.sportsanalytics.model;

import java.util.ArrayList;

public class Week {
    private Long weekNumber;
    private String dates;
    private ArrayList <Event> events;

    public Long getWeekNumber() {
        return weekNumber;
    }

    public void setWeekNumber(Long weekNumber) {
        this.weekNumber = weekNumber;
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public ArrayList <Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList <Event> events) {
        this.events = events;
    }
}
