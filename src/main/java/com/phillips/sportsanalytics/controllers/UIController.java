package com.phillips.sportsanalytics.controllers;

import com.phillips.sportsanalytics.model.MasterSchedule;
import com.phillips.sportsanalytics.services.UIService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/nfl/ui")
@Api(description = "Set of endpoints for UI to retrieve data")
public class UIController {

    private UIService uiService;


    @Caching(
            cacheable = {
                    @Cacheable(value="static", key = "#root.method + #year.toString() + #week.toString() + #seasontype.toString()", condition = "#year != null && #week != null && #seasontype != null"),
                    @Cacheable(value="games", key = "#root.method", condition = "#week == null")
            }
    )
    @GetMapping(path = "/games", produces = "application/json")
    @ApiOperation("${uicontroller.games}")
    public MasterSchedule getAllGames(
            @RequestParam(required = false) Long year,
            @RequestParam(required = false) Long week,
            @RequestParam(value = "seasontype", required = false) Long seasonType) {
        return uiService.getAllGames(year, week, seasonType);
    }

    @Autowired
    public void setUiService(UIService uiService) {
        this.uiService = uiService;
    }
}
