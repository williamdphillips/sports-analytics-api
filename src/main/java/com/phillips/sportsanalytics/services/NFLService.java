package com.phillips.sportsanalytics.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.phillips.sportsanalytics.constant.Team;
import com.phillips.sportsanalytics.entity.Roster;
import com.phillips.sportsanalytics.util.HTTPConnection;
import com.phillips.sportsanalytics.entity.Player;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NFLService {

    private List<Player> players;
    private List<Roster> rosters;
    private final String PLAYER_ID_BASE_URL = "https://site.web.api.espn.com/apis/common/v3/sports/football/nfl/athletes/";
    private final String ROSTER_ID_BASE_URL = "https://site.api.espn.com/apis/site/v2/sports/football/nfl/teams";

    ObjectMapper mapper = new ObjectMapper();

    public List<Roster> getAllRosters() {
        if(rosters == null || rosters.isEmpty()){
            rosters = new ArrayList <>();
            for(int i = 1; i < 35; i++){
                rosters.add(getRosterByTeamId(String.valueOf(i)));
            }
        }

        return this.rosters;
    }

    public Roster getRosterByTeamId(String id) {

        try {
            Map <String,Object> playerMap = HTTPConnection.doGetRequest(ROSTER_ID_BASE_URL + "/" + id + "/roster?&limit=50");
            return mapper.convertValue(playerMap, Roster.class);

        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Roster getRosterByTeam(Team team) {

        try {
            Map <String,Object> playerMap = HTTPConnection.doGetRequest(ROSTER_ID_BASE_URL + "/" + team.getId() + "/roster?&limit=50");
            return mapper.convertValue(playerMap, Roster.class);

        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Player> getAllPlayers() {
        if(rosters == null || rosters.isEmpty()){
            getAllRosters();
        }

        rosters.forEach(roster -> {

        });

        return this.players;
    }

    public Player getPlayerById(String id) {

        try {
            Map <String,Object> playerMap = HTTPConnection.doGetRequest(PLAYER_ID_BASE_URL + id);
            return mapper.convertValue(playerMap, Player.class);

        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Player getPlayerByName(String name) {



        try {
            Map <String,Object> playerMap = HTTPConnection.doGetRequest(PLAYER_ID_BASE_URL + name);
            return mapper.convertValue(playerMap, Player.class);

        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
