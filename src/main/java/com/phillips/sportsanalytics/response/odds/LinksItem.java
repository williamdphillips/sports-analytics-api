package com.phillips.sportsanalytics.response.odds;

import java.util.List;
import lombok.Data;

@Data
public class LinksItem{
	private boolean isExternal;
	private String shortText;
	private List<String> rel;
	private String language;
	private String href;
	private String text;
	private boolean isPremium;
}