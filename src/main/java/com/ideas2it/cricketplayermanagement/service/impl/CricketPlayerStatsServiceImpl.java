package com.ideas2it.cricketplayermanagement.service.impl;

import com.ideas2it.cricketplayermanagement.model.CricketPlayer;
import com.ideas2it.cricketplayermanagement.model.CricketPlayerStats;
import com.ideas2it.cricketplayermanagement.repository.CricketPlayerStatsRepository;
import com.ideas2it.cricketplayermanagement.service.CricketPlayerStatsService;
import com.ideas2it.cricketplayermanagement.util.exception.PlayerManagementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

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
    public List<CricketPlayerStats> fetchCricketPlayerStats() {
        return cricketPlayerStatsRepository.findAll();
    }
    @Override
    public CricketPlayerStats updateCricketPlayerStats(CricketPlayerStats cricketPlayerStats) {
        return cricketPlayerStatsRepository.save(cricketPlayerStats);
    }
    @Override
    public CricketPlayerStats fetchCricketPlayerStatsById(int id) throws PlayerManagementException {
        CricketPlayerStats cricketPlayerStats = cricketPlayerStatsRepository.findById(id)
                .orElseThrow(() -> new PlayerManagementException(id + " Player stats not found "));
        return cricketPlayerStats;
    }
    @Override
    public String deleteCricketPlayerStats(int id) throws PlayerManagementException {
        CricketPlayerStats cricketPlayerStats = cricketPlayerStatsRepository.findById(id)
                .orElseThrow( ()-> new PlayerManagementException(id + " Record not found "));
        cricketPlayerStatsRepository.delete(cricketPlayerStats);
        return "Id : "+ id +" Deleted successfully";
    }
    @Override
    public CricketPlayerStats assignPlayer(CricketPlayerStats cricketPlayerStats, CricketPlayer cricketPlayer) {
        cricketPlayerStats.setCricketPlayer(cricketPlayer);
        insertCricketPlayerStats(cricketPlayerStats);
        return cricketPlayerStats;
    }
}
