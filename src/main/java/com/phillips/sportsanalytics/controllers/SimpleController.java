package com.phillips.sportsanalytics.controllers;

import com.phillips.sportsanalytics.constant.Team;
import com.phillips.sportsanalytics.model.SimpleGame;
import com.phillips.sportsanalytics.response.PlayByPlayResponse;
import com.phillips.sportsanalytics.response.PlayerResponse;
import com.phillips.sportsanalytics.response.ScoreboardResponse;
import com.phillips.sportsanalytics.response.TeamResponse;
import com.phillips.sportsanalytics.services.NFLService;
import com.phillips.sportsanalytics.services.SimpleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/nfl/simple")
@Api(description = "Set of endpoints for UI to retrieve data in a simple format")
public class SimpleController {

    private SimpleService simpleService;

    @RequestMapping(method = RequestMethod.GET, path = "/games", produces = "application/json")
    @ApiOperation("${nflcontroller.getcurrentgames}")
    public List <SimpleGame> getGamesByWeek(@RequestParam(required = true) String week) {
        return simpleService.getGamesByWeek(week);
    }

    @Autowired
    public void setSimpleService(SimpleService simpleService) {
        this.simpleService = simpleService;
    }
}
