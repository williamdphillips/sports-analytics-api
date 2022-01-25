package com.phillips.sportsanalytics.controllers;

import com.phillips.sportsanalytics.model.Schedule;
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
                    @Cacheable(value="static", key = "#root.method + #week", condition = "#week != null"),
                    @Cacheable(value="games", key = "#root.method", condition = "#week == null")
            }
    )
    @GetMapping(path = "/games", produces = "application/json")
    @ApiOperation("${uicontroller.games}")
    public Schedule getAllGames(
            @RequestParam(required = false) String week,
            @RequestParam(value = "seasontype", required = false) String seasonType) {
        return uiService.getAllGames(week, seasonType);
    }

    @Autowired
    public void setUiService(UIService uiService) {
        this.uiService = uiService;
    }
}
