package com.phillips.sportsanalytics.model.simple;

public class SimpleOdds {
    private String eventId;

    private String details;
    private String overUnder;
    private String overOdds;
    private String underOdds;
    private String spread;

    private String awayTeamId;
    private String awayTeamAverageScore;
    private String awayTeamFavorite;
    private String awayTeamMoneyLine;
    private String awayTeamSpreadWins;
    private String awayTeamSpreadLosses;
    private String awayTeamSpreadSummary;
    private String awayTeamSpreadOdds;

    private String homeTeamId;
    private String homeTeamAverageScore;
    private String homeTeamFavorite;
    private String homeTeamMoneyLine;
    private String homeTeamSpreadWins;
    private String homeTeamSpreadLosses;
    private String homeTeamSpreadSummary;
    private String homeTeamSpreadOdds;

    public SimpleOdds(){

    }

    public SimpleOdds(String spread, String eventId, String details, String overUnder, String overOdds, String underOdds, String awayTeamId, String awayTeamAverageScore, String awayTeamFavorite, String awayTeamMoneyLine, String awayTeamSpreadWins, String awayTeamSpreadLosses, String awayTeamSpreadSummary, String awayTeamSpreadOdds, String homeTeamId, String homeTeamAverageScore, String homeTeamFavorite, String homeTeamMoneyLine, String homeTeamSpreadWins, String homeTeamSpreadLosses, String homeTeamSpreadSummary, String homeTeamSpreadOdds) {
        this.spread = spread;
        this.eventId = eventId;
        this.details = details;
        this.overUnder = overUnder;
        this.overOdds = overOdds;
        this.underOdds = underOdds;
        this.awayTeamId = awayTeamId;
        this.awayTeamAverageScore = awayTeamAverageScore;
        this.awayTeamFavorite = awayTeamFavorite;
        this.awayTeamMoneyLine = awayTeamMoneyLine;
        this.awayTeamSpreadWins = awayTeamSpreadWins;
        this.awayTeamSpreadLosses = awayTeamSpreadLosses;
        this.awayTeamSpreadSummary = awayTeamSpreadSummary;
        this.awayTeamSpreadOdds = awayTeamSpreadOdds;
        this.homeTeamId = homeTeamId;
        this.homeTeamAverageScore = homeTeamAverageScore;
        this.homeTeamFavorite = homeTeamFavorite;
        this.homeTeamMoneyLine = homeTeamMoneyLine;
        this.homeTeamSpreadWins = homeTeamSpreadWins;
        this.homeTeamSpreadLosses = homeTeamSpreadLosses;
        this.homeTeamSpreadSummary = homeTeamSpreadSummary;
        this.homeTeamSpreadOdds = homeTeamSpreadOdds;
    }

    public String getSpread() {
        return spread;
    }

    public void setSpread(String spread) {
        this.spread = spread;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
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

    public String getUnderOdds() {
        return underOdds;
    }

    public void setUnderOdds(String underOdds) {
        this.underOdds = underOdds;
    }

    public String getAwayTeamId() {
        return awayTeamId;
    }

    public void setAwayTeamId(String awayTeamId) {
        this.awayTeamId = awayTeamId;
    }

    public String getAwayTeamAverageScore() {
        return awayTeamAverageScore;
    }

    public void setAwayTeamAverageScore(String awayTeamAverageScore) {
        this.awayTeamAverageScore = awayTeamAverageScore;
    }

    public String getAwayTeamFavorite() {
        return awayTeamFavorite;
    }

    public void setAwayTeamFavorite(String awayTeamFavorite) {
        this.awayTeamFavorite = awayTeamFavorite;
    }

    public String getAwayTeamMoneyLine() {
        return awayTeamMoneyLine;
    }

    public void setAwayTeamMoneyLine(String awayTeamMoneyLine) {
        this.awayTeamMoneyLine = awayTeamMoneyLine;
    }

    public String getAwayTeamSpreadWins() {
        return awayTeamSpreadWins;
    }

    public void setAwayTeamSpreadWins(String awayTeamSpreadWins) {
        this.awayTeamSpreadWins = awayTeamSpreadWins;
    }

    public String getAwayTeamSpreadLosses() {
        return awayTeamSpreadLosses;
    }

    public void setAwayTeamSpreadLosses(String awayTeamSpreadLosses) {
        this.awayTeamSpreadLosses = awayTeamSpreadLosses;
    }

    public String getAwayTeamSpreadSummary() {
        return awayTeamSpreadSummary;
    }

    public void setAwayTeamSpreadSummary(String awayTeamSpreadSummary) {
        this.awayTeamSpreadSummary = awayTeamSpreadSummary;
    }

    public String getAwayTeamSpreadOdds() {
        return awayTeamSpreadOdds;
    }

    public void setAwayTeamSpreadOdds(String awayTeamSpreadOdds) {
        this.awayTeamSpreadOdds = awayTeamSpreadOdds;
    }

    public String getHomeTeamId() {
        return homeTeamId;
    }

    public void setHomeTeamId(String homeTeamId) {
        this.homeTeamId = homeTeamId;
    }

    public String getHomeTeamAverageScore() {
        return homeTeamAverageScore;
    }

    public void setHomeTeamAverageScore(String homeTeamAverageScore) {
        this.homeTeamAverageScore = homeTeamAverageScore;
    }

    public String getHomeTeamFavorite() {
        return homeTeamFavorite;
    }

    public void setHomeTeamFavorite(String homeTeamFavorite) {
        this.homeTeamFavorite = homeTeamFavorite;
    }

    public String getHomeTeamMoneyLine() {
        return homeTeamMoneyLine;
    }

    public void setHomeTeamMoneyLine(String homeTeamMoneyLine) {
        this.homeTeamMoneyLine = homeTeamMoneyLine;
    }

    public String getHomeTeamSpreadWins() {
        return homeTeamSpreadWins;
    }

    public void setHomeTeamSpreadWins(String homeTeamSpreadWins) {
        this.homeTeamSpreadWins = homeTeamSpreadWins;
    }

    public String getHomeTeamSpreadLosses() {
        return homeTeamSpreadLosses;
    }

    public void setHomeTeamSpreadLosses(String homeTeamSpreadLosses) {
        this.homeTeamSpreadLosses = homeTeamSpreadLosses;
    }

    public String getHomeTeamSpreadSummary() {
        return homeTeamSpreadSummary;
    }

    public void setHomeTeamSpreadSummary(String homeTeamSpreadSummary) {
        this.homeTeamSpreadSummary = homeTeamSpreadSummary;
    }

    public String getHomeTeamSpreadOdds() {
        return homeTeamSpreadOdds;
    }

    public void setHomeTeamSpreadOdds(String homeTeamSpreadOdds) {
        this.homeTeamSpreadOdds = homeTeamSpreadOdds;
    }
}
