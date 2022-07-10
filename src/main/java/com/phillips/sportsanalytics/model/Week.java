package com.phillips.sportsanalytics.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Week {
    private Long weekNumber;
    private String dates;
    private ArrayList <Event> events;

    public Week(){
        events = new ArrayList<>();
    }
}
