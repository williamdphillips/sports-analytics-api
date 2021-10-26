package com.phillips.sportsanalytics.controllers;

import com.phillips.sportsanalytics.model.simple.SimpleGame;
import com.phillips.sportsanalytics.model.simple.SimplePlay;
import com.phillips.sportsanalytics.model.simple.SimpleProbability;
import com.phillips.sportsanalytics.services.SimpleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nfl/simple")
@Api(description = "Set of endpoints for UI to retrieve data in a simple format")
public class SimpleController {

    private SimpleService simpleService;


    @Caching(
            cacheable = {
                    @Cacheable(value="static", key = "#root.method + #week", condition = "#week != null"),
                    @Cacheable(value="games", key = "#root.method", condition = "#week == null")
            }
    )
    @GetMapping(path = "/games", produces = "application/json")
    @ApiOperation("${nflcontroller.getcurrentgames}")
    public List <SimpleGame> getGamesByWeek(@RequestParam(required = false) String week) {
        return simpleService.getGamesByWeek(week);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/latestplay", produces = "application/json")
    @ApiOperation("${nflcontroller.getlatestplay}")
    public SimplePlay getLatestPlay(@RequestParam(required = true) String eventid) {
        return simpleService.getLatestPlay(eventid);
    }

    @Cacheable(value="plays", key="#root.method")
    @RequestMapping(method = RequestMethod.GET, path = "/latestplays", produces = "application/json")
    @ApiOperation("${nflcontroller.getlatestplays}")
    public List<SimplePlay> getLatestPlays() {
        return simpleService.getLatestPlays();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/probablity", produces = "application/json")
    @ApiOperation("${nflcontroller.getwinprobabilit}")
    public SimpleProbability getWinProbability(@RequestParam(required = true) String eventid) {
        return simpleService.getGameProbability(eventid);
    }

    @Cacheable(value="plays", key="#root.method")
    @RequestMapping(method = RequestMethod.GET, path = "/probabilities", produces = "application/json")
    @ApiOperation("${nflcontroller.getwinprobabilities}")
    public List<SimpleProbability> getWinProbabilities() {
        return simpleService.getGameProbabilities();
    }

    @Autowired
    public void setSimpleService(SimpleService simpleService) {
        this.simpleService = simpleService;
    }
}
