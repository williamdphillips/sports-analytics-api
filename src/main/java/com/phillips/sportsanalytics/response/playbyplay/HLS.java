package com.phillips.sportsanalytics.response.playbyplay;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HLS{
    public String href;
    @JsonProperty("HD")
    public HD hD;
}
