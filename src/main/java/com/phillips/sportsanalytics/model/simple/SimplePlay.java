package com.phillips.sportsanalytics.model.simple;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SimplePlay {
    private String driveDescription;
    private String latestPlay;
    private String teamInPossessionId;
    private String teamInPossessionLongName;
    private String downDistanceText;
    private String downDistanceShortText;
    private String down;
    private String yardLine;
    private String firstDownDistance;
    private Boolean isScoringPlay;
    private String eventId;
    private String possessionText;
    private String teamInPossessionInitials;

    public SimplePlay(){

    }

    @JsonCreator
    public SimplePlay(@JsonProperty String driveDescription,
                      @JsonProperty String latestPlay, String teamInPossessionId,
                      @JsonProperty String teamInPossessionLongName,
                      @JsonProperty String downDistanceText,
                      @JsonProperty String downDistanceShortText,
                      @JsonProperty String down,
                      @JsonProperty String yardLine,
                      @JsonProperty String firstDownDistance,
                      @JsonProperty Boolean isScoringPlay,
                      @JsonProperty String eventId,
                      @JsonProperty String possessionText,
                      @JsonProperty String teamInPossessionInitials) {
        this.driveDescription = driveDescription;
        this.latestPlay = latestPlay;
        this.teamInPossessionId = teamInPossessionId;
        this.teamInPossessionLongName = teamInPossessionLongName;
        this.downDistanceText = downDistanceText;
        this.downDistanceShortText = downDistanceShortText;
        this.down = down;
        this.yardLine = yardLine;
        this.firstDownDistance = firstDownDistance;
        this.isScoringPlay = isScoringPlay;
        this.eventId = eventId;
        this.possessionText = possessionText;
        this.teamInPossessionInitials = teamInPossessionInitials;
    }

    public String getPossessionText() {
        return possessionText;
    }

    public void setPossessionText(String possessionText) {
        this.possessionText = possessionText;
    }

    public String getTeamInPossessionInitials() {
        return teamInPossessionInitials;
    }

    public void setTeamInPossessionInitials(String teamInPossessionInitials) {
        this.teamInPossessionInitials = teamInPossessionInitials;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getDriveDescription() {
        return driveDescription;
    }

    public void setDriveDescription(String driveDescription) {
        this.driveDescription = driveDescription;
    }

    public String getLatestPlay() {
        return latestPlay;
    }

    public void setLatestPlay(String latestPlay) {
        this.latestPlay = latestPlay;
    }

    public String getTeamInPossessionId() {
        return teamInPossessionId;
    }

    public void setTeamInPossessionId(String teamInPossessionId) {
        this.teamInPossessionId = teamInPossessionId;
    }

    public String getTeamInPossessionLongName() {
        return teamInPossessionLongName;
    }

    public void setTeamInPossessionLongName(String teamInPossessionLongName) {
        this.teamInPossessionLongName = teamInPossessionLongName;
    }

    public String getDownDistanceText() {
        return downDistanceText;
    }

    public void setDownDistanceText(String downDistanceText) {
        this.downDistanceText = downDistanceText;
    }

    public String getDownDistanceShortText() {
        return downDistanceShortText;
    }

    public void setDownDistanceShortText(String downDistanceShortText) {
        this.downDistanceShortText = downDistanceShortText;
    }

    public String getDown() {
        return down;
    }

    public void setDown(String down) {
        this.down = down;
    }

    public String getYardLine() {
        return yardLine;
    }

    public void setYardLine(String yardLine) {
        this.yardLine = yardLine;
    }

    public String getFirstDownDistance() {
        return firstDownDistance;
    }

    public void setFirstDownDistance(String firstDownDistance) {
        this.firstDownDistance = firstDownDistance;
    }

    public Boolean getScoringPlay() {
        return isScoringPlay;
    }

    public void setScoringPlay(Boolean scoringPlay) {
        isScoringPlay = scoringPlay;
    }
}
