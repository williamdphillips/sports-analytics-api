package com.phillips.sportsanalytics.response.odds;

import lombok.Data;

@Data
public class HomeTeamOdds{
	private double spreadOdds;
	private boolean underdog;
	private Team team;
	private boolean favorite;
	private int moneyLine;
	private double averageScore;
	private SpreadRecord spreadRecord;
	private PastPerformances pastPerformances;
}