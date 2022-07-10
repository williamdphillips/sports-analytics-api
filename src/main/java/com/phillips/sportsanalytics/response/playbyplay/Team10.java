package com.phillips.sportsanalytics.response.playbyplay;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Team10{
    public String id;
    public String uid;
    public String location;
    public String name;
    public String nickname;
    public String abbreviation;
    public String displayName;
    public String color;
    public String alternateColor;
    public ArrayList<Logo> logos;
    public ArrayList<Link> links;
    public String logo;
    public String description;
    public String slug;
    public String shortDisplayName;
    @JsonProperty("$ref")
    public String ref;
}
