package com.phillips.sportsanalytics.controllers;

import com.phillips.sportsanalytics.model.ScheduleInfo;
import com.phillips.sportsanalytics.services.UIService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/nfl/ui")
@Tag(name = "UIController", description = "Set of endpoints for UI to retrieve data")
public class UIController {

    private UIService uiService;


    @Caching(
            cacheable = {
                    @Cacheable(value="static", key = "#root.method + #year.toString() + #week.toString() + #seasonType.toString()", condition = "#year != null && #week != null && #seasonType != null"),
                    @Cacheable(value="games", key = "#root.method", condition = "#week == null")
            }
    )
    @GetMapping(path = "/games", produces = "application/json")
    @Operation(summary = "${uicontroller.games}")
    public ScheduleInfo getAllGames(
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
