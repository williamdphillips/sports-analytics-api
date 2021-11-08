package com.phillips.sportsanalytics.response.week;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ScheduleResponse {

	@JsonProperty("endDate")
	private String endDate;

	@JsonProperty("season")
	private Season season;

	@JsonProperty("type")
	private String type;

	@JsonProperty("$ref")
	private String ref;

	@JsonProperty("startDate")
	private String startDate;

	@JsonProperty("sections")
	private List<SectionsItem> sections;

	@JsonProperty("eventDate")
	private EventDate eventDate;

	public void setEndDate(String endDate){
		this.endDate = endDate;
	}

	public String getEndDate(){
		return endDate;
	}

	public void setSeason(Season season){
		this.season = season;
	}

	public Season getSeason(){
		return season;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setRef(String ref){
		this.ref = ref;
	}

	public String getRef(){
		return ref;
	}

	public void setStartDate(String startDate){
		this.startDate = startDate;
	}

	public String getStartDate(){
		return startDate;
	}

	public void setSections(List<SectionsItem> sections){
		this.sections = sections;
	}

	public List<SectionsItem> getSections(){
		return sections;
	}

	public void setEventDate(EventDate eventDate){
		this.eventDate = eventDate;
	}

	public EventDate getEventDate(){
		return eventDate;
	}
}