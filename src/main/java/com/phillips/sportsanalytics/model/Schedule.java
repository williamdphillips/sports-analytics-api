package com.phillips.sportsanalytics.model;

import com.azure.spring.data.cosmos.core.mapping.Container;
import lombok.Data;
import org.springframework.data.annotation.Id;
import java.util.HashMap;
import java.util.Map;

@Data
@Container(containerName = "NFL_Schedules")
public class Schedule {
    // seasonTypeNumber, <weekNumber, Week>
    @Id
    private Long year;
    private Map <Long, Map <Long, Week>> season;

    public Schedule(){
        season = new HashMap<>();
    }

    public Week getWeek(Long seasonType, Long week){
        try{
            return season.get(seasonType).get(week);
        }catch (Exception ignored){return null;}
    }

    public void putWeek(Long seasonType, Week week){
        if (!season.containsKey(seasonType)) {
            season.put(seasonType, new HashMap <>());
        }
        season.get(seasonType).put(week.getWeekNumber(), week);
    }
}
