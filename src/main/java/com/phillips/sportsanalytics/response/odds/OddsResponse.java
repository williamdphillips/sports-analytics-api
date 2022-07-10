package com.phillips.sportsanalytics.response.odds;

import java.util.List;
import com.azure.spring.data.cosmos.core.mapping.Container;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Container(containerName = "NFL_Odds")
public class OddsResponse{
	@Id
	private String eventId;
	private double underOdds;
	private SpreadHistory spreadHistory;
	private AwayTeamOdds awayTeamOdds;
	private TotalHistory totalHistory;
	private double spread;
	private MoneyLineHistory moneyLineHistory;
	private double overUnder;
	private boolean spreadWinner;
	private boolean moneylineWinner;
	private Provider provider;
	private HeadToHeads headToHeads;
	private String details;
	private List<Object> links;
	@JsonProperty("$ref")
	private String ref;
	private HomeTeamOdds homeTeamOdds;
	private double overOdds;
}