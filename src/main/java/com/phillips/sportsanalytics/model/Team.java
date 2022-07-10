package com.phillips.sportsanalytics.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
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
    private double winPrediction;
    private double oppStrengthRating;
    private double oppPointDifference;

    //Probability
    private double winPercentage;

}
