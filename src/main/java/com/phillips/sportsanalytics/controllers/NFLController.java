package com.phillips.sportsanalytics.controllers;

import com.phillips.sportsanalytics.constant.Team;
import com.phillips.sportsanalytics.entity.Player;
import com.phillips.sportsanalytics.entity.Roster;
import com.phillips.sportsanalytics.services.NFLService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nfl")
@Api(description = "Set of endpoints for Creating, Retrieving, Updating and Deleting of Players.")
public class NFLController {

    private NFLService nflService;

    @RequestMapping(method = RequestMethod.GET, path="/players/all", produces = "application/json")
    @ApiOperation("${playercontroller.getallplayers}")
    public List<Player> getAllPlayers() {
        return nflService.getAllPlayers();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/players/byid", produces = "application/json")
    @ApiOperation("${playercontroller.getplayerbyid}")
    public Player getPlayerById(@ApiParam("Id of the player to be obtained. Cannot be empty.")
                                    @RequestParam String id) {
        return nflService.getPlayerById(id);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/players/byname", produces = "application/json")
    @ApiOperation("${playercontroller.getplayerbyname}")
    public Player getPlayerByName(@ApiParam("Id of the player to be obtained. Cannot be empty.")
                                @RequestParam String name) {
        return nflService.getPlayerByName(name);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/rosters/byid", produces = "application/json")
    @ApiOperation("${rostercontroller.getrosterbyteamid}")
    public Roster getRosterByTeamId(@RequestParam String id) {
        return nflService.getRosterByTeamId(id);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/rosters/byname", produces = "application/json")
    @ApiOperation("${rostercontroller.getrosterbyteamname}")
    public Roster getRosterByTeamName(@ApiParam("Name of the team for which the roster will be obtained. Cannot be empty.")
                                      @RequestParam("name") Team team) {
        return nflService.getRosterByTeam(team);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/rosters/all", produces = "application/json")
    @ApiOperation("${rostercontroller.getallrosters}")
    public List<Roster> getAllRosters(){
        return nflService.getAllRosters();
    }

    @Autowired
    public void setPlayerService(NFLService nflService) {
        this.nflService = nflService;
    }
}
