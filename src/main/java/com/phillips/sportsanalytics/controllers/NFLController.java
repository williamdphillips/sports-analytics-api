package com.phillips.sportsanalytics.controllers;

import com.phillips.sportsanalytics.constant.Team;
import com.phillips.sportsanalytics.response.*;
import com.phillips.sportsanalytics.response.odds.OddsResponse;
import com.phillips.sportsanalytics.response.prediction.PredictionResponse;
import com.phillips.sportsanalytics.response.winprobability.WinProbabilityResponse;
import com.phillips.sportsanalytics.services.NFLService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/nfl")
@Api(description = "Set of endpoints for Creating, Retrieving, Updating and Deleting of Players.")
public class NFLController {

    private NFLService nflService;

    @RequestMapping(method = RequestMethod.GET, path = "/players", produces = "application/json")
    @ApiOperation("${nflcontroller.getplayer}")
    public PlayerResponse getPlayer(@RequestParam(required = false) Integer id,
                                    @RequestParam(required = false) String name) {
        if(id != null)
            return nflService.getPlayer(id);
        else
            return nflService.getPlayer(name);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/teams", produces = "application/json")
    @ApiOperation("${nflcontroller.getteam}")
    public TeamResponse getRosterByTeamId(@RequestParam(required = false) Integer id,
                                          @RequestParam(required = false) Team team) {
        if(id != null)
            return nflService.getTeam(id);
        else
            return nflService.getTeam(team);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/scoreboard", produces = "application/json")
    @ApiOperation("${nflcontroller.getscoreboard}")
    public ScoreboardResponse getScoreboard(
            @ApiParam(value = "Integer in the form of yyyy, yyyymm, or yyyymmdd to limit" +
            " output to a particular season, month, or day. If not passed, results default to the current season and" +
            " season type (pre/reg/post). For example, \"dates=20140630\". Note: Do not use in conjunction with the" +
            " advance parameter.")
            @RequestParam(value = "dates", required = false) String date,
            @ApiParam(value = "Get ScoreboardResponse by week")
            @RequestParam(value = "week", required = false) String week){
        return nflService.getScoreboard(date, week);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/playbyplay", produces = "application/json")
    @ApiOperation("${nflcontroller.playbyplay}")
    public PlayByPlayResponse getPlayByPlay(@RequestParam String eventId){
        return nflService.getPlayByPlay(eventId);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/winprobability", produces = "application/json")
    @ApiOperation("${nflcontroller.winprobability}")
    public WinProbabilityResponse getWinProbability(@RequestParam String eventId){
        return nflService.getWinProbability(eventId);
    }

    @GetMapping(path = "/prediction", produces = "application/json")
    @ApiOperation("${nflcontroller.prediction}")
    public PredictionResponse getPrediction(@RequestParam String eventId){
        return nflService.getPrediction(eventId);
    }

    @GetMapping(path = "/odds", produces = "application/json")
    @ApiOperation("${nflcontroller.odds}")
    public OddsResponse getOdds(@RequestParam String eventId){
        return nflService.getOdds(eventId);
    }

    @Autowired
    public void setNFLService(NFLService nflService) {
        this.nflService = nflService;
    }
}
