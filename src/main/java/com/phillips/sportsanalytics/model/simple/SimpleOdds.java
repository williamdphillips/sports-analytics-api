package com.phillips.sportsanalytics.model.simple;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
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
}
