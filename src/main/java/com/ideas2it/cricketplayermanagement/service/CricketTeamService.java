package com.ideas2it.cricketplayermanagement.service;

import com.ideas2it.cricketplayermanagement.model.CricketPlayer;
import com.ideas2it.cricketplayermanagement.model.CricketPlayerStats;
import com.ideas2it.cricketplayermanagement.model.CricketTeam;

import java.util.List;

/**
 * <p>
 * The CricketTeamService interface contains only the method declaration of the
 * CricketTeam class.
 * </p>
 *
 * @author Lokesh
 */
public interface CricketTeamService {

    public CricketTeam insertCricketTeam(CricketTeam cricketTeam);
    public List<CricketTeam> fetchCricketTeams();
    public CricketTeam updateCricketTeam(CricketTeam cricketTeam);
    public CricketTeam fetchCricketTeamById(int id);
    public String deleteCricketTeam(int id);

    public CricketTeam assignCaptain(CricketTeam cricketTeam, CricketPlayer cricketPlayer);

    public CricketTeam assignWicketKeeper(CricketTeam cricketTeam, CricketPlayer cricketPlayer);
}