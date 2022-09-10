package com.phillips.sportsanalytics.response.odds;

import lombok.Data;

@Data
public class Provider{
	private String name;
	private String id;
	private int priority;
	private String ref;
}