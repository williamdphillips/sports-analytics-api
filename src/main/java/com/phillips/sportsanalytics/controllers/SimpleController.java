package com.phillips.sportsanalytics.controllers;

import com.phillips.sportsanalytics.model.simple.*;
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

    @GetMapping(path = "/latestplay", produces = "application/json")
    @ApiOperation("${nflcontroller.getlatestplay}")
    public SimplePlay getLatestPlay(@RequestParam(required = true) String eventid) {
        return simpleService.getLatestPlay(eventid);
    }

    @Cacheable(value="plays", key="#root.method")
    @GetMapping(path = "/latestplays", produces = "application/json")
    @ApiOperation("${nflcontroller.getlatestplays}")
    public List<SimplePlay> getLatestPlays() {
        return simpleService.getLatestPlays();
    }

    @GetMapping(path = "/probablity", produces = "application/json")
    @ApiOperation("${nflcontroller.getwinprobability}")
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
    @ApiOperation("${nflcontroller.getwinprobabilities}")
    public List<SimpleProbability> getWinProbabilities(@RequestParam(required = false) String week) {
        return simpleService.getGameProbabilities(week);
    }

    @GetMapping(path = "/prediction", produces = "application/json")
    @ApiOperation("${nflcontroller.getlatestprediction}")
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
    @ApiOperation("${nflcontroller.getlatestpredictions}")
    public List<SimplePrediction> getPredictions(@RequestParam(required = false) String week) {
        return simpleService.getLatestPredictions(week);
    }

    @GetMapping(path = "/odds", produces = "application/json")
    @ApiOperation("${nflcontroller.odds}")
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
    @ApiOperation("${nflcontroller.allodds}")
    public List<SimpleOdds> getAllOdds(@RequestParam(required = false) String week) {
        return simpleService.getAllOdds(week);
    }

    @Autowired
    public void setSimpleService(SimpleService simpleService) {
        this.simpleService = simpleService;
    }
}
