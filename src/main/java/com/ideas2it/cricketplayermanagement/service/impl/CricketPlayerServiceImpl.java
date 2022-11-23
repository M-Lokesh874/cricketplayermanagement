package com.ideas2it.cricketplayermanagement.service.impl;

import com.ideas2it.cricketplayermanagement.model.CricketPlayer;
import com.ideas2it.cricketplayermanagement.model.CricketTeam;
import com.ideas2it.cricketplayermanagement.repository.CricketPlayerRepository;
import com.ideas2it.cricketplayermanagement.service.CricketPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * The CricketPlayerServiceImpl contains all method definitions of the cricket
 * player service class.
 * </p>
 *
 * @author Lokesh
 */

@Service
public class CricketPlayerServiceImpl implements CricketPlayerService {
    @Autowired
    public CricketPlayerRepository cricketPlayerRepository;
    @Override
    public CricketPlayer insertCricketPlayer(CricketPlayer cricketPlayer) {
        return cricketPlayerRepository.save(cricketPlayer);
    }
    @Override
    public List<CricketPlayer> fetchCricketPlayers() {
        return cricketPlayerRepository.findAll();
    }
    @Override
    public CricketPlayer fetchCricketPlayerById(int id) {
        return cricketPlayerRepository.findById(id).get();
    }
    @Override
    public String deleteCricketPlayer(int id) {
        CricketPlayer cricketPlayer = cricketPlayerRepository.findById(id).get();
        cricketPlayerRepository.delete(cricketPlayer);
        return "Id : "+ id +" Deleted successfully";
    }

    @Override
    public CricketPlayer assignTeam(List<CricketTeam> cricketTeams, CricketPlayer cricketPlayer) {
        cricketPlayer.setCricketTeams(cricketTeams);
        insertCricketPlayer(cricketPlayer);
        return cricketPlayer;
    }

    @Override
    public CricketPlayer updateCricketPlayer(CricketPlayer cricketPlayer) {
        return cricketPlayerRepository.save(cricketPlayer);
    }
}