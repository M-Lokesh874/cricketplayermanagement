package com.ideas2it.cricketplayermanagement.controller;

import com.ideas2it.cricketplayermanagement.mapper.ObjetMapper;
import com.ideas2it.cricketplayermanagement.model.CricketPlayer;
import com.ideas2it.cricketplayermanagement.model.CricketPlayerStats;
import com.ideas2it.cricketplayermanagement.model.CricketPlayerStatsDto;
import com.ideas2it.cricketplayermanagement.service.CricketPlayerService;
import com.ideas2it.cricketplayermanagement.service.CricketPlayerStatsService;
import com.ideas2it.cricketplayermanagement.util.exception.PlayerManagementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
public class CricketPlayerStatsController {
    @Autowired
    CricketPlayerStatsService cricketPlayerStatsService;
    @Autowired
    CricketPlayerService cricketPlayerService;
    @Autowired
    public ObjetMapper objetMapper;
    @PostMapping(value = "saveStats")
    public CricketPlayerStats createStats(@RequestBody CricketPlayerStats cricketPlayerStats) {
        cricketPlayerStats.setBattingAverage((getBattingAverage(cricketPlayerStats.getNoOfMatch(),cricketPlayerStats.getTotalRun())));
        cricketPlayerStats.setStrikeRate((getStrikeRate(cricketPlayerStats.getTotalRun(),cricketPlayerStats.getNoOfBallsFaced())));
        return cricketPlayerStatsService.insertCricketPlayerStats(cricketPlayerStats);
    }
    @GetMapping(value = "getAllStats")
    public List<CricketPlayerStatsDto> getAllStats() throws PlayerManagementException {
        List<CricketPlayerStats> cricketPlayerStats = cricketPlayerStatsService.fetchCricketPlayerStats();
        return objetMapper.convertStatsEntityIntoDto(cricketPlayerStats);
    }
    @GetMapping(value = "getStatsById/{id}")
    public CricketPlayerStatsDto getStatsById(@PathVariable int id) throws PlayerManagementException {
        CricketPlayerStats cricketPlayerStats = cricketPlayerStatsService.fetchCricketPlayerStatsById(id);
        return  objetMapper.convertStatsEntityIntoDto(cricketPlayerStats);
    }
    @PutMapping(value = "updateStats/{id}")
    public String updateStats(@RequestBody CricketPlayerStats cricketPlayerStats, @PathVariable int id) throws PlayerManagementException {
        return cricketPlayerStatsService.updateCricketPlayerStats(cricketPlayerStats, id);
    }
    @DeleteMapping(value = "deleteStats/{id}")
    public void deleteStats(@PathVariable int id) throws PlayerManagementException {
        cricketPlayerStatsService.deleteCricketPlayerStats(id);
    }
    @PutMapping (value = "assignPlayer/{statsId}/{playerId}")
    public String assignPlayer(@PathVariable int playerId, @PathVariable int statsId) throws PlayerManagementException {
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
