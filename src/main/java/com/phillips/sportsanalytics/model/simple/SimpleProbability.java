package com.phillips.sportsanalytics.model.simple;

public class SimpleProbability {
    private String eventId;
    private String homeTeamId;
    private String homeTeamInitials;
    private String homeTeamShortName;
    private String homeTeamLongName;
    private String homeTeamWinPercentage;

    private String awayTeamId;
    private String awayTeamInitials;
    private String awayTeamShortName;
    private String awayTeamLongName;
    private String awayTeamWinPercentage;

    public SimpleProbability() {

    }

    public SimpleProbability(String eventId, String homeTeamId, String homeTeamInitials, String homeTeamShortName, String homeTeamLongName, String homeTeamWinPercentage, String awayTeamId, String awayTeamInitials, String awayTeamShortName, String awayTeamLongName, String awayTeamWinPercentage) {
        this.eventId = eventId;
        this.homeTeamId = homeTeamId;
        this.homeTeamInitials = homeTeamInitials;
        this.homeTeamShortName = homeTeamShortName;
        this.homeTeamLongName = homeTeamLongName;
        this.homeTeamWinPercentage = homeTeamWinPercentage;
        this.awayTeamId = awayTeamId;
        this.awayTeamInitials = awayTeamInitials;
        this.awayTeamShortName = awayTeamShortName;
        this.awayTeamLongName = awayTeamLongName;
        this.awayTeamWinPercentage = awayTeamWinPercentage;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getHomeTeamId() {
        return homeTeamId;
    }

    public void setHomeTeamId(String homeTeamId) {
        this.homeTeamId = homeTeamId;
    }

    public String getHomeTeamInitials() {
        return homeTeamInitials;
    }

    public void setHomeTeamInitials(String homeTeamInitials) {
        this.homeTeamInitials = homeTeamInitials;
    }

    public String getHomeTeamShortName() {
        return homeTeamShortName;
    }

    public void setHomeTeamShortName(String homeTeamShortName) {
        this.homeTeamShortName = homeTeamShortName;
    }

    public String getHomeTeamLongName() {
        return homeTeamLongName;
    }

    public void setHomeTeamLongName(String homeTeamLongName) {
        this.homeTeamLongName = homeTeamLongName;
    }

    public String getHomeTeamWinPercentage() {
        return homeTeamWinPercentage;
    }

    public void setHomeTeamWinPercentage(String homeTeamWinPercentage) {
        this.homeTeamWinPercentage = homeTeamWinPercentage;
    }

    public String getAwayTeamId() {
        return awayTeamId;
    }

    public void setAwayTeamId(String awayTeamId) {
        this.awayTeamId = awayTeamId;
    }

    public String getAwayTeamInitials() {
        return awayTeamInitials;
    }

    public void setAwayTeamInitials(String awayTeamInitials) {
        this.awayTeamInitials = awayTeamInitials;
    }

    public String getAwayTeamShortName() {
        return awayTeamShortName;
    }

    public void setAwayTeamShortName(String awayTeamShortName) {
        this.awayTeamShortName = awayTeamShortName;
    }

    public String getAwayTeamLongName() {
        return awayTeamLongName;
    }

    public void setAwayTeamLongName(String awayTeamLongName) {
        this.awayTeamLongName = awayTeamLongName;
    }

    public String getAwayTeamWinPercentage() {
        return awayTeamWinPercentage;
    }

    public void setAwayTeamWinPercentage(String awayTeamWinPercentage) {
        this.awayTeamWinPercentage = awayTeamWinPercentage;
    }
}
