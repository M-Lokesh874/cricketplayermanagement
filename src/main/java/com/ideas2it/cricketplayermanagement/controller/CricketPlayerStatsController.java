package com.ideas2it.cricketplayermanagement.controller;

import com.ideas2it.cricketplayermanagement.model.CricketPlayer;
import com.ideas2it.cricketplayermanagement.model.CricketPlayerStats;
import com.ideas2it.cricketplayermanagement.service.CricketPlayerService;
import com.ideas2it.cricketplayermanagement.service.CricketPlayerStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CricketPlayerStatsController {
    @Autowired
    CricketPlayerStatsService cricketPlayerStatsService;
    @Autowired
    CricketPlayerService cricketPlayerService;

    @PostMapping(value = "saveStats")
    public CricketPlayerStats createStats(@RequestBody CricketPlayerStats cricketPlayerStats) {
        cricketPlayerStats.setBattingAverage((getBattingAverage(cricketPlayerStats.getNoOfMatch(),cricketPlayerStats.getTotalRun())));
        cricketPlayerStats.setStrikeRate((getStrikeRate(cricketPlayerStats.getTotalRun(),cricketPlayerStats.getNoOfBallsFaced())));
        System.out.println("stats save works properly");
        System.out.println(cricketPlayerStats);
        return cricketPlayerStatsService.insertCricketPlayerStats(cricketPlayerStats);
    }

    @GetMapping(value = "getAllStats")
    public List<CricketPlayerStats> getAllStats() {
        System.out.println("loaded successfully");
        return cricketPlayerStatsService.fetchCricketPlayerStats();
    }

    @GetMapping(value = "getStatsById/{id}")
    public CricketPlayerStats getStatsById(@PathVariable int id) {
        System.out.println("get works properly");
        return cricketPlayerStatsService.fetchCricketPlayerStatsById(id);
    }

    @PutMapping(value = "updateStats")
    public CricketPlayerStats updateStats(@RequestBody CricketPlayerStats cricketPlayerStats) {
        System.out.println("update works properly");
        return cricketPlayerStatsService.updateCricketPlayerStats(cricketPlayerStats);
    }

    @DeleteMapping(value = "deleteStats/{id}")
    public String deleteStats(@PathVariable int id) {
        System.out.println("deleted successfully");
        return cricketPlayerStatsService.deleteCricketPlayerStats(id);
    }

    @PutMapping (value = "assignPlayer/{statsId}/{playerId}")
    public CricketPlayerStats getPlayerForStats(@PathVariable int playerId, @PathVariable int statsId) {
        CricketPlayerStats cricketPlayerStats = cricketPlayerStatsService.fetchCricketPlayerStatsById(statsId);
        CricketPlayer cricketPlayer = cricketPlayerService.fetchCricketPlayerById(playerId);
        return cricketPlayerStatsService.assignPlayer(cricketPlayerStats, cricketPlayer);
    }
    public double getBattingAverage(int noOfMatch, int totalRun) {
        return (totalRun / noOfMatch);
    }
    public double getStrikeRate(int totalRun, int noOfBallsFaced) {
        return (100 * totalRun / noOfBallsFaced);
    }
}
