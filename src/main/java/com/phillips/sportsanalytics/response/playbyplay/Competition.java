package com.phillips.sportsanalytics.response.playbyplay;

import java.util.ArrayList;

public class Competition{
    public String id;
    public String uid;
    public String date;
    public boolean neutralSite;
    public boolean conferenceCompetition;
    public boolean boxscoreAvailable;
    public boolean commentaryAvailable;
    public boolean liveAvailable;
    public boolean onWatchESPN;
    public boolean recent;
    public String boxscoreSource;
    public String playByPlaySource;
    public ArrayList<Competitor> competitors;
    public Status status;
    public ArrayList<Broadcast> broadcasts;
}
