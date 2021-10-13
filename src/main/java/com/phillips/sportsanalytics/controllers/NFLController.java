package com.phillips.sportsanalytics.controllers;

import com.phillips.sportsanalytics.constant.Team;
import com.phillips.sportsanalytics.response.PlayByPlayResponse;
import com.phillips.sportsanalytics.response.PlayerResponse;
import com.phillips.sportsanalytics.response.TeamResponse;
import com.phillips.sportsanalytics.response.ScoreboardResponse;
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
            @RequestParam(value = "dates", required = false) String byDate,
            @ApiParam(value = "Get ScoreboardResponse by week")
            @RequestParam(value = "week", required = false) String byWeek){
        return nflService.getScoreboard(byDate, byWeek);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/playbyplay", produces = "application/json")
    @ApiOperation("${nflcontroller.playbyplay}")
    public PlayByPlayResponse getPlayByPlay(@RequestParam String eventId){
        return nflService.getPlayByPlay(eventId);
    }

    @Autowired
    public void setPlayerService(NFLService nflService) {
        this.nflService = nflService;
    }
}
