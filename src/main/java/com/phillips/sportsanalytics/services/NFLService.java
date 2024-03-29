package com.phillips.sportsanalytics.services;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.phillips.sportsanalytics.constant.Team;
import com.phillips.sportsanalytics.helper.URIHelper;
import com.phillips.sportsanalytics.model.*;
import com.phillips.sportsanalytics.response.playbyplay.PlayByPlayResponse;
import com.phillips.sportsanalytics.services.reposervice.OddsService;
import com.phillips.sportsanalytics.services.reposervice.PlayByPlayService;
import com.phillips.sportsanalytics.services.reposervice.PredictionService;
import com.phillips.sportsanalytics.services.reposervice.ScoreboardService;
import com.phillips.sportsanalytics.response.*;
import com.phillips.sportsanalytics.response.odds.OddsResponse;
import com.phillips.sportsanalytics.response.prediction.PredictionResponse;
import com.phillips.sportsanalytics.response.winprobability.WinProbabilityResponse;
import com.phillips.sportsanalytics.util.HTTPConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.net.URI;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class NFLService {

    @Autowired
    private ScoreboardService scoreboardService;
    @Autowired
    private OddsService oddsService;
    @Autowired
    private PredictionService predictionService;
    @Autowired
    private PlayByPlayService playByPlayService;

    // The current scoreboard is updated every 15 seconds by the scheduler
    private ScoreboardResponse currentScoreboard;
    private List<PlayerResponse> playerResponses;
    private List<TeamResponse.Team.Athlete> rosterAthletes;
    private List<TeamResponse> teamResponse;
    private final String PLAYER_ID_BASE_URL = "https://site.web.api.espn.com/apis/common/v3/sports/football/nfl/athletes";
    private final String ROSTER_ID_BASE_URL = "site.api.espn.com/apis/site/v2/sports/football/nfl/teams";
    private final String SCOREBOARD_BASE_URL = "site.api.espn.com/apis/site/v2/sports/football/nfl/scoreboard";
    private final String PLAY_BY_PLAY_BASE_URL = "https://site.api.espn.com/apis/site/v2/sports/football/nfl/summary";
    private final String WIN_PROBABILITY_BASE_URL = "sports.core.api.espn.com/v2/sports/football/leagues/nfl/events/:eventid/competitions/:eventid/probabilities";
    private final String PREDICTOR_BASE_URL = "sports.core.api.espn.com/v2/sports/football/leagues/nfl/events/:eventid/competitions/:eventid/predictor?lang=en&region=us";
    private final String HEAD_TO_HEAD_BASE_URL = "sports.core.api.espn.com/v2/sports/football/leagues/nfl/events/:eventid/competitions/:eventid/odds/1002/head-to-heads";
    private final String ODDS_BASE_URL = "sports.core.api.espn.com/v2/sports/football/leagues/nfl/events/:eventid/competitions/:eventid/odds";
    private final String WEEK_WHITELIST_URL = "sports.core.api.espn.com/v2/sports/football/leagues/nfl/calendar/whitelist";

    ObjectMapper mapper;

    public NFLService(){
        mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        //mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }

    public OddsResponse getOdds(String eventId, Boolean forceUpdate){
        if(forceUpdate != null && !forceUpdate) {
            OddsResponse oddsResponse = oddsService.findOddsByEventId(eventId);
            if (oddsResponse != null)
                return oddsResponse;
        }

        URI uri = URIHelper.createURI(ODDS_BASE_URL.replace(":eventid", eventId));

        try {
            Map <String,Object> responseMap = HTTPConnection.get(uri.toString());
            OddsResponse oddsResponse = mapper.convertValue(responseMap, OddsResponse.class);
            oddsResponse.setEventId(eventId);
            oddsService.saveOdds(oddsResponse);
            return oddsResponse;
        }catch (Exception e){
            System.out.println("ERROR");
            System.out.println(e.getMessage());
            return null;
        }
    }

    public PredictionResponse getPrediction(String eventId, Boolean forceUpdate){
        if(forceUpdate != null && !forceUpdate){
            PredictionResponse predictionResponse = predictionService.findPredictionByEventId(eventId);
            if(predictionResponse != null)
                return predictionResponse;
        }

        URI uri = URIHelper.createURI(PREDICTOR_BASE_URL.replace(":eventid", eventId) + "&limit=1000");

        try {
            Map <String,Object> responseMap = HTTPConnection.get(uri.toString());
            PredictionResponse  predictionResponse = mapper.convertValue(responseMap, PredictionResponse.class);
            predictionResponse.setEventId(eventId);
            predictionService.savePrediction(predictionResponse);
            return predictionResponse;
        }catch (Exception e){
            System.out.println("ERROR");
            System.out.println(e.getMessage());
            return null;
        }
    }

    public WinProbabilityResponse getWinProbability(String eventId){
        URI uri = URIHelper.createURI(WIN_PROBABILITY_BASE_URL.replace(":eventid", eventId) + "?limit=1000");

        try {
            Map <String,Object> playerMap = HTTPConnection.get(uri.toString());
            return mapper.convertValue(playerMap, WinProbabilityResponse.class);
        }catch (Exception e){
            System.out.println("ERROR");
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<TeamResponse> getAllRosters() {
        if(teamResponse == null || teamResponse.isEmpty()){
            teamResponse = new ArrayList <>();
            for(int i = 1; i < 35; i++){
                teamResponse.add(getTeam(i));
            }
        }

        return this.teamResponse;
    }

    public TeamResponse getTeam(int id) {
        URI uri = URIHelper.createURI(ROSTER_ID_BASE_URL + "/" + id + "?enable=roster");

        try {
            Map <String,Object> playerMap = HTTPConnection.get(uri.toString());
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
            Map <String,Object> playerMap = HTTPConnection.get(uri.toString());
            return mapper.convertValue(playerMap, TeamResponse.class);
        }catch (Exception e){
            System.out.println("ERROR");
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<PlayerResponse> getAllPlayers() {
        if(teamResponse == null || teamResponse.isEmpty()){
            getAllRosters();
            playerResponses = new ArrayList <>();
            rosterAthletes = new ArrayList <>();
            teamResponse.forEach(teamResponse -> rosterAthletes.addAll(Arrays.asList(teamResponse.team.athletes)));
            rosterAthletes.forEach(rosterAthlete -> playerResponses.add(getPlayer(rosterAthlete.id)));
        }

        return this.playerResponses;
    }

    public PlayerResponse getPlayer(int id) {
        try {
            Map <String, Object> playerMap = HTTPConnection.get(PLAYER_ID_BASE_URL + "/" + id);
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

    public ScoreboardResponse getCurrentScoreboard(){
        return currentScoreboard;
    }

    public SeasonInfo getCurrentSeasonInfo(){
        if(currentScoreboard == null)
            updateScoreboard();
        SeasonInfo s = new SeasonInfo();
        s.setYear(currentScoreboard.season.year);
        s.setSeasonType(currentScoreboard.season.type);
        s.setWeek(currentScoreboard.week.number);

        return s;
    }

    public void updateScoreboard(){
        URI uri = URIHelper.createURI(SCOREBOARD_BASE_URL, new String[]{"dates", "week", "seasontype"},new Object[]{null, null, null});

        try {
            Map <String,Object> playerMap = HTTPConnection.get(uri.toString());
            currentScoreboard = mapper.convertValue(playerMap, ScoreboardResponse.class);
        }catch (Exception e){
            System.out.println("ERROR");
            System.out.println(e.getMessage());
        }
    }

    /**
     * Searches for data matching request in repository and if not exists, requests
     * data directly from ESPN
     * @param dates if not specified, defaults to current week and season type
     * @param week week of season
     * @param seasonType 1 for preseason | 2 for regular reason | 3 for postseason
     * @param forceUpdate if enabled, forces obtaining new data from ESPN
     * @param updateRepo if enabled, updates repo with new data
     * @return full response from ESPN api
     */
    public ScoreboardResponse getScoreboard(Long dates, Long week, Long seasonType, Boolean forceUpdate) {
        SeasonInfo currentSeasonInfo = getCurrentSeasonInfo();
        if(dates == null)
            dates = currentSeasonInfo.getYear();
        if(week == null)
            week = currentSeasonInfo.getWeek();
        if(seasonType == null)
            seasonType = currentSeasonInfo.getSeasonType();

        if(currentSeasonInfo.isCurrentWeek(dates, week, seasonType))
            return currentScoreboard;

        //If forceUpdate is false, return scoreboard from repo
        if(forceUpdate != null && !forceUpdate) {
            ScoreboardResponse scoreboard = scoreboardService.findScoreboard(dates, seasonType, week);
            if (scoreboard != null)
                return scoreboard;
        }

        URI uri = URIHelper.createURI(SCOREBOARD_BASE_URL, new String[]{"dates", "week", "seasontype"},new Object[]{dates, week, seasonType});

        try {
            Map <String,Object> playerMap = HTTPConnection.get(uri.toString());
            ScoreboardResponse scoreboard = mapper.convertValue(playerMap, ScoreboardResponse.class);
            scoreboardService.saveScoreboard(scoreboard);
            return scoreboard;
        }catch (Exception e){
            System.out.println("ERROR");
            System.out.println(e.getMessage());
            return null;
        }
    }

    public PlayByPlayResponse getPlayByPlay(String eventId, Boolean forceUpdate) {
        if(forceUpdate != null && !forceUpdate) {
            PlayByPlayResponse playByPlayResponse = playByPlayService.findPBPByEventId(eventId);
            if (playByPlayResponse != null)
                return playByPlayResponse;
        }

        try {
            Map <String,Object> playerMap = HTTPConnection.get(PLAY_BY_PLAY_BASE_URL + "?event=" + eventId);
            PlayByPlayResponse playByPlayResponse = mapper.convertValue(playerMap, PlayByPlayResponse.class);
            playByPlayResponse.setEventId(eventId);
            playByPlayService.savePlayByPlay(playByPlayResponse);
            return playByPlayResponse;
        }catch (Exception e){
            System.out.println("ERROR");
            System.out.println(e.getMessage());
            return null;
        }
    }
}
