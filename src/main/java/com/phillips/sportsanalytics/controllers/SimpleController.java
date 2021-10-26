package com.phillips.sportsanalytics.controllers;

import com.phillips.sportsanalytics.model.SimpleGame;
import com.phillips.sportsanalytics.model.SimplePlay;
import com.phillips.sportsanalytics.services.SimpleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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

    @Cacheable(value="games", key="#root.method")
    @RequestMapping(method = RequestMethod.GET, path = "/games", produces = "application/json")
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

    @Autowired
    public void setSimpleService(SimpleService simpleService) {
        this.simpleService = simpleService;
    }
}
