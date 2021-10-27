package com.phillips.sportsanalytics.response.prediction;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class HomeTeam{

	@JsonProperty("team")
	private Team team;

	@JsonProperty("statistics")
	private List<StatisticsItem> statistics;

	public void setTeam(Team team){
		this.team = team;
	}

	public Team getTeam(){
		return team;
	}

	public void setStatistics(List<StatisticsItem> statistics){
		this.statistics = statistics;
	}

	public List<StatisticsItem> getStatistics(){
		return statistics;
	}
}