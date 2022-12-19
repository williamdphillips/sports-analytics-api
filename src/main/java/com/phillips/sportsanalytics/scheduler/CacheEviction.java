package com.phillips.sportsanalytics.scheduler;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import static javax.management.timer.Timer.ONE_MINUTE;
import static javax.management.timer.Timer.ONE_SECOND;

@Component
@RequiredArgsConstructor
class CacheEviction {
    private static final Logger logger = LogManager.getLogger(CacheEviction.class);

    @Scheduled(fixedRate = ONE_MINUTE)
    @CacheEvict(value = { "static", "games", "plays" }, allEntries = true)
    public void clearCache() {
        logger.log(Level.INFO, "Cache cleared");
    }
}