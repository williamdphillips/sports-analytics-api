package com.phillips.sportsanalytics.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Event {
    String displayClock;
    String displayClockDetail;
    String shortDetail;
    long period;
    String description;
    Boolean isCompleted;
    String eventId;
    String week;
    String state;
    String overUnder;
    String overOdds;
    String spread;
    String spreadDetails;


    Team awayTeam;
    Team homeTeam;
    Play currentPlay;
}
