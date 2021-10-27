package com.phillips.sportsanalytics.response.prediction;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Team{

	@JsonProperty("$ref")
	private String ref;

	public void setRef(String ref){
		this.ref = ref;
	}

	public String getRef(){
		return ref;
	}
}