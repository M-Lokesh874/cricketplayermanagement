package com.ideas2it.cricketplayermanagement.service;

import com.ideas2it.cricketplayermanagement.model.CricketPlayer;
import com.ideas2it.cricketplayermanagement.model.CricketPlayerStats;
import com.ideas2it.cricketplayermanagement.model.CricketTeam;
import com.ideas2it.cricketplayermanagement.util.exception.PlayerManagementException;

import java.util.List;

/**
 * <p>
 * The CricketPlayerStatsService interface contains only the method declaration
 * of the CricketPlayerstats class.
 * </p>
 *
 * @author Lokesh
 */
public interface CricketPlayerStatsService {

    public CricketPlayerStats insertCricketPlayerStats(CricketPlayerStats cricketPlayerStats);
    public List<CricketPlayerStats> fetchCricketPlayerStats();
    public CricketPlayerStats updateCricketPlayerStats(CricketPlayerStats cricketPlayerStats);
    public CricketPlayerStats fetchCricketPlayerStatsById(int id) throws PlayerManagementException;
    public String deleteCricketPlayerStats(int id) throws PlayerManagementException;
    public CricketPlayerStats assignPlayer(CricketPlayerStats cricketPlayerStats, CricketPlayer cricketPlayer);
}