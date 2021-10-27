package com.phillips.sportsanalytics.response.prediction;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StatisticsItem{

	@JsonProperty("shortDisplayName")
	private String shortDisplayName;

	@JsonProperty("displayValue")
	private String displayValue;

	@JsonProperty("displayName")
	private String displayName;

	@JsonProperty("name")
	private String name;

	@JsonProperty("description")
	private String description;

	@JsonProperty("abbreviation")
	private String abbreviation;

	@JsonProperty("value")
	private double value;

	public void setShortDisplayName(String shortDisplayName){
		this.shortDisplayName = shortDisplayName;
	}

	public String getShortDisplayName(){
		return shortDisplayName;
	}

	public void setDisplayValue(String displayValue){
		this.displayValue = displayValue;
	}

	public String getDisplayValue(){
		return displayValue;
	}

	public void setDisplayName(String displayName){
		this.displayName = displayName;
	}

	public String getDisplayName(){
		return displayName;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setAbbreviation(String abbreviation){
		this.abbreviation = abbreviation;
	}

	public String getAbbreviation(){
		return abbreviation;
	}

	public void setValue(double value){
		this.value = value;
	}

	public double getValue(){
		return value;
	}
}