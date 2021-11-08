package com.phillips.sportsanalytics.response.week;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EventDate{

	@JsonProperty("dates")
	private List<String> dates;

	@JsonProperty("type")
	private String type;

	public void setDates(List<String> dates){
		this.dates = dates;
	}

	public List<String> getDates(){
		return dates;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}
}