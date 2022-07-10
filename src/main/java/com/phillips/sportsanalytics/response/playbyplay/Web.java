package com.phillips.sportsanalytics.response.playbyplay;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Web{
    public String href;
    @JsonProperty("short")
    public Short myshort;
    public Leagues leagues;
    public Teams teams;
    public Self self;
    public Athletes athletes;
}
