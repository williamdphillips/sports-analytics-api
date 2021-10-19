package com.phillips.sportsanalytics.services;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.phillips.sportsanalytics.constant.Team;
import com.phillips.sportsanalytics.helper.URIHelper;
import com.phillips.sportsanalytics.model.SimpleGame;
import com.phillips.sportsanalytics.response.PlayByPlayResponse;
import com.phillips.sportsanalytics.response.TeamResponse;
import com.phillips.sportsanalytics.response.ScoreboardResponse;
import com.phillips.sportsanalytics.util.HTTPConnection;
import com.phillips.sportsanalytics.response.PlayerResponse;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class NFLService {

    private List<PlayerResponse> playerResponses;
    private List<TeamResponse.Team.Athlete> rosterAthletes;
    private List<TeamResponse> teamRespons;
    private final String PLAYER_ID_BASE_URL = "https://site.web.api.espn.com/apis/common/v3/sports/football/nfl/athletes";
    private final String ROSTER_ID_BASE_URL = "site.api.espn.com/apis/site/v2/sports/football/nfl/teams";
    private final String SCOREBOARD_BASE_URL = "site.api.espn.com/apis/site/v2/sports/football/nfl/scoreboard";
    private final String PLAY_BY_PLAY_BASE_URL = "https://site.api.espn.com/apis/site/v2/sports/football/nfl/summary";

    ObjectMapper mapper;

    public NFLService(){
        mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
    }

    public List<TeamResponse> getAllRosters() {
        if(teamRespons == null || teamRespons.isEmpty()){
            teamRespons = new ArrayList <>();
            for(int i = 1; i < 35; i++){
                teamRespons.add(getTeam(i));
            }
        }

        return this.teamRespons;
    }

    public TeamResponse getTeam(int id) {
        URI uri = URIHelper.createURI(ROSTER_ID_BASE_URL + "/" + id + "?enable=roster");

        try {
            Map <String,Object> playerMap = HTTPConnection.doGetRequest(uri.toString());
            return mapper.convertValue(playerMap, TeamResponse.class);
        }catch (Exception e){
            System.out.println("ERROR");
            System.out.println(e.getMessage());
            return null;
        }
    }

    public TeamResponse getTeam(Team team) {

        URI uri = URIHelper.createURI(ROSTER_ID_BASE_URL + "/" + team.getId() + "?enable=roster");

        try {
            Map <String,Object> playerMap = HTTPConnection.doGetRequest(uri.toString());
            return mapper.convertValue(playerMap, TeamResponse.class);
        }catch (Exception e){
            System.out.println("ERROR");
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<PlayerResponse> getAllPlayers() {
        if(teamRespons == null || teamRespons.isEmpty()){
            getAllRosters();
            playerResponses = new ArrayList <>();
            rosterAthletes = new ArrayList <>();
            teamRespons.forEach(teamResponse -> rosterAthletes.addAll(Arrays.asList(teamResponse.team.athletes)));
            rosterAthletes.forEach(rosterAthlete -> playerResponses.add(getPlayer(rosterAthlete.id)));
        }

        return this.playerResponses;
    }

    public PlayerResponse getPlayer(int id) {
        try {
            Map <String, Object> playerMap = HTTPConnection.doGetRequest(PLAYER_ID_BASE_URL + "/" + id);
            return mapper.convertValue(playerMap, PlayerResponse.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public PlayerResponse getPlayer(String name) {
        try {
                if(playerResponses == null || playerResponses.isEmpty()){
                    getAllPlayers();
                }

                return playerResponses.stream()
                        .filter(p -> p.athlete.displayName.toLowerCase(Locale.ROOT).contains(name.toLowerCase()))
                        .collect(Collectors.toList()).get(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     *
     * @param dates if not specified, defaults to current week and season type
     * @param week week of season
     * @return full response from ESPN api
     */
    public ScoreboardResponse getScoreboard(String dates, String week) {
        URI uri = URIHelper.createURI(SCOREBOARD_BASE_URL, new String[]{"dates", "week"},new String[]{dates, week});

        try {
            Map <String,Object> playerMap = HTTPConnection.doGetRequest(uri.toString());
            return mapper.convertValue(playerMap, ScoreboardResponse.class);

        }catch (Exception e){
            System.out.println("ERROR");
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<SimpleGame> getGamesByWeek(String week){
        ScoreboardResponse sr = getScoreboard(null, week);

        List<SimpleGame> simpleGames = new ArrayList <>();
        for (ScoreboardResponse.Event e:sr.events
             ) {
            try{
                SimpleGame tempSimpleGame = new SimpleGame();
                tempSimpleGame.setHomeTeamDisplayName(e.competitions[0].competitors[0].team.displayName);
                tempSimpleGame.setHomeTeamScore(e.competitions[0].competitors[0].score);
                tempSimpleGame.setHomeTeamColor(e.competitions[0].competitors[0].team.color);
                tempSimpleGame.setHomeTeamShortName(e.competitions[0].competitors[0].team.shortDisplayName);
                tempSimpleGame.setHomeTeamLogoLoc(e.competitions[0].competitors[0].team.logo);


                tempSimpleGame.setDisplayClock(e.competitions[0].status.displayClock);
                tempSimpleGame.setDisplayClockDetail(e.competitions[0].status.type.detail);
                tempSimpleGame.setCompleted(e.competitions[0].status.type.completed);

                tempSimpleGame.setAwayTeamDisplayName(e.competitions[0].competitors[1].team.displayName);
                tempSimpleGame.setAwayTeamScore(e.competitions[0].competitors[1].score);
                tempSimpleGame.setAwayTeamColor(e.competitions[0].competitors[1].team.color);
                tempSimpleGame.setAwayTeamShortName(e.competitions[0].competitors[1].team.shortDisplayName);
                tempSimpleGame.setAwayTeamLogoLoc(e.competitions[0].competitors[1].team.logo);


                simpleGames.add(tempSimpleGame);
            }catch (ArrayIndexOutOfBoundsException ignored) {}
        }
        return simpleGames;
    }

    public PlayByPlayResponse getPlayByPlay(String eventId) {

        try {
            Map <String,Object> playerMap = HTTPConnection.doGetRequest(PLAY_BY_PLAY_BASE_URL + "?event=" + eventId);
            return mapper.convertValue(playerMap, PlayByPlayResponse.class);

        }catch (Exception e){
            System.out.println("ERROR");
            System.out.println(e.getMessage());
            return null;
        }
    }
}
