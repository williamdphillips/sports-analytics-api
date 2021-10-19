package com.phillips.sportsanalytics.helper;

import com.phillips.sportsanalytics.constant.Team;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ScoreboardHelper {
    public static Map <Team, Team> addTeam(String eventShortName){
        Team team1 = Arrays.stream(Team.values()).filter(t ->
                t.getShortName().equalsIgnoreCase(eventShortName.substring(0,3).trim())).collect(Collectors.toList())
                .get(0);

        Team team2 = Arrays.stream(Team.values()).filter(t ->
                t.getShortName().equalsIgnoreCase(eventShortName.substring(0,3).trim())).collect(Collectors.toList())
                .get(0);

        return null;
    }
}
