package com.ideas2it.cricketplayermanagement.controller;

import com.ideas2it.cricketplayermanagement.model.CricketPlayer;
import com.ideas2it.cricketplayermanagement.model.CricketTeam;
import com.ideas2it.cricketplayermanagement.service.CricketPlayerService;
import com.ideas2it.cricketplayermanagement.service.CricketTeamService;
import com.ideas2it.cricketplayermanagement.util.exception.PlayerManagementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<CricketPlayer> fetchCricketPlayerById(@PathVariable int id) {
        try {
            CricketPlayer cricketPlayer = cricketPlayerService.fetchCricketPlayerById(id);
            if(null != cricketPlayer){
                return ResponseEntity.of(Optional.of(cricketPlayer));
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (PlayerManagementException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping(value = "updateCricketPlayer")
    public CricketPlayer updateCricketPlayer(@RequestBody CricketPlayer cricketPlayer) {
        System.out.println("update works properly");
        return cricketPlayerService.updateCricketPlayer(cricketPlayer);
    }

    @DeleteMapping("deleteCricketPlayer/{id}")
    public ResponseEntity<CricketPlayer> deleteCricketPlayer(@PathVariable int id) {
        try {
            boolean flag = cricketPlayerService.deleteCricketPlayer(id);
            if(flag) {

                //return cricketPlayerService.deleteCricketPlayer(id);
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (PlayerManagementException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PutMapping (value = "assignTeam/{playerId}/{teamId}")
    public String assignTeam(@PathVariable int playerId, @PathVariable int teamId) throws PlayerManagementException {
            CricketPlayer cricketPlayer = cricketPlayerService.fetchCricketPlayerById(playerId);
            CricketTeam cricketTeam = cricketTeamService.fetchCricketTeamById(teamId);
            List<CricketTeam> cricketTeams = cricketPlayer.getCricketTeams();
            cricketTeams.add(cricketTeam);
            return cricketPlayerService.assignTeam(cricketTeams, cricketPlayer);
    }
}
