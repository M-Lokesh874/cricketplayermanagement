package com.ideas2it.cricketplayermanagement.controller;

import com.ideas2it.cricketplayermanagement.model.CricketPlayer;
import com.ideas2it.cricketplayermanagement.model.CricketTeam;
import com.ideas2it.cricketplayermanagement.service.CricketPlayerService;
import com.ideas2it.cricketplayermanagement.service.CricketTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CricketTeamController {

    @Autowired
    CricketTeamService cricketTeamService;

    @Autowired
    CricketPlayerService cricketPlayerService;

    @PostMapping(value = "saveCricketTeam", consumes = MediaType.APPLICATION_JSON_VALUE)
    public CricketTeam createTeam(@RequestBody CricketTeam cricketTeam) {
        System.out.println("team save works properly");
        return cricketTeamService.insertCricketTeam(cricketTeam);
    }

    @GetMapping(value = "getAllCricketTeams")
    public List<CricketTeam> getCricketTeams() {
        System.out.println("loaded successfully");
        return cricketTeamService.fetchCricketTeams();
    }

    @GetMapping(value = "getCricketTeam/{id}")
    public CricketTeam getTeamById(@PathVariable int id) {
        System.out.println("get works properly");
        return cricketTeamService.fetchCricketTeamById(id);
    }

    @DeleteMapping(value = "deleteTeam/{id}")
    public String deleteTeam(@PathVariable int id) {
        System.out.println("Deleted successfully");
        return cricketTeamService.deleteCricketTeam(id);
    }

    @PutMapping(value = "updateTeam")
    public CricketTeam updateTeam(@RequestBody CricketTeam cricketTeam) {
        System.out.println("updated successfully");
        return cricketTeamService.updateCricketTeam(cricketTeam);
    }

    @PutMapping(value = "assignCaptain/{teamId}/{playerId}")
    public CricketTeam assignCaptain(@PathVariable int teamId, @PathVariable int playerId) {
        CricketTeam cricketTeam = cricketTeamService.fetchCricketTeamById(teamId);
        CricketPlayer cricketPlayer = cricketPlayerService.fetchCricketPlayerById(playerId);
        return cricketTeamService.assignCaptain(cricketTeam, cricketPlayer);
    }

    @PutMapping(value = "assignWicketKeeper/{teamId}/{playerId}")
    public CricketTeam assignWicketKeeper(@PathVariable int teamId, @PathVariable int playerId) {
        CricketTeam cricketTeam = cricketTeamService.fetchCricketTeamById(teamId);
        CricketPlayer cricketPlayer = cricketPlayerService.fetchCricketPlayerById(playerId);
        return cricketTeamService.assignWicketKeeper(cricketTeam, cricketPlayer);
    }
}
