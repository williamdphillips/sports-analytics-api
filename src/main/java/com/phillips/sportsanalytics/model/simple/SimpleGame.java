package com.phillips.sportsanalytics.model.simple;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
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
}
