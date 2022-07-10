package com.phillips.sportsanalytics.response.prediction;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Container(containerName = "NFL_Predictions")
public class PredictionResponse{
	@Id
	private String eventId;
	private AwayTeam awayTeam;
	private String name;
	private HomeTeam homeTeam;
	private String lastModified;
	private String shortName;
	@JsonProperty("$ref")
	private String ref;
}