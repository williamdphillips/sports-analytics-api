package com.phillips.sportsanalytics.model;

public class Team {
    private String id;
    private String abbrev;
    private String shortName;
    private String displayName;
    private String wins;
    private String losses;
    private String record;
    private String primaryColor;
    private String logoURL;

    //Odds
    private double averageScore;
    private boolean isFavorite;
    private double moneyLine;
    private int spreadWins;
    private int spreadLosses;
    private String spreadSummary;
    private double spreadOdds;

    //Game
    private String currentScore;

    //Prediction
    private double chanceWin;
    private double oppStrengthRating;
    private double oppPointDifference;

    //Probability
    private double winPercentage;

    public Team(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAbbrev() {
        return abbrev;
    }

    public void setAbbrev(String abbrev) {
        this.abbrev = abbrev;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getWins() {
        return wins;
    }

    public void setWins(String wins) {
        this.wins = wins;
    }

    public String getLosses() {
        return losses;
    }

    public void setLosses(String losses) {
        this.losses = losses;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public String getPrimaryColor() {
        return primaryColor;
    }

    public void setPrimaryColor(String primaryColor) {
        this.primaryColor = primaryColor;
    }

    public String getLogoURL() {
        return logoURL;
    }

    public void setLogoURL(String logoURL) {
        this.logoURL = logoURL;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public double getMoneyLine() {
        return moneyLine;
    }

    public void setMoneyLine(double moneyLine) {
        this.moneyLine = moneyLine;
    }

    public int getSpreadWins() {
        return spreadWins;
    }

    public void setSpreadWins(int spreadWins) {
        this.spreadWins = spreadWins;
    }

    public int getSpreadLosses() {
        return spreadLosses;
    }

    public void setSpreadLosses(int spreadLosses) {
        this.spreadLosses = spreadLosses;
    }

    public String getSpreadSummary() {
        return spreadSummary;
    }

    public void setSpreadSummary(String spreadSummary) {
        this.spreadSummary = spreadSummary;
    }

    public double getSpreadOdds() {
        return spreadOdds;
    }

    public void setSpreadOdds(double spreadOdds) {
        this.spreadOdds = spreadOdds;
    }

    public String getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(String currentScore) {
        this.currentScore = currentScore;
    }

    public double getChanceWin() {
        return chanceWin;
    }

    public void setChanceWin(double chanceWin) {
        this.chanceWin = chanceWin;
    }

    public double getOppStrengthRating() {
        return oppStrengthRating;
    }

    public void setOppStrengthRating(double oppStrengthRating) {
        this.oppStrengthRating = oppStrengthRating;
    }

    public double getOppPointDifference() {
        return oppPointDifference;
    }

    public void setOppPointDifference(double oppPointDifference) {
        this.oppPointDifference = oppPointDifference;
    }

    public double getWinPercentage() {
        return winPercentage;
    }

    public void setWinPercentage(double winPercentage) {
        this.winPercentage = winPercentage;
    }
}
