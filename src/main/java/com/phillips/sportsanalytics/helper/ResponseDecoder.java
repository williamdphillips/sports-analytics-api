package com.phillips.sportsanalytics.helper;

import com.phillips.sportsanalytics.model.Event;
import com.phillips.sportsanalytics.model.Play;
import com.phillips.sportsanalytics.model.Team;
import com.phillips.sportsanalytics.response.ScoreboardResponse;
import com.phillips.sportsanalytics.response.odds.EventOdds;
import com.phillips.sportsanalytics.response.odds.OddsResponse;
import com.phillips.sportsanalytics.response.playbyplay.PlayByPlayResponse;
import com.phillips.sportsanalytics.response.prediction.PredictionResponse;
import com.phillips.sportsanalytics.response.prediction.StatisticsItem;
import com.phillips.sportsanalytics.response.winprobability.ItemsItem;
import com.phillips.sportsanalytics.response.winprobability.WinProbabilityResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.phillips.sportsanalytics.util.Utils.ignoringExc;

public class ResponseDecoder {
    public static ArrayList<Event> decode(ScoreboardResponse sr){
        ArrayList <Event> events = new ArrayList <>();
        for (ScoreboardResponse.Event e:sr.events
        ) {
            Event tempEvent = new Event();
            tempEvent.setEventId(e.competitions[0].id);
            tempEvent.setDisplayClock(e.competitions[0].status.displayClock);
            tempEvent.setDisplayClockDetail(e.competitions[0].status.type.detail);
            tempEvent.setIsCompleted(e.competitions[0].status.type.completed);
            tempEvent.setShortDetail(e.competitions[0].status.type.shortDetail);
            tempEvent.setDescription(e.competitions[0].status.type.description);
            tempEvent.setEventId(e.competitions[0].id);
            tempEvent.setWeek(String.valueOf(sr.week.number));
            tempEvent.setState(e.competitions[0].status.type.state);
            tempEvent.setPeriod(e.status.period);

            Team homeTeam = new Team();
            homeTeam.setId(e.competitions[0].competitors[0].team.id);
            homeTeam.setDisplayName(e.competitions[0].competitors[0].team.displayName);
            homeTeam.setCurrentScore(e.competitions[0].competitors[0].score);
            homeTeam.setPrimaryColor(e.competitions[0].competitors[0].team.color);
            homeTeam.setShortName(e.competitions[0].competitors[0].team.shortDisplayName);
            homeTeam.setLogoURL(e.competitions[0].competitors[0].team.logo);
            homeTeam.setAbbrev(e.competitions[0].competitors[0].team.abbreviation);
            if(!homeTeam.getAbbrev().contains("AFC") && !homeTeam.getAbbrev().contains("NFC")){
                ignoringExc(() -> homeTeam.setRecord(e.competitions[0].competitors[0].records[0].summary));
                ignoringExc(() -> homeTeam.setWins(e.competitions[0].competitors[0].records[0].summary.split("-")[0]));
                ignoringExc(() -> homeTeam.setLosses(e.competitions[0].competitors[0].records[0].summary.split("-")[1]));
            }

            tempEvent.setHomeTeam(homeTeam);

            Team awayTeam = new Team();
            awayTeam.setId(e.competitions[0].competitors[1].team.id);
            awayTeam.setDisplayName(e.competitions[0].competitors[1].team.displayName);
            awayTeam.setCurrentScore(e.competitions[0].competitors[1].score);
            awayTeam.setPrimaryColor(e.competitions[0].competitors[1].team.color);
            awayTeam.setShortName(e.competitions[0].competitors[1].team.shortDisplayName);
            awayTeam.setLogoURL(e.competitions[0].competitors[1].team.logo);
            awayTeam.setAbbrev(e.competitions[0].competitors[1].team.abbreviation);
            if(!homeTeam.getAbbrev().contains("AFC") && !homeTeam.getAbbrev().contains("NFC")){
                ignoringExc(() -> awayTeam.setRecord(e.competitions[0].competitors[1].records[0].summary));
                ignoringExc(() -> awayTeam.setWins(e.competitions[0].competitors[1].records[0].summary.split("-")[0]));
                ignoringExc(() -> awayTeam.setLosses(e.competitions[0].competitors[1].records[0].summary.split("-")[1]));
            }

            tempEvent.setAwayTeam(awayTeam);

            events.add(tempEvent);
        }
        return events;
    }

