package com.phillips.sportsanalytics.model.simple;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SimpleGame {

    String displayClock;
    String displayClockDetail;
    String shortDetail;
    String description;
    Boolean isCompleted;
    String eventId;
    String week;
    String state;

    String homeTeamDisplayName;
    String homeTeamShortName;
    String homeTeamScore;
    String homeTeamColor;
    String homeTeamLogoURL;
    String homeTeamInitials;
    String homeTeamRecord;

    String awayTeamDisplayName;
    String awayTeamShortName;
    String awayTeamScore;
    String awayTeamColor;
    String awayTeamLogoURL;
    String awayTeamInitials;
    String awayTeamRecord;

    @JsonCreator
    public SimpleGame(@JsonProperty("displayClock") String displayClock,
                      @JsonProperty("displayClockDetail") String displayClockDetail,
                      @JsonProperty("shortDetail") String shortDetail,
                      @JsonProperty("description") String description,
                      @JsonProperty("eventId") String eventId,
                      @JsonProperty("isCompleted") Boolean isCompleted,
                      @JsonProperty("homeTeamDisplayName") String homeTeamDisplayName,
                      @JsonProperty("homeTeamShortName") String homeTeamShortName,
                      @JsonProperty("homeTeamScore") String homeTeamScore,
                      @JsonProperty("homeTeamColor") String homeTeamColor,
                      @JsonProperty("homeTeamLogoURL") String homeTeamLogoURL,
                      @JsonProperty("homeTeamDisplayName") String awayTeamDisplayName,
                      @JsonProperty("homeTeamShortName") String awayTeamShortName,
                      @JsonProperty("homeTeamScore") String awayTeamScore,
                      @JsonProperty("homeTeamColor") String awayTeamColor,
                      @JsonProperty("homeTeamLogoURL") String awayTeamLogoURL,
                      @JsonProperty String homeTeamInitials,
                      @JsonProperty String awayTeamInitials,
                      @JsonProperty String homeTeamRecord,
                      @JsonProperty String awayTeamRecord,
                      @JsonProperty String week,
                      @JsonProperty String state){
        this.displayClock = displayClock;
        this.displayClockDetail = displayClockDetail;
        this.shortDetail = shortDetail;
        this.description = description;
        this.eventId = eventId;
        this.isCompleted = isCompleted;
        this.homeTeamDisplayName = homeTeamDisplayName;
        this.homeTeamShortName = homeTeamShortName;
        this.homeTeamScore = homeTeamScore;
        this.homeTeamColor = homeTeamColor;
        this.homeTeamLogoURL = homeTeamLogoURL;
        this.awayTeamDisplayName = awayTeamDisplayName;
        this.awayTeamShortName = awayTeamShortName;
        this.awayTeamScore = awayTeamScore;
        this.awayTeamColor = awayTeamColor;
        this.awayTeamLogoURL = awayTeamLogoURL;
        this.homeTeamInitials = homeTeamInitials;
        this.awayTeamInitials = awayTeamInitials;
        this.homeTeamRecord = homeTeamRecord;
        this.awayTeamRecord = awayTeamRecord;
        this.week = week;
        this.state = state;
    }

    public SimpleGame(){}

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getHomeTeamRecord() {
        return homeTeamRecord;
    }

    public void setHomeTeamRecord(String homeTeamRecord) {
        this.homeTeamRecord = homeTeamRecord;
    }

    public String getAwayTeamRecord() {
        return awayTeamRecord;
    }

    public void setAwayTeamRecord(String awayTeamRecord) {
        this.awayTeamRecord = awayTeamRecord;
    }

    public String getHomeTeamInitials() {
        return homeTeamInitials;
    }

    public void setHomeTeamInitials(String homeTeamInitials) {
        this.homeTeamInitials = homeTeamInitials;
    }

    public String getAwayTeamInitials() {
        return awayTeamInitials;
    }

    public void setAwayTeamInitials(String awayTeamInitials) {
        this.awayTeamInitials = awayTeamInitials;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setHomeTeamLogoURL(String homeTeamLogoURL) {
        this.homeTeamLogoURL = homeTeamLogoURL;
    }

    public void setAwayTeamLogoURL(String awayTeamLogoURL) {
        this.awayTeamLogoURL = awayTeamLogoURL;
    }

    public String getShortDetail() {
        return shortDetail;
    }

    public void setShortDetail(String shortDetail) {
        this.shortDetail = shortDetail;
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

    public Boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }

    public String getHomeTeamDisplayName() {
        return homeTeamDisplayName;
    }

    public void setHomeTeamDisplayName(String homeTeamDisplayName) {
        this.homeTeamDisplayName = homeTeamDisplayName;
    }

    public String getHomeTeamShortName() {
        return homeTeamShortName;
    }

    public void setHomeTeamShortName(String homeTeamShortName) {
        this.homeTeamShortName = homeTeamShortName;
    }

    public String getHomeTeamScore() {
        return homeTeamScore;
    }

    public void setHomeTeamScore(String homeTeamScore) {
        this.homeTeamScore = homeTeamScore;
    }

    public String getHomeTeamColor() {
        return homeTeamColor;
    }

    public void setHomeTeamColor(String homeTeamColor) {
        this.homeTeamColor = homeTeamColor;
    }

    public String getHomeTeamLogoURL() {
        return homeTeamLogoURL;
    }

    public void setHomeTeamLogoLoc(String homeTeamLogoURL) {
        this.homeTeamLogoURL = homeTeamLogoURL;
    }

    public String getAwayTeamDisplayName() {
        return awayTeamDisplayName;
    }

    public void setAwayTeamDisplayName(String awayTeamDisplayName) {
        this.awayTeamDisplayName = awayTeamDisplayName;
    }

    public String getAwayTeamShortName() {
        return awayTeamShortName;
    }

    public void setAwayTeamShortName(String awayTeamShortName) {
        this.awayTeamShortName = awayTeamShortName;
    }

    public String getAwayTeamScore() {
        return awayTeamScore;
    }

    public void setAwayTeamScore(String awayTeamScore) {
        this.awayTeamScore = awayTeamScore;
    }

    public String getAwayTeamColor() {
        return awayTeamColor;
    }

    public void setAwayTeamColor(String awayTeamColor) {
        this.awayTeamColor = awayTeamColor;
    }

    public String getAwayTeamLogoURL() {
        return awayTeamLogoURL;
    }

    public void setAwayTeamLogoLoc(String awayTeamLogoURL) {
        this.awayTeamLogoURL = awayTeamLogoURL;
    }
}
