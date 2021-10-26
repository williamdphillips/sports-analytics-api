package com.phillips.sportsanalytics.response.winprobability;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Source{

	@JsonProperty("description")
	private String description;

	@JsonProperty("id")
	private String id;

	@JsonProperty("state")
	private String state;

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setState(String state){
		this.state = state;
	}

	public String getState(){
		return state;
	}
}