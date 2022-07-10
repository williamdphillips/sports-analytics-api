package com.phillips.sportsanalytics.response.playbyplay;

public class Current {
            public String id;
            public String description;
            public Team team;
            public Start start;
            public End end;
            public TimeElapsed timeElapsed;
            public long yards;
            public boolean isScore;
            public long offensivePlays;
            public String result;
            public String shortDisplayResult;
            public String displayResult;
            public Play plays[];
        }