package com.phillips.sportsanalytics.helper;

import com.phillips.sportsanalytics.model.Event;
import com.phillips.sportsanalytics.model.Schedule;
import java.util.List;
import java.util.stream.Collectors;

public class DataHelper {
    public static boolean containsWeek(Schedule schedule, long seasonType, long weekNumber){
        return schedule.getSeason().containsKey(seasonType) && schedule.getSeason().get(seasonType).containsKey(weekNumber);
    }
    public static String getEventState(List <Event> events, String eventId){
        List<Event> matchingEvents = events.stream().filter(e -> e.getEventId().equalsIgnoreCase(eventId)).collect(Collectors.toList());
        assert matchingEvents.size() <= 1;
        return matchingEvents.get(0).getState();
    }
}