    public static void updateOdds(OddsResponse or, Event event){
            try{
                EventOdds eo = or.getItems().stream().filter(e -> e.getProvider().getName().equalsIgnoreCase("DraftKings")).collect(Collectors.toList()).get(0);
                event.setOverOdds(String.valueOf(eo.getOverOdds()));
                event.setOverUnder(String.valueOf(eo.getOverUnder()));
                event.setSpread(String.valueOf(eo.getSpread()));
                event.setSpreadDetails(eo.getDetails());

                event.getAwayTeam().setAverageScore(eo.getAwayTeamOdds().getAverageScore());
                event.getAwayTeam().setFavorite(eo.getAwayTeamOdds().isFavorite());
                event.getAwayTeam().setMoneyLine(eo.getAwayTeamOdds().getMoneyLine());
                event.getAwayTeam().setSpreadOdds(eo.getAwayTeamOdds().getSpreadOdds());
                if(eo.getAwayTeamOdds().getSpreadRecord() != null){
                    event.getAwayTeam().setSpreadLosses(eo.getAwayTeamOdds().getSpreadRecord().getLosses());
                    event.getAwayTeam().setSpreadWins(eo.getAwayTeamOdds().getSpreadRecord().getWins());
                    event.getAwayTeam().setSpreadSummary(eo.getAwayTeamOdds().getSpreadRecord().getSummary());
                }

                event.getHomeTeam().setAverageScore(eo.getHomeTeamOdds().getAverageScore());
                event.getHomeTeam().setFavorite(eo.getHomeTeamOdds().isFavorite());
                event.getHomeTeam().setMoneyLine(eo.getHomeTeamOdds().getMoneyLine());
                event.getHomeTeam().setSpreadOdds(eo.getHomeTeamOdds().getSpreadOdds());
                if(eo.getHomeTeamOdds().getSpreadRecord() != null){
                    event.getHomeTeam().setSpreadLosses(eo.getHomeTeamOdds().getSpreadRecord().getLosses());
                    event.getHomeTeam().setSpreadWins(eo.getHomeTeamOdds().getSpreadRecord().getWins());
                    event.getHomeTeam().setSpreadSummary(eo.getHomeTeamOdds().getSpreadRecord().getSummary());
                }
            }catch (Exception ignored) { }
    }

    public static void updatePlays(PlayByPlayResponse pr, Event event){
            try{
                Play play = new Play();
                com.phillips.sportsanalytics.response.playbyplay.Play currentPlay = pr.drives.current.plays[pr.drives.current.plays.length - 1];
                play.setPlayDescription(currentPlay.text);
                play.setDown(currentPlay.start.down);
                play.setDownDistanceShortText(currentPlay.start.shortDownDistanceText);
                play.setDriveDescription(pr.drives.current.description);
                play.setIsScoringPlay(currentPlay.scoringPlay);
                play.setDownDistanceText(currentPlay.start.downDistanceText);
                play.setYardLine(currentPlay.start.yardLine);
                play.setFirstDownDistance(currentPlay.start.distance);
                play.setPossessionText(currentPlay.start.possessionText);


                Team teamInPossession;
                String id = Arrays.stream(com.phillips.sportsanalytics.constant.Team.values()).filter(
                        t -> t.getId().equals(currentPlay.start.team.id)).collect(Collectors.toList())
                        .get(0).getId();
                if(event.getHomeTeam().getId().equalsIgnoreCase(id))
                    teamInPossession = event.getHomeTeam();
                else
                    teamInPossession = event.getAwayTeam();
                play.setTeamInPossession(teamInPossession);
                event.setCurrentPlay(play);

            }catch (Exception ignored) { }
    }

    public static void updatePredictions(PredictionResponse pr, Event event){
            try{

                List<StatisticsItem> homeStats = pr.getHomeTeam().getStatistics();
                List<StatisticsItem> awayStats = pr.getAwayTeam().getStatistics();

                event.getHomeTeam().setOppStrengthRating(homeStats.stream().filter(s -> s.getName()
                        .equalsIgnoreCase("oppSeasonStrengthRating"))
                        .map(StatisticsItem::getValue).collect(Collectors.toList()).get(0));
                event.getHomeTeam().setOppPointDifference(homeStats.stream().filter(s -> s.getName()
                        .equalsIgnoreCase("teamPredPtDiff"))
                        .map(StatisticsItem::getValue).collect(Collectors.toList()).get(0));
                event.getHomeTeam().setWinPrediction(homeStats.stream().filter(s -> s.getName()
                        .equalsIgnoreCase("teamChanceLoss"))
                        .map(StatisticsItem::getValue).collect(Collectors.toList()).get(0));

                event.getAwayTeam().setOppStrengthRating(awayStats.stream().filter(s -> s.getName()
                        .equalsIgnoreCase("oppSeasonStrengthRating"))
                        .map(StatisticsItem::getValue).collect(Collectors.toList()).get(0));
                event.getAwayTeam().setOppPointDifference(awayStats.stream().filter(s -> s.getName()
                        .equalsIgnoreCase("teamPredPtDiff"))
                        .map(StatisticsItem::getValue).collect(Collectors.toList()).get(0));
                event.getAwayTeam().setWinPrediction(awayStats.stream().filter(s -> s.getName()
                        .equalsIgnoreCase("teamChanceLoss"))
                        .map(StatisticsItem::getValue).collect(Collectors.toList()).get(0));

            }catch (Exception ignored) { }
    }

    public static void updateWinPercentage(WinProbabilityResponse wr, Event event){
            try {
                ItemsItem latestPrediction = wr.getItems().get(wr.getItems().size() - 1);
                event.getHomeTeam().setWinPercentage(latestPrediction.getHomeWinPercentage());
                event.getAwayTeam().setWinPercentage(latestPrediction.getAwayWinPercentage());
            }catch (Exception ignored) { }
    }
}
