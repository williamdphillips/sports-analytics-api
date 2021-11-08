package com.phillips.sportsanalytics.response.week;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SectionsItem{

	@JsonProperty("seasonType")
	private SeasonType seasonType;

	@JsonProperty("entries")
	private List<EntriesItem> entries;

	@JsonProperty("endDate")
	private String endDate;

	@JsonProperty("label")
	private String label;

	@JsonProperty("value")
	private String value;

	@JsonProperty("startDate")
	private String startDate;

	public void setSeasonType(SeasonType seasonType){
		this.seasonType = seasonType;
	}

	public SeasonType getSeasonType(){
		return seasonType;
	}

	public void setEntries(List<EntriesItem> entries){
		this.entries = entries;
	}

	public List<EntriesItem> getEntries(){
		return entries;
	}

	public void setEndDate(String endDate){
		this.endDate = endDate;
	}

	public String getEndDate(){
		return endDate;
	}

	public void setLabel(String label){
		this.label = label;
	}

	public String getLabel(){
		return label;
	}

	public void setValue(String value){
		this.value = value;
	}

	public String getValue(){
		return value;
	}

	public void setStartDate(String startDate){
		this.startDate = startDate;
	}

	public String getStartDate(){
		return startDate;
	}
}