package com.ideas2it.cricketplayermanagement.controller;

import com.ideas2it.cricketplayermanagement.model.CricketPlayer;
import com.ideas2it.cricketplayermanagement.model.CricketTeam;
import com.ideas2it.cricketplayermanagement.service.CricketPlayerService;
import com.ideas2it.cricketplayermanagement.service.CricketTeamService;
import com.ideas2it.cricketplayermanagement.util.exception.PlayerManagementException;
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

    @PostMapping(value = "saveCricketTeam")
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
        try {
            System.out.println("get works properly");
            return cricketTeamService.fetchCricketTeamById(id);
        } catch (PlayerManagementException e) {
            System.out.println(e);
        }
        return null;
    }

    @DeleteMapping(value = "deleteTeam/{id}")
    public String deleteTeam(@PathVariable int id) {
        try {
            System.out.println("Deleted successfully");
            return cricketTeamService.deleteCricketTeam(id);
        } catch (PlayerManagementException e) {
            System.out.println(e);
        }
        return null;
    }

    @PutMapping(value = "updateTeam")
    public CricketTeam updateTeam(@RequestBody CricketTeam cricketTeam) {
        System.out.println("updated successfully");
        return cricketTeamService.updateCricketTeam(cricketTeam);
    }

    @PutMapping(value = "assignCaptain/{teamId}/{playerId}")
    public String assignCaptain(@PathVariable int teamId, @PathVariable int playerId) throws PlayerManagementException {
        CricketTeam cricketTeam = cricketTeamService.fetchCricketTeamById(teamId);
        CricketPlayer cricketPlayer = cricketPlayerService.fetchCricketPlayerById(playerId);
        return cricketTeamService.assignCaptain(cricketTeam, cricketPlayer);
    }

    @PutMapping(value = "assignWicketKeeper/{teamId}/{playerId}")
    public String assignWicketKeeper(@PathVariable int teamId, @PathVariable int playerId) throws PlayerManagementException {
        CricketTeam cricketTeam = cricketTeamService.fetchCricketTeamById(teamId);
        CricketPlayer cricketPlayer = cricketPlayerService.fetchCricketPlayerById(playerId);
        return cricketTeamService.assignWicketKeeper(cricketTeam, cricketPlayer);
    }
}
