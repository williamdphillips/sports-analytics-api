package com.phillips.sportsanalytics.response.odds;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SpreadRecord{

	@JsonProperty("wins")
	private int wins;

	@JsonProperty("summary")
	private String summary;

	@JsonProperty("losses")
	private int losses;

	@JsonProperty("pushes")
	private int pushes;

	public void setWins(int wins){
		this.wins = wins;
	}

	public int getWins(){
		return wins;
	}

	public void setSummary(String summary){
		this.summary = summary;
	}

	public String getSummary(){
		return summary;
	}

	public void setLosses(int losses){
		this.losses = losses;
	}

	public int getLosses(){
		return losses;
	}

	public void setPushes(int pushes){
		this.pushes = pushes;
	}

	public int getPushes(){
		return pushes;
	}
}