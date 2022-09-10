package com.phillips.sportsanalytics.response.odds;

import java.util.List;

import com.azure.spring.data.cosmos.core.mapping.Container;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Container(containerName = "NFL_Odds")
public class OddsResponse{
	@Id
	private String eventId;
	private int pageCount;
	private int pageIndex;
	private int count;
	private int pageSize;
	private List<EventOdds> items;
}