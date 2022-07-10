package com.phillips.sportsanalytics.controllers;

import com.phillips.sportsanalytics.constant.Team;
import com.phillips.sportsanalytics.response.*;
import com.phillips.sportsanalytics.response.odds.OddsResponse;
import com.phillips.sportsanalytics.response.playbyplay.PlayByPlayResponse;
import com.phillips.sportsanalytics.response.prediction.PredictionResponse;
import com.phillips.sportsanalytics.response.winprobability.WinProbabilityResponse;
import com.phillips.sportsanalytics.services.NFLService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/nfl")
@Tag(name = "NFLController", description = "Set of endpoints for Creating, Retrieving, Updating and Deleting of Players.")
public class NFLController {

    private NFLService nflService;

    @GetMapping(path = "/players", produces = "application/json")
    @Operation(summary = "${nflcontroller.getplayer}")
    public PlayerResponse getPlayer(@RequestParam(required = false) Integer id,
                                    @RequestParam(required = false) String name) {
        if(id != null)
            return nflService.getPlayer(id);
        else
            return nflService.getPlayer(name);
    }

    @GetMapping(path = "/teams", produces = "application/json")
    @Operation(summary = "${nflcontroller.getteam}")
    public TeamResponse getRosterByTeamId(@RequestParam(required = false) Integer id,
                                          @RequestParam(required = false) Team team) {
        if(id != null)
            return nflService.getTeam(id);
        else
            return nflService.getTeam(team);
    }

    @GetMapping(path = "/scoreboard", produces = "application/json")
    @Operation(summary = "${nflcontroller.getscoreboard}")
    public ScoreboardResponse getScoreboard(
            @Parameter(ref = "Integer in the form of yyyy, yyyymm, or yyyymmdd to limit" +
                    " output to a particular season, month, or day. If not passed, results default to the current season and" +
                    " season type (pre/reg/post). For example, \"dates=20140630\". Note: Do not use in conjunction with the" +
                    " advance parameter.")
            @RequestParam(value = "dates", required = false) Long date,
            @Parameter(ref = "Get ScoreboardResponse by week")
            @RequestParam(value = "week", required = false) Long week,
            @Parameter(ref = "Season Type | 1 = pre 2 = regular 3 = post")
            @RequestParam(value = "seasontype", required = false) Long seasonType,
            @RequestParam(required = false, value = "forceupdate") Boolean forceUpdate,
            @RequestParam(required = false, value = "updaterepo") Boolean updateRepo) {
        return nflService.getScoreboard(date, week, seasonType, forceUpdate, updateRepo);
    }

    @GetMapping(path = "/playbyplay", produces = "application/json")
    @Operation(summary = "${nflcontroller.playbyplay}")
    public PlayByPlayResponse getPlayByPlay(@RequestParam String eventId,
                                            @RequestParam(required = false, value = "forceupdate") Boolean forceUpdate,
                                            @RequestParam(required = false, value = "updaterepo") Boolean updateRepo){
        return nflService.getPlayByPlay(eventId, forceUpdate, updateRepo);
    }

    @GetMapping(path = "/winprobability", produces = "application/json")
    @Operation(summary = "${nflcontroller.winprobability}")
    public WinProbabilityResponse getWinProbability(@RequestParam String eventId){
        return nflService.getWinProbability(eventId);
    }

    @GetMapping(path = "/prediction", produces = "application/json")
    @Operation(summary = "${nflcontroller.prediction}")
    public PredictionResponse getPrediction(@RequestParam String eventId,
                                            @RequestParam(required = false, value = "forceupdate") Boolean forceUpdate,
                                            @RequestParam(required = false, value = "updaterepo") Boolean updateRepo){
        return nflService.getPrediction(eventId, forceUpdate, updateRepo);
    }

    @GetMapping(path = "/odds", produces = "application/json")
    @Operation(summary = "${nflcontroller.odds}")
    public OddsResponse getOdds(@RequestParam String eventId,
                                @RequestParam(required = false, value = "forceupdate") Boolean forceUpdate,
                                @RequestParam(required = false, value = "updaterepo") Boolean updateRepo){
        return nflService.getOdds(eventId, forceUpdate, updateRepo);
    }

    @Autowired
    public void setNFLService(@Qualifier("NFLService") NFLService nflService) {
        this.nflService = nflService;
    }
}
