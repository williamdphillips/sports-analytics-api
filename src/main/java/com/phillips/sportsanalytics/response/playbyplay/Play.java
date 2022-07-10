package com.phillips.sportsanalytics.response.playbyplay;

import java.util.Date;

public class Play{
    public String id;
    public String sequenceNumber;
    public Type type;
    public String text;
    public int awayScore;
    public int homeScore;
    public Period period;
    public Clock clock;
    public boolean scoringPlay;
    public boolean priority;
    public String modified;
    public Date wallclock;
    public Start start;
    public End end;
    public int statYardage;
    public ScoringType scoringType;
    public PointAfterAttempt pointAfterAttempt;
}
