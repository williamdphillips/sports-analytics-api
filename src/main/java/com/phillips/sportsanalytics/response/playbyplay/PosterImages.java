package com.phillips.sportsanalytics.response.playbyplay;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PosterImages{
    @JsonProperty("default")
    public Default mydefault;
    public Full full;
    public Wide wide;
    public Square square;
}
