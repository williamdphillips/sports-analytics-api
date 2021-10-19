package com.phillips.sportsanalytics.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SimpleGame {

    String displayClock;
    String displayClockDetail;
    Boolean isCompleted;

    String homeTeamDisplayName;
    String homeTeamShortName;
    String homeTeamScore;
    String homeTeamColor;
    String homeTeamLogoURL;

    String awayTeamDisplayName;
    String awayTeamShortName;
    String awayTeamScore;
    String awayTeamColor;
    String awayTeamLogoURL;

    @JsonCreator
    public SimpleGame(@JsonProperty("displayClock") String displayClock,
                      @JsonProperty("displayClockDetail") String displayClockDetail,
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
                      @JsonProperty("homeTeamLogoURL") String awayTeamLogoURL){
        this.displayClock = displayClock;
        this.displayClockDetail = displayClockDetail;
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
    }

    public SimpleGame(){}

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
