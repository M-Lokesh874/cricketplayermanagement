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
import java.util.List;
import java.util.Optional;

@RestController
public class CricketPlayerController {
    @Autowired
    public CricketPlayerService cricketPlayerService;
    @Autowired
    public CricketTeamService cricketTeamService;

    @PostMapping(value = "saveCricketPlayer")
    public ResponseEntity<CricketPlayer> createCricketPlayer(@RequestBody CricketPlayer cricketPlayer)  {
        cricketPlayer = cricketPlayerService.insertCricketPlayer(cricketPlayer);
        if (null != cricketPlayer) {
            return ResponseEntity.of(Optional.of(cricketPlayer));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping(value = "getAllCricketPlayers")
    public ResponseEntity<List<CricketPlayer>> fetchCricketPlayers() {
        try {
            List<CricketPlayer> cricketPlayers = cricketPlayerService.fetchCricketPlayers();
            if (!cricketPlayers.isEmpty()) {
                return ResponseEntity.of(Optional.of(cricketPlayers));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (PlayerManagementException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("getCricketPlayer/{id}")
    public ResponseEntity<?> fetchCricketPlayerById(@PathVariable int id) {
        try {
            CricketPlayer cricketPlayer = cricketPlayerService.fetchCricketPlayerById(id);
            if(null != cricketPlayer) {
                return ResponseEntity.of(Optional.of(cricketPlayer));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cricket Player does not exist with the ID: "+id);
            }
        } catch (PlayerManagementException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping(value = "updateCricketPlayer/{id}")
    public String updateCricketPlayer(@RequestBody CricketPlayer cricketPlayer, @PathVariable int id) throws PlayerManagementException {
        return cricketPlayerService.updateCricketPlayer(cricketPlayer, id);
    }

    @DeleteMapping("deleteCricketPlayer/{id}")
    public ResponseEntity<String> deleteCricketPlayer(@PathVariable int id) {
        try {
            boolean found = cricketPlayerService.deleteCricketPlayer(id);
            if(found) {
                return ResponseEntity.ok().body("deleted successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cricket Player does not exist with the ID: "+id);
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
    @GetMapping(value = "searchCricketPlayers/{name}")
    public ResponseEntity<List<CricketPlayer>> searchCricketPlayers(@PathVariable String name) {
        try {
            List<CricketPlayer> cricketPlayers = cricketPlayerService.searchCricketPlayer(name);
            if (!cricketPlayers.isEmpty()) {
                return ResponseEntity.of(Optional.of(cricketPlayers));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (PlayerManagementException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping(value = "getMultiplePlayers")
    public ResponseEntity<List<CricketPlayer>> getPlayersByMultipleIds(@RequestBody List<Integer> ids) {
        try {
            List<CricketPlayer> cricketPlayers = cricketPlayerService.getMultiplePlayers(ids);
            if (!cricketPlayers.isEmpty()) {
                return ResponseEntity.of(Optional.of(cricketPlayers));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (PlayerManagementException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
