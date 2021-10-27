package com.phillips.sportsanalytics.response.odds;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AwayTeamOdds{

	@JsonProperty("spreadOdds")
	private double spreadOdds;

	@JsonProperty("underdog")
	private boolean underdog;

	@JsonProperty("spreadRecord")
	private SpreadRecord spreadRecord;

	@JsonProperty("pastPerformances")
	private PastPerformances pastPerformances;

	@JsonProperty("team")
	private Team team;

	@JsonProperty("favorite")
	private boolean favorite;

	@JsonProperty("moneyLine")
	private int moneyLine;

	@JsonProperty("averageScore")
	private double averageScore;

	public void setSpreadOdds(double spreadOdds){
		this.spreadOdds = spreadOdds;
	}

	public double getSpreadOdds(){
		return spreadOdds;
	}

	public void setUnderdog(boolean underdog){
		this.underdog = underdog;
	}

	public boolean isUnderdog(){
		return underdog;
	}

	public void setSpreadRecord(SpreadRecord spreadRecord){
		this.spreadRecord = spreadRecord;
	}

	public SpreadRecord getSpreadRecord(){
		return spreadRecord;
	}

	public void setPastPerformances(PastPerformances pastPerformances){
		this.pastPerformances = pastPerformances;
	}

	public PastPerformances getPastPerformances(){
		return pastPerformances;
	}

	public void setTeam(Team team){
		this.team = team;
	}

	public Team getTeam(){
		return team;
	}

	public void setFavorite(boolean favorite){
		this.favorite = favorite;
	}

	public boolean isFavorite(){
		return favorite;
	}

	public void setMoneyLine(int moneyLine){
		this.moneyLine = moneyLine;
	}

	public int getMoneyLine(){
		return moneyLine;
	}

	public void setAverageScore(double averageScore){
		this.averageScore = averageScore;
	}

	public double getAverageScore(){
		return averageScore;
	}
}