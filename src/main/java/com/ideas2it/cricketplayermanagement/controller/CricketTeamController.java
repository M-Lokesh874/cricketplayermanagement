package com.ideas2it.cricketplayermanagement.controller;

import com.ideas2it.cricketplayermanagement.model.CricketPlayer;
import com.ideas2it.cricketplayermanagement.model.CricketTeam;
import com.ideas2it.cricketplayermanagement.service.CricketPlayerService;
import com.ideas2it.cricketplayermanagement.service.CricketTeamService;
import com.ideas2it.cricketplayermanagement.util.exception.PlayerManagementException;
import org.springframework.beans.factory.annotation.Autowired;
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
        return cricketTeamService.insertCricketTeam(cricketTeam);
    }

    @GetMapping(value = "getAllCricketTeams")
    public List<CricketTeam> getCricketTeams() throws PlayerManagementException {
        return cricketTeamService.fetchCricketTeams();
    }

    @GetMapping(value = "getCricketTeam/{id}")
    public CricketTeam getTeamById(@PathVariable int id) throws PlayerManagementException {
        return cricketTeamService.fetchCricketTeamById(id);
    }

    @DeleteMapping(value = "deleteTeam/{id}")
    public void deleteTeam(@PathVariable int id) throws PlayerManagementException {
        cricketTeamService.deleteCricketTeam(id);
    }

    @PutMapping(value = "updateTeam/{id}")
    public String updateTeam(@RequestBody CricketTeam cricketTeam, @PathVariable int id) throws PlayerManagementException {
        return cricketTeamService.updateCricketTeam(cricketTeam, id);
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
