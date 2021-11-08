package com.phillips.sportsanalytics.response.week;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Season{

	@JsonProperty("$ref")
	private String ref;

	public void setRef(String ref){
		this.ref = ref;
	}

	public String getRef(){
		return ref;
	}
}