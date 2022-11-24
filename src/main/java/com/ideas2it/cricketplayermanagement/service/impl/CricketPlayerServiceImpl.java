package com.ideas2it.cricketplayermanagement.service.impl;

import com.ideas2it.cricketplayermanagement.model.CricketPlayer;
import com.ideas2it.cricketplayermanagement.model.CricketTeam;
import com.ideas2it.cricketplayermanagement.repository.CricketPlayerRepository;
import com.ideas2it.cricketplayermanagement.service.CricketPlayerService;
import com.ideas2it.cricketplayermanagement.util.exception.PlayerManagementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public CricketPlayer fetchCricketPlayerById(int id) throws PlayerManagementException {
        return cricketPlayerRepository.fetchById(id);
    }
    @Override
    public boolean deleteCricketPlayer(int id) throws PlayerManagementException {
        try{
            CricketPlayer cricketPlayer = cricketPlayerRepository.fetchById(id);
            if(null == cricketPlayer) {
                return false;
            } else {
                cricketPlayerRepository.delete(cricketPlayer);
                return true;
            }
        }catch(Exception exception) {
            throw new PlayerManagementException(exception.getMessage());
        }

    }

    @Override
    public String assignTeam(List<CricketTeam> cricketTeams, CricketPlayer cricketPlayer) {
        cricketPlayer.setCricketTeams(cricketTeams);
        CricketPlayer cricketPlayer1 = cricketPlayerRepository.save(cricketPlayer);
        if(cricketPlayer1 != null) {
            return "Team assigned successfully";
        } else {
            return "Oops.....!";
        }
    }

    @Override
    public CricketPlayer updateCricketPlayer(CricketPlayer cricketPlayer) {
        return cricketPlayerRepository.save(cricketPlayer);
    }
}