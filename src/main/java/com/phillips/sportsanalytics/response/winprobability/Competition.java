package com.phillips.sportsanalytics.response.winprobability;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Competition{

	@JsonProperty("$ref")
	private String ref;

	public void setRef(String ref){
		this.ref = ref;
	}

	public String getRef(){
		return ref;
	}
}