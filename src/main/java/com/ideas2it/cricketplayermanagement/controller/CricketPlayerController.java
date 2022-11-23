package com.ideas2it.cricketplayermanagement.controller;

import com.ideas2it.cricketplayermanagement.model.CricketPlayer;
import com.ideas2it.cricketplayermanagement.model.CricketTeam;
import com.ideas2it.cricketplayermanagement.service.CricketPlayerService;
import com.ideas2it.cricketplayermanagement.service.CricketTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;
import java.util.List;

@RestController
public class CricketPlayerController {
    @Autowired
    public CricketPlayerService cricketPlayerService;
    @Autowired
    public CricketTeamService cricketTeamService;

    @PostMapping(value = "saveCricketPlayer")
    public CricketPlayer createCricketPlayer(@RequestBody CricketPlayer cricketPlayer) throws ParseException {
        System.out.println("player save works properly");
        return cricketPlayerService.insertCricketPlayer(cricketPlayer);
    }

    @GetMapping(value = "getAllCricketPlayers")
    public List<CricketPlayer> fetchCricketPlayers() {
        System.out.println("loaded successfully");
        return cricketPlayerService.fetchCricketPlayers();
    }

    @GetMapping("getCricketPlayer/{id}")
    public CricketPlayer fetchCricketPlayerById(@PathVariable int id) {
        System.out.println("get works properly");
        return cricketPlayerService.fetchCricketPlayerById(id);
    }

    @PutMapping(value = "updateCricketPlayer")
    public CricketPlayer updateCricketPlayer(@RequestBody CricketPlayer cricketPlayer) {
        System.out.println("update works properly");
        return cricketPlayerService.updateCricketPlayer(cricketPlayer);
    }

    @DeleteMapping("deleteCricketPlayer/{id}")
    public String deleteCricketPlayer(@PathVariable int id) {
        System.out.println("Deleted successfully");
        return cricketPlayerService.deleteCricketPlayer(id);
    }

    @PutMapping (value = "assignTeam/{playerId}/{teamId}")
    public CricketPlayer getPlayerForTeam(@PathVariable int playerId, @PathVariable int teamId) {
        CricketPlayer cricketPlayer = cricketPlayerService.fetchCricketPlayerById(playerId);
        CricketTeam cricketTeam = cricketTeamService.fetchCricketTeamById(teamId);
        List<CricketTeam> cricketTeams = cricketPlayer.getCricketTeams();
        cricketTeams.add(cricketTeam);
        return cricketPlayerService.assignTeam(cricketTeams,cricketPlayer);
    }
}
