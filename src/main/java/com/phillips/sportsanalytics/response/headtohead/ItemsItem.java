package com.phillips.sportsanalytics.response.headtohead;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemsItem{

	@JsonProperty("underOdds")
	private double underOdds;

	@JsonProperty("totalResult")
	private String totalResult;

	@JsonProperty("awayTeamOdds")
	private AwayTeamOdds awayTeamOdds;

	@JsonProperty("lineDate")
	private String lineDate;

	@JsonProperty("spreadWinner")
	private boolean spreadWinner;

	@JsonProperty("moneylineWinner")
	private boolean moneylineWinner;

	@JsonProperty("totalLine")
	private double totalLine;

	@JsonProperty("homeTeamOdds")
	private HomeTeamOdds homeTeamOdds;

	@JsonProperty("spread")
	private double spread;

	@JsonProperty("overOdds")
	private double overOdds;

	public void setUnderOdds(double underOdds){
		this.underOdds = underOdds;
	}

	public double getUnderOdds(){
		return underOdds;
	}

	public void setTotalResult(String totalResult){
		this.totalResult = totalResult;
	}

	public String getTotalResult(){
		return totalResult;
	}

	public void setAwayTeamOdds(AwayTeamOdds awayTeamOdds){
		this.awayTeamOdds = awayTeamOdds;
	}

	public AwayTeamOdds getAwayTeamOdds(){
		return awayTeamOdds;
	}

	public void setLineDate(String lineDate){
		this.lineDate = lineDate;
	}

	public String getLineDate(){
		return lineDate;
	}

	public void setSpreadWinner(boolean spreadWinner){
		this.spreadWinner = spreadWinner;
	}

	public boolean isSpreadWinner(){
		return spreadWinner;
	}

	public void setMoneylineWinner(boolean moneylineWinner){
		this.moneylineWinner = moneylineWinner;
	}

	public boolean isMoneylineWinner(){
		return moneylineWinner;
	}

	public void setTotalLine(double totalLine){
		this.totalLine = totalLine;
	}

	public double getTotalLine(){
		return totalLine;
	}

	public void setHomeTeamOdds(HomeTeamOdds homeTeamOdds){
		this.homeTeamOdds = homeTeamOdds;
	}

	public HomeTeamOdds getHomeTeamOdds(){
		return homeTeamOdds;
	}

	public void setSpread(double spread){
		this.spread = spread;
	}

	public double getSpread(){
		return spread;
	}

	public void setOverOdds(double overOdds){
		this.overOdds = overOdds;
	}

	public double getOverOdds(){
		return overOdds;
	}
}