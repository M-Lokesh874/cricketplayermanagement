package com.ideas2it.cricketplayermanagement.service.impl;

import com.ideas2it.cricketplayermanagement.model.CricketPlayer;
import com.ideas2it.cricketplayermanagement.model.CricketTeam;
import com.ideas2it.cricketplayermanagement.repository.CricketPlayerRepository;
import com.ideas2it.cricketplayermanagement.service.CricketPlayerService;
import com.ideas2it.cricketplayermanagement.util.exception.PlayerManagementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
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
    public CricketPlayer insertCricketPlayer(CricketPlayer cricketPlayer) throws Exception {
        long id = getCount();
        cricketPlayer.setPlayerCode("CRIC" + ++id);
        return cricketPlayerRepository.save(cricketPlayer);
    }
    @Override
    public List<CricketPlayer> fetchCricketPlayers() throws PlayerManagementException {
        return cricketPlayerRepository.findAll();
    }
    @Override
    public CricketPlayer fetchCricketPlayerById(int id) throws PlayerManagementException {
        return cricketPlayerRepository.findById(id);
    }
    @Override
    public boolean deleteCricketPlayer(int id) throws PlayerManagementException {
        CricketPlayer cricketPlayer = cricketPlayerRepository.findById(id);
        if(null == cricketPlayer) {
            return false;
        } else {
            cricketPlayerRepository.delete(cricketPlayer);
            return true;
        }
    }

    @Override
    public String assignTeam(List<CricketTeam> cricketTeams, CricketPlayer cricketPlayer) {
        cricketPlayer.setCricketTeams(cricketTeams);
        cricketPlayer = cricketPlayerRepository.save(cricketPlayer);
        if(cricketPlayer != null) {
            return "Team assigned successfully";
        } else {
            return "Oops.....!";
        }
    }

    @Override
    public String updateCricketPlayer(CricketPlayer cricketPlayer, int id) throws PlayerManagementException {
        cricketPlayer = fetchCricketPlayerById(id);
        if(null != cricketPlayer) {
            cricketPlayer.setCricketTeams(cricketPlayer.getCricketTeams());
            cricketPlayer = cricketPlayerRepository.save(cricketPlayer);

            return "updated successfully";
        } else {
            return "Oops....!";
        }

    }
    @Override
    public List<CricketPlayer> searchCricketPlayer(String name) throws PlayerManagementException {
        return cricketPlayerRepository.findByName(name);
    }

    @Override
    public List<CricketPlayer> getMultiplePlayers(List<Integer> ids) throws PlayerManagementException {
        return cricketPlayerRepository.findByIdIn(ids);
    }
    public long getCount() {
        return cricketPlayerRepository.count();
    }
}