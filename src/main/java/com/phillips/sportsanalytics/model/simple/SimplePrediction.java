package com.phillips.sportsanalytics.model.simple;

public class SimplePrediction {

    private String eventId;
    private String homeTeamId;
    private String homeTeamDisplayName;
    private String homeTeamInitials;
    private String homeTeamChanceLoss;
    private String homeOppStrengthRating;
    private String homeOppPointDifference;

    private String awayTeamId;
    private String awayTeamDisplayName;
    private String awayTeamInitials;
    private String awayTeamChanceLoss;
    private String awayOppStrengthRating;
    private String awayOppPointDifference;

    public SimplePrediction(){

    }

    public SimplePrediction(String homeTeamInitials, String awayTeamInitials, String eventId, String homeTeamId, String homeTeamDisplayName, String homeTeamChanceLoss, String homeOppStrengthRating, String homeOppPointDifference, String awayTeamId, String awayTeamDisplayName, String awayTeamChanceLoss, String awayOppStrengthRating, String awayOppPointDifference) {
        this.eventId = eventId;
        this.homeTeamId = homeTeamId;
        this.homeTeamDisplayName = homeTeamDisplayName;
        this.homeTeamChanceLoss = homeTeamChanceLoss;
        this.homeOppStrengthRating = homeOppStrengthRating;
        this.homeOppPointDifference = homeOppPointDifference;
        this.awayTeamId = awayTeamId;
        this.awayTeamDisplayName = awayTeamDisplayName;
        this.awayTeamChanceLoss = awayTeamChanceLoss;
        this.awayOppStrengthRating = awayOppStrengthRating;
        this.awayOppPointDifference = awayOppPointDifference;
        this.homeTeamInitials = homeTeamInitials;
        this.awayTeamInitials = awayTeamInitials;
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

    public String getHomeTeamId() {
        return homeTeamId;
    }

    public void setHomeTeamId(String homeTeamId) {
        this.homeTeamId = homeTeamId;
    }

    public String getHomeTeamDisplayName() {
        return homeTeamDisplayName;
    }

    public void setHomeTeamDisplayName(String homeTeamDisplayName) {
        this.homeTeamDisplayName = homeTeamDisplayName;
    }

    public String getHomeTeamChanceLoss() {
        return homeTeamChanceLoss;
    }

    public void setHomeTeamChanceLoss(String homeTeamChanceLoss) {
        this.homeTeamChanceLoss = homeTeamChanceLoss;
    }

    public String getHomeOppStrengthRating() {
        return homeOppStrengthRating;
    }

    public void setHomeOppStrengthRating(String homeOppStrengthRating) {
        this.homeOppStrengthRating = homeOppStrengthRating;
    }

    public String getHomeOppPointDifference() {
        return homeOppPointDifference;
    }

    public void setHomeOppPointDifference(String homeOppPointDifference) {
        this.homeOppPointDifference = homeOppPointDifference;
    }

    public String getAwayTeamId() {
        return awayTeamId;
    }

    public void setAwayTeamId(String awayTeamId) {
        this.awayTeamId = awayTeamId;
    }

    public String getAwayTeamDisplayName() {
        return awayTeamDisplayName;
    }

    public void setAwayTeamDisplayName(String awayTeamDisplayName) {
        this.awayTeamDisplayName = awayTeamDisplayName;
    }

    public String getAwayTeamChanceLoss() {
        return awayTeamChanceLoss;
    }

    public void setAwayTeamChanceLoss(String awayTeamChanceLoss) {
        this.awayTeamChanceLoss = awayTeamChanceLoss;
    }

    public String getAwayOppStrengthRating() {
        return awayOppStrengthRating;
    }

    public void setAwayOppStrengthRating(String awayOppStrengthRating) {
        this.awayOppStrengthRating = awayOppStrengthRating;
    }

    public String getAwayOppPointDifference() {
        return awayOppPointDifference;
    }

    public void setAwayOppPointDifference(String awayOppPointDifference) {
        this.awayOppPointDifference = awayOppPointDifference;
    }
}
