package com.phillips.sportsanalytics.model;

public class Play {
    private String driveDescription;
    private String playDescription;
    private Team teamInPossession;
    private String downDistanceText;
    private String downDistanceShortText;
    private long down;
    private long yardLine;
    private long firstDownDistance;
    private Boolean isScoringPlay;
    private String possessionText;

    public Play(){

    }

    public String getPossessionText() {
        return possessionText;
    }

    public void setPossessionText(String possessionText) {
        this.possessionText = possessionText;
    }

    public String getDriveDescription() {
        return driveDescription;
    }

    public void setDriveDescription(String driveDescription) {
        this.driveDescription = driveDescription;
    }

    public String getPlayDescription() {
        return playDescription;
    }

    public void setPlayDescription(String playDescription) {
        this.playDescription = playDescription;
    }

    public Team getTeamInPossession() {
        return teamInPossession;
    }

    public void setTeamInPossession(Team teamInPossession) {
        this.teamInPossession = teamInPossession;
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

    public long getDown() {
        return down;
    }

    public void setDown(long down) {
        this.down = down;
    }

    public long getYardLine() {
        return yardLine;
    }

    public void setYardLine(long yardLine) {
        this.yardLine = yardLine;
    }

    public long getFirstDownDistance() {
        return firstDownDistance;
    }

    public void setFirstDownDistance(long firstDownDistance) {
        this.firstDownDistance = firstDownDistance;
    }

    public Boolean getScoringPlay() {
        return isScoringPlay;
    }

    public void setScoringPlay(Boolean scoringPlay) {
        isScoringPlay = scoringPlay;
    }
}
