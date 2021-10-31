package com.phillips.sportsanalytics.model;

public class Event {
    String displayClock;
    String displayClockDetail;
    String shortDetail;
    String description;
    Boolean isCompleted;
    String eventId;
    String week;
    String state;
    String overUnder;
    String overOdds;
    String spread;
    String spreadDetails;


    Team awayTeam;
    Team homeTeam;
    Play currentPlay;

    public Event(){

    }

    public Play getCurrentPlay() {
        return currentPlay;
    }

    public void setCurrentPlay(Play currentPlay) {
        this.currentPlay = currentPlay;
    }

    public String getOverUnder() {
        return overUnder;
    }

    public void setOverUnder(String overUnder) {
        this.overUnder = overUnder;
    }

    public String getOverOdds() {
        return overOdds;
    }

    public void setOverOdds(String overOdds) {
        this.overOdds = overOdds;
    }

    public String getSpread() {
        return spread;
    }

    public void setSpread(String spread) {
        this.spread = spread;
    }

    public String getSpreadDetails() {
        return spreadDetails;
    }

    public void setSpreadDetails(String spreadDetails) {
        this.spreadDetails = spreadDetails;
    }

    public String getDisplayClock() {
        return displayClock;
    }

    public void setDisplayClock(String displayClock) {
        this.displayClock = displayClock;
    }

    public String getDisplayClockDetail() {
        return displayClockDetail;
    }

    public void setDisplayClockDetail(String displayClockDetail) {
        this.displayClockDetail = displayClockDetail;
    }

    public String getShortDetail() {
        return shortDetail;
    }

    public void setShortDetail(String shortDetail) {
        this.shortDetail = shortDetail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }
}
