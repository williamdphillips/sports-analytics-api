package com.phillips.sportsanalytics.response.winprobability;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemsItem{

	@JsonProperty("play")
	private Play play;

	@JsonProperty("homeWinPercentage")
	private double homeWinPercentage;

	@JsonProperty("sequenceNumber")
	private String sequenceNumber;

	@JsonProperty("awayWinPercentage")
	private double awayWinPercentage;

	@JsonProperty("awayTeam")
	private AwayTeam awayTeam;

	@JsonProperty("homeTeam")
	private HomeTeam homeTeam;

	@JsonProperty("competition")
	private Competition competition;

	@JsonProperty("lastModified")
	private String lastModified;

	@JsonProperty("source")
	private Source source;

	@JsonProperty("tiePercentage")
	private double tiePercentage;

	@JsonProperty("secondsLeft")
	private int secondsLeft;

	@JsonProperty("$ref")
	private String ref;

	public void setPlay(Play play){
		this.play = play;
	}

	public Play getPlay(){
		return play;
	}

	public void setHomeWinPercentage(double homeWinPercentage){
		this.homeWinPercentage = homeWinPercentage;
	}

	public double getHomeWinPercentage(){
		return homeWinPercentage;
	}

	public void setSequenceNumber(String sequenceNumber){
		this.sequenceNumber = sequenceNumber;
	}

	public String getSequenceNumber(){
		return sequenceNumber;
	}

	public void setAwayWinPercentage(double awayWinPercentage){
		this.awayWinPercentage = awayWinPercentage;
	}

	public double getAwayWinPercentage(){
		return awayWinPercentage;
	}

	public void setAwayTeam(AwayTeam awayTeam){
		this.awayTeam = awayTeam;
	}

	public AwayTeam getAwayTeam(){
		return awayTeam;
	}

	public void setHomeTeam(HomeTeam homeTeam){
		this.homeTeam = homeTeam;
	}

	public HomeTeam getHomeTeam(){
		return homeTeam;
	}

	public void setCompetition(Competition competition){
		this.competition = competition;
	}

	public Competition getCompetition(){
		return competition;
	}

	public void setLastModified(String lastModified){
		this.lastModified = lastModified;
	}

	public String getLastModified(){
		return lastModified;
	}

	public void setSource(Source source){
		this.source = source;
	}

	public Source getSource(){
		return source;
	}

	public void setTiePercentage(double tiePercentage){
		this.tiePercentage = tiePercentage;
	}

	public double getTiePercentage(){
		return tiePercentage;
	}

	public void setSecondsLeft(int secondsLeft){
		this.secondsLeft = secondsLeft;
	}

	public int getSecondsLeft(){
		return secondsLeft;
	}

	public void setRef(String ref){
		this.ref = ref;
	}

	public String getRef(){
		return ref;
	}
}