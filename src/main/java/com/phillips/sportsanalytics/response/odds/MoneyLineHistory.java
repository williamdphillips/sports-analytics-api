package com.phillips.sportsanalytics.response.odds;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MoneyLineHistory {

	@JsonProperty("$ref")
	private String ref;

	public void setRef(String ref){
		this.ref = ref;
	}

	public String getRef(){
		return ref;
	}
}