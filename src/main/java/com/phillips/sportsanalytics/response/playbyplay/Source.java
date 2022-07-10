package com.phillips.sportsanalytics.response.playbyplay;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Source{
    public Mezzanine mezzanine;
    public Flash flash;
    public Hds hds;
    @JsonProperty("HLS")
    public HLS hLS;
    @JsonProperty("HD") 
    public HD hD;
    public Full full;
    public String href;
}
