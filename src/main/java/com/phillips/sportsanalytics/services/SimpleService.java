package com.phillips.sportsanalytics.services;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.phillips.sportsanalytics.constant.Team;
import com.phillips.sportsanalytics.model.simple.*;
import com.phillips.sportsanalytics.response.ScoreboardResponse;
import com.phillips.sportsanalytics.response.odds.EventOdds;
import com.phillips.sportsanalytics.response.odds.OddsResponse;
import com.phillips.sportsanalytics.response.playbyplay.Play;
import com.phillips.sportsanalytics.response.playbyplay.PlayByPlayResponse;
import com.phillips.sportsanalytics.response.prediction.PredictionResponse;
import com.phillips.sportsanalytics.response.prediction.StatisticsItem;
import com.phillips.sportsanalytics.response.winprobability.ItemsItem;
import com.phillips.sportsanalytics.response.winprobability.WinProbabilityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class SimpleService {
    private NFLService nflService;

    ObjectMapper mapper;

    @Autowired
    public void setNFLService(@Qualifier("NFLService") NFLService nflService) {
        this.nflService = nflService;
    }

    public SimpleService(){
        mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }

    public List<SimpleGame> getGamesByWeek(Long week, Long seasonType, Boolean forceUpdate, Boolean updateRepo){
        System.out.println("\ngetGamesByWeek entry\n");
        ScoreboardResponse sr = nflService.getScoreboard(null, week, seasonType, forceUpdate, updateRepo);

        List<SimpleGame> simpleGames = new ArrayList <>();
        for (ScoreboardResponse.Event e:sr.events
             ) {
            try{
                SimpleGame tempSimpleGame = new SimpleGame();
                tempSimpleGame.setHomeTeamDisplayName(e.competitions[0].competitors[0].team.displayName);
                tempSimpleGame.setHomeTeamScore(e.competitions[0].competitors[0].score);
                tempSimpleGame.setHomeTeamColor(e.competitions[0].competitors[0].team.color);
                tempSimpleGame.setHomeTeamShortName(e.competitions[0].competitors[0].team.shortDisplayName);
                tempSimpleGame.setHomeTeamLogoURL(e.competitions[0].competitors[0].team.logo);
                tempSimpleGame.setHomeTeamInitials(e.competitions[0].competitors[0].team.abbreviation);
                tempSimpleGame.setHomeTeamRecord(e.competitions[0].competitors[0].records[0].summary);

                tempSimpleGame.setDisplayClock(e.competitions[0].status.displayClock);
                tempSimpleGame.setDisplayClockDetail(e.competitions[0].status.type.detail);
                tempSimpleGame.setIsCompleted(e.competitions[0].status.type.completed);
                tempSimpleGame.setShortDetail(e.competitions[0].status.type.shortDetail);
                tempSimpleGame.setDescription(e.competitions[0].status.type.description);
                tempSimpleGame.setEventId(e.competitions[0].id);
                tempSimpleGame.setWeek(String.valueOf(sr.week.number));
                tempSimpleGame.setState(e.competitions[0].status.type.state);

                tempSimpleGame.setAwayTeamDisplayName(e.competitions[0].competitors[1].team.displayName);
                tempSimpleGame.setAwayTeamScore(e.competitions[0].competitors[1].score);
                tempSimpleGame.setAwayTeamColor(e.competitions[0].competitors[1].team.color);
                tempSimpleGame.setAwayTeamShortName(e.competitions[0].competitors[1].team.shortDisplayName);
                tempSimpleGame.setAwayTeamLogoURL(e.competitions[0].competitors[1].team.logo);
                tempSimpleGame.setAwayTeamInitials(e.competitions[0].competitors[1].team.abbreviation);
                tempSimpleGame.setAwayTeamRecord(e.competitions[0].competitors[1].records[0].summary);

                tempSimpleGame.setEventId(e.competitions[0].id);


                simpleGames.add(tempSimpleGame);
            }catch (ArrayIndexOutOfBoundsException ignored) {}
        }
        return simpleGames;
    }

    public SimplePlay getLatestPlay(String eventId, Boolean forceUpdate, Boolean updateRepo){
        PlayByPlayResponse pr = nflService.getPlayByPlay(eventId, forceUpdate, updateRepo);
        SimplePlay temp = new SimplePlay();

        Play currentPlay;
        temp.setEventId(eventId);
            try{
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
                        .get(0).getAbbrev());
                return temp;
            }catch (Exception e) { return temp; }
    }

    public List<SimplePlay> getLatestPlays(Boolean forceUpdate, Boolean updateRepo){
        List<SimpleGame> sr = getGamesByWeek(null, null, forceUpdate, updateRepo);

        ArrayList<String> ids = (ArrayList <String>) sr.stream().map(SimpleGame::getEventId).collect(Collectors.toList());
        ArrayList<SimplePlay> simplePlays = new ArrayList <>();
        ids.forEach(id -> simplePlays.add(getLatestPlay(id, forceUpdate, updateRepo)));
        return simplePlays;
    }

    public SimpleProbability getGameProbability(String eventId){
        WinProbabilityResponse wp = nflService.getWinProbability(eventId);
        SimpleProbability temp = new SimpleProbability();
        temp.setEventId(eventId);
        try {
            ItemsItem latestPrediction = wp.getItems().get(wp.getItems().size() - 1);
            temp.setHomeTeamId(latestPrediction.getHomeTeam().getRef()
                    .substring(latestPrediction.getHomeTeam().getRef().indexOf("teams/") + 6,
                            latestPrediction.getHomeTeam().getRef().indexOf("teams/") + 8)
                    .replace("?", ""));
            Team homeTeam = Arrays.stream(Team.values()).filter(t -> t.getId().equals(temp.getHomeTeamId())).collect(Collectors.toList()).get(0);
            temp.setHomeTeamLongName(homeTeam.getDisplayName());
            temp.setHomeTeamInitials(homeTeam.getAbbrev());
            temp.setHomeTeamShortName(homeTeam.getShortName());
            temp.setHomeTeamWinPercentage(String.valueOf(latestPrediction.getHomeWinPercentage()));
            temp.setAwayTeamId(latestPrediction.getAwayTeam().getRef()
                    .substring(latestPrediction.getAwayTeam().getRef().indexOf("teams/") + 6,
                            latestPrediction.getAwayTeam().getRef().indexOf("teams/") + 8)
                    .replace("?", ""));
            Team awayTeam = Arrays.stream(Team.values()).filter(t -> t.getId().equals(temp.getAwayTeamId())).collect(Collectors.toList()).get(0);
            temp.setAwayTeamLongName(awayTeam.getDisplayName());
            temp.setAwayTeamInitials(awayTeam.getAbbrev());
            temp.setAwayTeamShortName(awayTeam.getShortName());
            temp.setAwayTeamWinPercentage(String.valueOf(latestPrediction.getAwayWinPercentage()));
            return temp;
        }catch (Exception e) { return temp;}
    }

    public List<SimpleProbability> getGameProbabilities(Long week, Long seasonType, Boolean forceUpdate, Boolean updateRepo){
        List<SimpleGame> sr = getGamesByWeek(week, seasonType, forceUpdate, updateRepo);

        ArrayList<String> ids = (ArrayList <String>) sr.stream().map(SimpleGame::getEventId).collect(Collectors.toList());
        ArrayList<SimpleProbability> simpleProbabilities = new ArrayList <>();
        ids.forEach(id -> simpleProbabilities.add(getGameProbability(id)));
        return simpleProbabilities;
    }

    public SimplePrediction getLatestPrediction(String eventId, Boolean forceUpdate, Boolean updateRepo){
        PredictionResponse pr = nflService.getPrediction(eventId, forceUpdate, updateRepo);
        SimplePrediction temp = new SimplePrediction();
        temp.setEventId(eventId);
        try{
            List<StatisticsItem> homeStats = pr.getHomeTeam().getStatistics();
            List<StatisticsItem> awayStats = pr.getAwayTeam().getStatistics();

            temp.setHomeOppStrengthRating(homeStats.stream().filter(s -> s.getName()
                    .equalsIgnoreCase("oppSeasonStrengthRating"))
                    .map(s -> String.valueOf(s.getValue())).collect(Collectors.toList()).get(0));
            temp.setHomeOppPointDifference(homeStats.stream().filter(s -> s.getName()
                    .equalsIgnoreCase("teamPredPtDiff"))
                    .map(s -> String.valueOf(s.getValue())).collect(Collectors.toList()).get(0));
            temp.setHomeTeamChanceLoss(homeStats.stream().filter(s -> s.getName()
                    .equalsIgnoreCase("teamChanceLoss"))
                    .map(s -> String.valueOf(s.getValue())).collect(Collectors.toList()).get(0));
            temp.setHomeTeamId(Arrays.stream(Team.values()).filter(t -> t.getAbbrev()
                    .equalsIgnoreCase(pr.getShortName().substring(0,3).trim())).map(Team::getId)
                    .collect(Collectors.toList()).get(0));
            temp.setHomeTeamDisplayName(Arrays.stream(Team.values()).filter(t -> t.getAbbrev()
                    .equalsIgnoreCase(pr.getShortName().substring(0,3).trim())).map(Team::getDisplayName)
                    .collect(Collectors.toList()).get(0));
            temp.setHomeTeamInitials(Arrays.stream(Team.values()).map(Team::getAbbrev).filter(abbrev -> abbrev
                    .equalsIgnoreCase(pr.getShortName().substring(0,3).trim()))
                    .collect(Collectors.toList()).get(0));


            temp.setAwayOppStrengthRating(awayStats.stream().filter(s -> s.getName()
                    .equalsIgnoreCase("oppSeasonStrengthRating"))
                    .map(s -> String.valueOf(s.getValue())).collect(Collectors.toList()).get(0));
            temp.setAwayOppPointDifference(awayStats.stream().filter(s -> s.getName()
                    .equalsIgnoreCase("teamPredPtDiff"))
                    .map(s -> String.valueOf(s.getValue())).collect(Collectors.toList()).get(0));
            temp.setAwayTeamChanceLoss(awayStats.stream().filter(s -> s.getName()
                    .equalsIgnoreCase("teamChanceLoss"))
                    .map(s -> String.valueOf(s.getValue())).collect(Collectors.toList()).get(0));
            temp.setAwayTeamDisplayName(Arrays.stream(Team.values()).filter(t -> t.getAbbrev()
                    .equalsIgnoreCase(pr.getShortName().substring(pr.getShortName().length()-4,pr.getShortName().length()-1)
                            .trim())).map(Team::getDisplayName)
                    .collect(Collectors.toList()).get(0));
            temp.setAwayTeamDisplayName(Arrays.stream(Team.values()).filter(t -> t.getAbbrev()
                    .equalsIgnoreCase(pr.getShortName().substring(pr.getShortName().length()-4,pr.getShortName().length()-1)
                            .trim())).map(Team::getId)
                    .collect(Collectors.toList()).get(0));
            temp.setAwayTeamInitials(Arrays.stream(Team.values()).map(Team::getAbbrev).filter(abbrev -> abbrev
                    .equalsIgnoreCase(pr.getShortName().substring(pr.getShortName().length()-4,pr.getShortName().length()-1)
                            .trim()))
                    .collect(Collectors.toList()).get(0));

            return temp;
        }catch (Exception e) { return temp; }
    }

    public List<SimplePrediction> getLatestPredictions(Long week, Long seasonType, Boolean forceUpdate, Boolean updateRepo){
        List<SimpleGame> sr = getGamesByWeek(week, seasonType, forceUpdate, updateRepo);

        ArrayList<String> ids = (ArrayList <String>) sr.stream().map(SimpleGame::getEventId).collect(Collectors.toList());
        ArrayList<SimplePrediction> simplePredictions = new ArrayList <>();
        ids.forEach(id -> simplePredictions.add(getLatestPrediction(id, forceUpdate, updateRepo)));
        return simplePredictions;
    }

    public SimpleOdds getOdds(String eventId, Boolean forceUpdate, Boolean updateRepo){
        OddsResponse response = nflService.getOdds(eventId, forceUpdate, updateRepo);
        EventOdds eo = response.getItems().get(0); //
        SimpleOdds temp = new SimpleOdds();
        temp.setEventId(eventId);
        try{
            temp.setOverOdds(String.valueOf(eo.getOverOdds()));
            temp.setOverUnder(String.valueOf(eo.getOverUnder()));
            temp.setSpread(String.valueOf(eo.getSpread()));
            temp.setDetails(eo.getDetails());

            temp.setAwayTeamAverageScore(String.valueOf(eo.getAwayTeamOdds().getAverageScore()));
            temp.setAwayTeamFavorite(String.valueOf(eo.getAwayTeamOdds().isFavorite()));
            temp.setAwayTeamMoneyLine(String.valueOf(eo.getAwayTeamOdds().getMoneyLine()));
            temp.setAwayTeamSpreadOdds(String.valueOf(eo.getAwayTeamOdds().getSpreadOdds()));
            temp.setAwayTeamSpreadLosses(String.valueOf(eo.getAwayTeamOdds().getSpreadRecord().getLosses()));
            temp.setAwayTeamSpreadWins(String.valueOf(eo.getAwayTeamOdds().getSpreadRecord().getWins()));
            temp.setAwayTeamSpreadSummary(eo.getAwayTeamOdds().getSpreadRecord().getSummary());


            temp.setHomeTeamAverageScore(String.valueOf(eo.getHomeTeamOdds().getAverageScore()));
            temp.setHomeTeamFavorite(String.valueOf(eo.getHomeTeamOdds().isFavorite()));
            temp.setHomeTeamMoneyLine(String.valueOf(eo.getHomeTeamOdds().getMoneyLine()));
            temp.setHomeTeamSpreadOdds(String.valueOf(eo.getHomeTeamOdds().getSpreadOdds()));
            temp.setHomeTeamSpreadLosses(String.valueOf(eo.getHomeTeamOdds().getSpreadRecord().getLosses()));
            temp.setHomeTeamSpreadWins(String.valueOf(eo.getHomeTeamOdds().getSpreadRecord().getWins()));
            temp.setHomeTeamSpreadSummary(eo.getHomeTeamOdds().getSpreadRecord().getSummary());

            return temp;
        }catch (Exception e) { return temp; }
    }

    public List<SimpleOdds> getAllOdds(Long week, Long seasonType, Boolean forceUpdate, Boolean updateRepo){
        List<SimpleGame> sr = getGamesByWeek(week, seasonType, forceUpdate, updateRepo);

        ArrayList<String> ids = (ArrayList <String>) sr.stream().map(SimpleGame::getEventId).collect(Collectors.toList());
        ArrayList<SimpleOdds> simpleOdds = new ArrayList <>();
        ids.forEach(id -> simpleOdds.add(getOdds(id, forceUpdate, updateRepo)));
        return simpleOdds;
    }
}
