package com.phillips.sportsanalytics.response.prediction;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PredictionResponse{

	@JsonProperty("awayTeam")
	private AwayTeam awayTeam;

	@JsonProperty("name")
	private String name;

	@JsonProperty("homeTeam")
	private HomeTeam homeTeam;

	@JsonProperty("lastModified")
	private String lastModified;

	@JsonProperty("shortName")
	private String shortName;

	@JsonProperty("$ref")
	private String ref;

	public void setAwayTeam(AwayTeam awayTeam){
		this.awayTeam = awayTeam;
	}

	public AwayTeam getAwayTeam(){
		return awayTeam;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setHomeTeam(HomeTeam homeTeam){
		this.homeTeam = homeTeam;
	}

	public HomeTeam getHomeTeam(){
		return homeTeam;
	}

	public void setLastModified(String lastModified){
		this.lastModified = lastModified;
	}

	public String getLastModified(){
		return lastModified;
	}

	public void setShortName(String shortName){
		this.shortName = shortName;
	}

	public String getShortName(){
		return shortName;
	}

	public void setRef(String ref){
		this.ref = ref;
	}

	public String getRef(){
		return ref;
	}
}