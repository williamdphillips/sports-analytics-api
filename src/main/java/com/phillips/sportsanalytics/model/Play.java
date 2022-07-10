package com.phillips.sportsanalytics.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Play {
    private String driveDescription;
    private String playDescription;
    private Team teamInPossession;
    private String downDistanceText;
    private String downDistanceShortText;
    private long down;
    private long yardLine;
    private long firstDownDistance;
    private Boolean isScoringPlay;
    private String possessionText;
}
