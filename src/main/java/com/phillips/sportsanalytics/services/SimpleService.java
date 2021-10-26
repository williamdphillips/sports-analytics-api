package com.phillips.sportsanalytics.services;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.phillips.sportsanalytics.constant.Team;
import com.phillips.sportsanalytics.model.SimpleGame;
import com.phillips.sportsanalytics.model.SimplePlay;
import com.phillips.sportsanalytics.response.PlayByPlayResponse;
import com.phillips.sportsanalytics.response.PlayerResponse;
import com.phillips.sportsanalytics.response.ScoreboardResponse;
import com.phillips.sportsanalytics.response.TeamResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class SimpleService {

    private List<PlayerResponse> playerResponses;
    private List<TeamResponse.Team.Athlete> rosterAthletes;
    private List<TeamResponse> teamRespons;
    private final String PLAYER_ID_BASE_URL = "https://site.web.api.espn.com/apis/common/v3/sports/football/nfl/athletes";
    private final String ROSTER_ID_BASE_URL = "site.api.espn.com/apis/site/v2/sports/football/nfl/teams";
    private final String SCOREBOARD_BASE_URL = "site.api.espn.com/apis/site/v2/sports/football/nfl/scoreboard";
    private final String PLAY_BY_PLAY_BASE_URL = "https://site.api.espn.com/apis/site/v2/sports/football/nfl/summary";
    private NFLService nflService;

    ObjectMapper mapper;

    @Autowired
    public void setNFLService(NFLService nflService) {
        this.nflService = nflService;
    }

    public SimpleService(){
        mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
    }

    public List<SimpleGame> getGamesByWeek(String week){
        ScoreboardResponse sr = nflService.getScoreboard(null, week);

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
                tempSimpleGame.setHomeTeamInitials(e.competitions[0].competitors[0].team.abbreviation);
                tempSimpleGame.setHomeTeamRecord(e.competitions[0].competitors[0].records[0].summary);

                tempSimpleGame.setDisplayClock(e.competitions[0].status.displayClock);
                tempSimpleGame.setDisplayClockDetail(e.competitions[0].status.type.detail);
                tempSimpleGame.setCompleted(e.competitions[0].status.type.completed);
                tempSimpleGame.setShortDetail(e.competitions[0].status.type.shortDetail);
                tempSimpleGame.setDescription(e.competitions[0].status.type.description);
                tempSimpleGame.setEventId(e.competitions[0].id);

                tempSimpleGame.setAwayTeamDisplayName(e.competitions[0].competitors[1].team.displayName);
                tempSimpleGame.setAwayTeamScore(e.competitions[0].competitors[1].score);
                tempSimpleGame.setAwayTeamColor(e.competitions[0].competitors[1].team.color);
                tempSimpleGame.setAwayTeamShortName(e.competitions[0].competitors[1].team.shortDisplayName);
                tempSimpleGame.setAwayTeamLogoLoc(e.competitions[0].competitors[1].team.logo);
                tempSimpleGame.setAwayTeamInitials(e.competitions[0].competitors[1].team.abbreviation);
                tempSimpleGame.setAwayTeamRecord(e.competitions[0].competitors[1].records[0].summary);

                tempSimpleGame.setEventId(e.competitions[0].id);


                simpleGames.add(tempSimpleGame);
            }catch (ArrayIndexOutOfBoundsException ignored) {}
        }
        return simpleGames;
    }

    public SimplePlay getLatestPlay(String eventId){
        PlayByPlayResponse sr = nflService.getPlayByPlay(eventId);
        SimplePlay temp = new SimplePlay();

        PlayByPlayResponse.Drives.Current.Play currentPlay;
        if(sr.drives != null) {
            currentPlay = sr.drives.current.plays[sr.drives.current.plays.length - 1];
            temp.setLatestPlay(currentPlay.text);
            temp.setDown(String.valueOf(currentPlay.start.down));
            temp.setDownDistanceShortText(currentPlay.start.shortDownDistanceText);
            temp.setDriveDescription(currentPlay.text);
            temp.setScoringPlay(currentPlay.scoringPlay);
            temp.setDownDistanceText(currentPlay.start.downDistanceText);
            temp.setYardLine(String.valueOf(currentPlay.start.yardLine));
            temp.setFirstDownDistance(String.valueOf(currentPlay.start.distance));
            temp.setTeamInPossessionId(currentPlay.start.team.id);
            String teamId = currentPlay.start.team.id;
            Team currentTeam = Arrays.stream(Team.values()).filter(t -> t.getId().equalsIgnoreCase(teamId)).collect(Collectors.toList()).get(0);
            temp.setTeamInPossessionLongName(currentTeam.getDisplayName());
            return temp;
        }else return null;
    }

    public List<SimplePlay> getLatestPlays(){
        List<SimpleGame> sr = getGamesByWeek(null);

        ArrayList<String> ids = (ArrayList) sr.stream().map(r -> r.getEventId()).collect(Collectors.toList());
        ArrayList<SimplePlay> simplePlays = new ArrayList <>();
        ids.forEach(id -> {
            PlayByPlayResponse pr = nflService.getPlayByPlay(id);
            SimplePlay temp = new SimplePlay();
            temp.setEventId(id);

            PlayByPlayResponse.Drives.Current.Play currentPlay;
            if(pr.drives != null) {
                try {
                    currentPlay = pr.drives.current.plays[pr.drives.current.plays.length - 1];
                    temp.setLatestPlay(currentPlay.text);
                    temp.setDown(String.valueOf(currentPlay.start.down));
                    temp.setDownDistanceShortText(currentPlay.start.shortDownDistanceText);
                    temp.setDriveDescription(currentPlay.text);
                    temp.setScoringPlay(currentPlay.scoringPlay);
                    temp.setDownDistanceText(currentPlay.start.downDistanceText);
                    temp.setYardLine(String.valueOf(currentPlay.start.yardLine));
                    temp.setFirstDownDistance(String.valueOf(currentPlay.start.distance));
                    temp.setTeamInPossessionId(currentPlay.start.team.id);
                    temp.setTeamInPossessionLongName(Arrays.stream(Team.values()).filter(
                            t -> t.getId().equals(currentPlay.start.team.id)).collect(Collectors.toList())
                            .get(0).getDisplayName());
                    temp.setPossessionText(currentPlay.start.possessionText);
                    temp.setTeamInPossessionInitials(Arrays.stream(Team.values()).filter(
                            t -> t.getId().equals(currentPlay.start.team.id)).collect(Collectors.toList())
                            .get(0).getShortName());
                    simplePlays.add(temp);
                }catch (Exception ignored){
                    simplePlays.add(temp);
                }
            }else{
                simplePlays.add(temp);
            }
        });
        return simplePlays;
    }

}
