package com.ideas2it.cricketplayermanagement.service.impl;

import com.ideas2it.cricketplayermanagement.model.CricketPlayer;
import com.ideas2it.cricketplayermanagement.model.CricketPlayerStats;
import com.ideas2it.cricketplayermanagement.repository.CricketPlayerStatsRepository;
import com.ideas2it.cricketplayermanagement.service.CricketPlayerStatsService;
import com.ideas2it.cricketplayermanagement.util.exception.PlayerManagementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 * The CricketPlayerStatsServiceImpl contains all method definitions of the
 * cricketPlayerStats service class.
 * </p>
 *
 * @author Lokesh
 */
@Service
public class CricketPlayerStatsServiceImpl implements CricketPlayerStatsService {
    @Autowired
    CricketPlayerStatsRepository cricketPlayerStatsRepository;
    @Override
    public CricketPlayerStats insertCricketPlayerStats(CricketPlayerStats cricketPlayerStats) {
        return cricketPlayerStatsRepository.save(cricketPlayerStats);
    }
    @Override
    public List<CricketPlayerStats> fetchCricketPlayerStats() throws PlayerManagementException {
        List<CricketPlayerStats> cricketPlayerStats = cricketPlayerStatsRepository.findAll();
        if(!cricketPlayerStats.isEmpty()) {
            return cricketPlayerStats;
        } else {
            throw new PlayerManagementException(" Cricketplayer stats does not exist ");
        }
    }
    @Override
    public String updateCricketPlayerStats(CricketPlayerStats cricketPlayerStats, int id) throws PlayerManagementException {
        cricketPlayerStats = fetchCricketPlayerStatsById(id);
        if(null != cricketPlayerStats) {
            cricketPlayerStats.setCricketPlayer(cricketPlayerStats.getCricketPlayer());
            cricketPlayerStatsRepository.save(cricketPlayerStats);
            return "updated successfully";
        } else {
            return "oops....!";
        }

    }
    @Override
    public CricketPlayerStats fetchCricketPlayerStatsById(int id) throws PlayerManagementException {
        Optional<CricketPlayerStats> cricketPlayerStats = cricketPlayerStatsRepository.findById(id);
        if(!cricketPlayerStats.isPresent()) {
            throw new PlayerManagementException("Cricketplayer stats does not exist with the ID: "+id);
        } else {
            return cricketPlayerStats.get();
        }
    }
    @Override
    public void deleteCricketPlayerStats(int id) throws PlayerManagementException {
        Optional<CricketPlayerStats> cricketPlayerStats = cricketPlayerStatsRepository.findById(id);
        if(!cricketPlayerStats.isPresent()) {
            throw new PlayerManagementException("Cricketplayer stats does not exist with the ID: "+id);
        } else {
            cricketPlayerStatsRepository.deleteById(id);
        }
    }
    @Override
    public String assignPlayer(CricketPlayerStats cricketPlayerStats, CricketPlayer cricketPlayer) {
        cricketPlayerStats.setCricketPlayer(cricketPlayer);
        insertCricketPlayerStats(cricketPlayerStats);
        if(null != cricketPlayerStats) {
            return "player assigned successfully";
        } else {
            return "oops...!";
        }

    }
}
