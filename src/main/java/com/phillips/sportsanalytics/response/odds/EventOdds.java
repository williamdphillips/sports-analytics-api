package com.phillips.sportsanalytics.response.odds;

import java.util.List;
import lombok.Data;

@Data
public class EventOdds {
	private double underOdds;
	private double overUnder;
	private AwayTeamOdds awayTeamOdds;
	private boolean spreadWinner;
	private boolean moneylineWinner;
	private Provider provider;
	private String details;
	private List<Object> links;
	private String ref;
	private HomeTeamOdds homeTeamOdds;
	private double spread;
	private double overOdds;
}