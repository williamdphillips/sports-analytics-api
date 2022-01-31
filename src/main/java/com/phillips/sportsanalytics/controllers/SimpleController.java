package com.phillips.sportsanalytics.controllers;

import com.phillips.sportsanalytics.model.simple.*;
import com.phillips.sportsanalytics.services.SimpleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
                    @Cacheable(value="static", key = "#root.method + #week.toString() + #seasontype.toString()", condition = "#week != null && #seasontype != null"),
                    @Cacheable(value="games", key = "#root.method", condition = "#week == null")
            }
    )
    @GetMapping(path = "/games", produces = "application/json")
    @ApiOperation("${simplecontroller.getgamesbyweek}")
    public List <SimpleGame> getGamesByWeek(
            @ApiParam(value = "Get ScoreboardResponse by week")
            @RequestParam(value = "week", required = false) Long week,
            @ApiParam(value = "Season Type | 1 = pre 2 = regular 3 = post")
            @RequestParam(value = "seasontype", required = false) Long seasonType
    ) {
        return simpleService.getGamesByWeek(week, seasonType);
    }

    @GetMapping(path = "/latestplay", produces = "application/json")
    @ApiOperation("${simplecontroller.getlatestplay}")
    public SimplePlay getLatestPlay(@RequestParam(required = true) String eventid) {
        return simpleService.getLatestPlay(eventid);
    }

    @Cacheable(value="plays", key="#root.method")
    @GetMapping(path = "/latestplays", produces = "application/json")
    @ApiOperation("${simplecontroller.getlatestplays}")
    public List<SimplePlay> getLatestPlays() {
        return simpleService.getLatestPlays();
    }

    @GetMapping(path = "/probablity", produces = "application/json")
    @ApiOperation("${simplecontroller.getwinprobability}")
    public SimpleProbability getWinProbability(@RequestParam(required = true) String eventid) {
        return simpleService.getGameProbability(eventid);
    }

    @Caching(
            cacheable = {
                    @Cacheable(value="static", key = "#root.method + #week", condition = "#week != null"),
                    @Cacheable(value="probabilities", key = "#root.method", condition = "#week == null")
            }
    )
    @GetMapping(path = "/probabilities", produces = "application/json")
    @ApiOperation("${simplecontroller.getwinprobabilities}")
    public List<SimpleProbability> getWinProbabilities(
            @ApiParam(value = "Get ScoreboardResponse by week")
            @RequestParam(value = "week", required = false) Long week,
            @ApiParam(value = "Season Type | 1 = pre 2 = regular 3 = post")
            @RequestParam(value = "seasontype", required = false) Long seasonType) {
        return simpleService.getGameProbabilities(week, seasonType);
    }

    @GetMapping(path = "/prediction", produces = "application/json")
    @ApiOperation("${simplecontroller.getlatestprediction}")
    public SimplePrediction getPrediction(@RequestParam(required = true) String eventid) {
        return simpleService.getLatestPrediction(eventid);
    }

    @Caching(
            cacheable = {
                    @Cacheable(value="static", key = "#root.method + #week", condition = "#week != null"),
                    @Cacheable(value="predictions", key = "#root.method", condition = "#week == null")
            }
    )
    @GetMapping(path = "/predictions", produces = "application/json")
    @ApiOperation("${simplecontroller.getlatestpredictions}")
    public List<SimplePrediction> getPredictions(
            @ApiParam(value = "Get ScoreboardResponse by week")
            @RequestParam(value = "week", required = false) Long week,
            @ApiParam(value = "Season Type | 1 = pre 2 = regular 3 = post")
            @RequestParam(value = "seasontype", required = false) Long seasonType) {
        return simpleService.getLatestPredictions(week, seasonType);
    }

    @GetMapping(path = "/odds", produces = "application/json")
    @ApiOperation("${simplecontroller.odds}")
    public SimpleOdds getOdds(@RequestParam(required = true) String eventid) {
        return simpleService.getOdds(eventid);
    }

    @Caching(
            cacheable = {
                    @Cacheable(value="static", key = "#root.method + #week", condition = "#week != null"),
                    @Cacheable(value="odds", key = "#root.method", condition = "#week == null")
            }
    )
    @GetMapping(path = "/allodds", produces = "application/json")
    @ApiOperation("${simplecontroller.allodds}")
    public List<SimpleOdds> getAllOdds(
            @ApiParam(value = "Get ScoreboardResponse by week")
            @RequestParam(value = "week", required = false) Long week,
            @ApiParam(value = "Season Type | 1 = pre 2 = regular 3 = post")
            @RequestParam(value = "seasontype", required = false) Long seasonType) {
        return simpleService.getAllOdds(week, seasonType);
    }



    @Autowired
    public void setSimpleService(SimpleService simpleService) {
        this.simpleService = simpleService;
    }
}
