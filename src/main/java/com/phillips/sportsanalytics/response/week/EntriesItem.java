package com.phillips.sportsanalytics.response.week;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EntriesItem{

	@JsonProperty("endDate")
	private String endDate;

	@JsonProperty("alternateLabel")
	private String alternateLabel;

	@JsonProperty("label")
	private String label;

	@JsonProperty("detail")
	private String detail;

	@JsonProperty("value")
	private String value;

	@JsonProperty("startDate")
	private String startDate;

	public void setEndDate(String endDate){
		this.endDate = endDate;
	}

	public String getEndDate(){
		return endDate;
	}

	public void setAlternateLabel(String alternateLabel){
		this.alternateLabel = alternateLabel;
	}

	public String getAlternateLabel(){
		return alternateLabel;
	}

	public void setLabel(String label){
		this.label = label;
	}

	public String getLabel(){
		return label;
	}

	public void setDetail(String detail){
		this.detail = detail;
	}

	public String getDetail(){
		return detail;
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