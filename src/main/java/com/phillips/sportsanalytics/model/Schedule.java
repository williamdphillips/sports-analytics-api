package com.phillips.sportsanalytics.model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Schedule {
    // seasonTypeNumber, <weekNumber, Week>
    public Map <Long, Map <Long, Week>> season;

    public Schedule(){
        season = new HashMap <>();
    }

    public void addWeek(Long seasonType, Week week){
        if (!season.containsKey(seasonType)) {
            season.put(seasonType, new HashMap <>());
        }
        season.get(seasonType).put(week.getWeekNumber(), week);
    }
}
