package com.phillips.sportsanalytics.response.odds;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OddsResponse{

	@JsonProperty("underOdds")
	private double underOdds;

	@JsonProperty("spreadHistory")
	private SpreadHistory spreadHistory;

	@JsonProperty("awayTeamOdds")
	private AwayTeamOdds awayTeamOdds;

	@JsonProperty("totalHistory")
	private TotalHistory totalHistory;

	@JsonProperty("spread")
	private double spread;

	@JsonProperty("moneyLineHistory")
	private MoneyLineHistory moneyLineHistory;

	@JsonProperty("overUnder")
	private double overUnder;

	@JsonProperty("spreadWinner")
	private boolean spreadWinner;

	@JsonProperty("moneylineWinner")
	private boolean moneylineWinner;

	@JsonProperty("provider")
	private Provider provider;

	@JsonProperty("headToHeads")
	private HeadToHeads headToHeads;

	@JsonProperty("details")
	private String details;

	@JsonProperty("links")
	private List<Object> links;

	@JsonProperty("$ref")
	private String ref;

	@JsonProperty("homeTeamOdds")
	private HomeTeamOdds homeTeamOdds;

	@JsonProperty("overOdds")
	private double overOdds;

	public void setUnderOdds(double underOdds){
		this.underOdds = underOdds;
	}

	public double getUnderOdds(){
		return underOdds;
	}

	public void setSpreadHistory(SpreadHistory spreadHistory){
		this.spreadHistory = spreadHistory;
	}

	public SpreadHistory getSpreadHistory(){
		return spreadHistory;
	}

	public void setAwayTeamOdds(AwayTeamOdds awayTeamOdds){
		this.awayTeamOdds = awayTeamOdds;
	}

	public AwayTeamOdds getAwayTeamOdds(){
		return awayTeamOdds;
	}

	public void setTotalHistory(TotalHistory totalHistory){
		this.totalHistory = totalHistory;
	}

	public TotalHistory getTotalHistory(){
		return totalHistory;
	}

	public void setSpread(double spread){
		this.spread = spread;
	}

	public double getSpread(){
		return spread;
	}

	public void setMoneyLineHistory(MoneyLineHistory moneyLineHistory){
		this.moneyLineHistory = moneyLineHistory;
	}

	public MoneyLineHistory getMoneyLineHistory(){
		return moneyLineHistory;
	}

	public void setOverUnder(double overUnder){
		this.overUnder = overUnder;
	}

	public double getOverUnder(){
		return overUnder;
	}

	public void setSpreadWinner(boolean spreadWinner){
		this.spreadWinner = spreadWinner;
	}

	public boolean isSpreadWinner(){
		return spreadWinner;
	}

	public void setMoneylineWinner(boolean moneylineWinner){
		this.moneylineWinner = moneylineWinner;
	}

	public boolean isMoneylineWinner(){
		return moneylineWinner;
	}

	public void setProvider(Provider provider){
		this.provider = provider;
	}

	public Provider getProvider(){
		return provider;
	}

	public void setHeadToHeads(HeadToHeads headToHeads){
		this.headToHeads = headToHeads;
	}

	public HeadToHeads getHeadToHeads(){
		return headToHeads;
	}

	public void setDetails(String details){
		this.details = details;
	}

	public String getDetails(){
		return details;
	}

	public void setLinks(List<Object> links){
		this.links = links;
	}

	public List<Object> getLinks(){
		return links;
	}

	public void setRef(String ref){
		this.ref = ref;
	}

	public String getRef(){
		return ref;
	}

	public void setHomeTeamOdds(HomeTeamOdds homeTeamOdds){
		this.homeTeamOdds = homeTeamOdds;
	}

	public HomeTeamOdds getHomeTeamOdds(){
		return homeTeamOdds;
	}

	public void setOverOdds(double overOdds){
		this.overOdds = overOdds;
	}

	public double getOverOdds(){
		return overOdds;
	}
}