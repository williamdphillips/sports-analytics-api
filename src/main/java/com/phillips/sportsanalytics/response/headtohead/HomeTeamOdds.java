package com.phillips.sportsanalytics.response.headtohead;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HomeTeamOdds{

	@JsonProperty("moneyLineOdds")
	private double moneyLineOdds;

	@JsonProperty("spreadOdds")
	private double spreadOdds;

	@JsonProperty("spreadWinner")
	private boolean spreadWinner;

	@JsonProperty("moneyLineWinner")
	private boolean moneyLineWinner;

	public void setMoneyLineOdds(double moneyLineOdds){
		this.moneyLineOdds = moneyLineOdds;
	}

	public double getMoneyLineOdds(){
		return moneyLineOdds;
	}

	public void setSpreadOdds(double spreadOdds){
		this.spreadOdds = spreadOdds;
	}

	public double getSpreadOdds(){
		return spreadOdds;
	}

	public void setSpreadWinner(boolean spreadWinner){
		this.spreadWinner = spreadWinner;
	}

	public boolean isSpreadWinner(){
		return spreadWinner;
	}

	public void setMoneyLineWinner(boolean moneyLineWinner){
		this.moneyLineWinner = moneyLineWinner;
	}

	public boolean isMoneyLineWinner(){
		return moneyLineWinner;
	}
}