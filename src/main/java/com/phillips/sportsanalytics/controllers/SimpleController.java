package com.phillips.sportsanalytics.controllers;

import com.phillips.sportsanalytics.model.simple.*;
import com.phillips.sportsanalytics.services.SimpleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nfl/simple")
@Tag(name = "SimpleController", description = "Set of endpoints for UI to retrieve data in a simple format")
public class SimpleController {

    private SimpleService simpleService;


    @Caching(
            cacheable = {
                    @Cacheable(value="static", key = "#root.method + #week.toString() + #seasontype.toString()", condition = "#week != null && #seasontype != null"),
                    @Cacheable(value="games", key = "#root.method", condition = "#week == null")
            }
    )
    @GetMapping(path = "/games", produces = "application/json")
    @Operation(summary = "${simplecontroller.getgamesbyweek}")
    public List <SimpleGame> getGamesByWeek(
            @Parameter(ref = "Get ScoreboardResponse by week")
            @RequestParam(value = "week", required = false) Long week,
            @Parameter(ref = "Season Type | 1 = pre 2 = regular 3 = post")
            @RequestParam(value = "seasontype", required = false) Long seasonType,
            @RequestParam(required = false, value = "forceupdate") Boolean forceUpdate
    ) {
        return simpleService.getGamesByWeek(week, seasonType, forceUpdate);
    }

    @GetMapping(path = "/latestplay", produces = "application/json")
    @Operation(summary = "${simplecontroller.getlatestplay}")
    public SimplePlay getLatestPlay(@RequestParam(value = "eventid") String eventId,
                                    @RequestParam(required = false, value = "forceupdate") Boolean forceUpdate) {
        return simpleService.getLatestPlay(eventId, forceUpdate);
    }

    @Cacheable(value="plays", key="#root.method")
    @GetMapping(path = "/latestplays", produces = "application/json")
    @Operation(summary = "${simplecontroller.getlatestplays}")

    public List<SimplePlay> getLatestPlays(
            @RequestParam(required = false, value = "forceupdate") Boolean forceUpdate) {
        return simpleService.getLatestPlays(forceUpdate);
    }

    @GetMapping(path = "/probablity", produces = "application/json")
    @Operation(summary = "${simplecontroller.getwinprobability}")
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
    @Operation(summary = "${simplecontroller.getwinprobabilities}")
    public List<SimpleProbability> getWinProbabilities(
            @Parameter(ref = "Get ScoreboardResponse by week")
            @RequestParam(value = "week", required = false) Long week,
            @Parameter(ref = "Season Type | 1 = pre 2 = regular 3 = post")
            @RequestParam(value = "seasontype", required = false) Long seasonType,
            @RequestParam(required = false, value = "forceupdate") Boolean forceUpdate) {
        return simpleService.getGameProbabilities(week, seasonType, forceUpdate);
    }

    @GetMapping(path = "/prediction", produces = "application/json")
    @Operation(summary = "${simplecontroller.getlatestprediction}")
    public SimplePrediction getPrediction(@RequestParam(value = "eventid") String eventId,
                                          @RequestParam(required = false, value = "forceupdate") Boolean forceUpdate) {
        return simpleService.getLatestPrediction(eventId, forceUpdate);
    }

    @Caching(
            cacheable = {
                    @Cacheable(value="static", key = "#root.method + #week", condition = "#week != null"),
                    @Cacheable(value="predictions", key = "#root.method", condition = "#week == null")
            }
    )
    @GetMapping(path = "/predictions", produces = "application/json")
    @Operation(summary = "${simplecontroller.getlatestpredictions}")
    public List<SimplePrediction> getPredictions(
            @Parameter(ref = "Get ScoreboardResponse by week")
            @RequestParam(value = "week", required = false) Long week,
            @Parameter(ref = "Season Type | 1 = pre 2 = regular 3 = post")
            @RequestParam(value = "seasontype", required = false) Long seasonType,
            @RequestParam(required = false, value = "forceupdate") Boolean forceUpdate) {
        return simpleService.getLatestPredictions(week, seasonType, forceUpdate);
    }

    @GetMapping(path = "/odds", produces = "application/json")
    @Operation(summary = "${simplecontroller.odds}")
    public SimpleOdds getOdds(@RequestParam(value = "eventid") String eventId,
                              @RequestParam(required = false, value = "forceupdate") Boolean forceUpdate) {
        return simpleService.getOdds(eventId, forceUpdate);
    }

    @Caching(
            cacheable = {
                    @Cacheable(value="static", key = "#root.method + #week", condition = "#week != null"),
                    @Cacheable(value="odds", key = "#root.method", condition = "#week == null")
            }
    )
    @GetMapping(path = "/allodds", produces = "application/json")
    @Operation(summary = "${simplecontroller.allodds}")
    public List<SimpleOdds> getAllOdds(
            @Parameter(ref = "Get ScoreboardResponse by week")
            @RequestParam(value = "week", required = false) Long week,
            @Parameter(ref = "Season Type | 1 = pre 2 = regular 3 = post")
            @RequestParam(value = "seasontype", required = false) Long seasonType,
            @RequestParam(required = false, value = "forceupdate") Boolean forceUpdate) {
        return simpleService.getAllOdds(week, seasonType, forceUpdate);
    }



    @Autowired
    public void setSimpleService(SimpleService simpleService) {
        this.simpleService = simpleService;
    }
}
