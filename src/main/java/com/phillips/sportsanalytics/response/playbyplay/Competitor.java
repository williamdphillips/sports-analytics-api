package com.phillips.sportsanalytics.response.playbyplay;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Competitor{
    public String id;
    public String uid;
    public int order;
    public String homeAway;
    public boolean winner;
    public Team team;
    public String score;
    public ArrayList<Linescore> linescores;
    @JsonProperty("record")
    public ArrayList<Record> myrecord;
    public boolean possession;
}
