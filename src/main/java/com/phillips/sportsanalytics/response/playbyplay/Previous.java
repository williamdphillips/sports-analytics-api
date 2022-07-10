package com.phillips.sportsanalytics.response.playbyplay;

import java.util.ArrayList;

public class Previous {
    public String id;
    public String description;
    public Team team;
    public Start start;
    public End end;
    public TimeElapsed timeElapsed;
    public int yards;
    public boolean isScore;
    public int offensivePlays;
    public String result;
    public String shortDisplayResult;
    public String displayResult;
    public ArrayList<Play> plays;
}
