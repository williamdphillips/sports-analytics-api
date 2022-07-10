package com.phillips.sportsanalytics.response.playbyplay;

import java.util.ArrayList;

public class Header{
    public String id;
    public String uid;
    public Season season;
    public boolean timeValid;
    public ArrayList<Competition> competitions;
    public ArrayList<Link> links;
    public int week;
    public League league;
    public String gameNote;
}
