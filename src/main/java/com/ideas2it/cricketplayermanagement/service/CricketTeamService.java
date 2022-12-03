package com.ideas2it.cricketplayermanagement.service;

import com.ideas2it.cricketplayermanagement.model.CricketPlayer;
import com.ideas2it.cricketplayermanagement.model.CricketTeam;
import com.ideas2it.cricketplayermanagement.util.exception.PlayerManagementException;
import org.springframework.http.ResponseEntity;

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

    public CricketTeam insertCricketTeam(CricketTeam cricketTeam) throws PlayerManagementException;
    public List<CricketTeam> fetchCricketTeams() throws PlayerManagementException;
    public String updateCricketTeam(CricketTeam cricketTeam, int id) throws PlayerManagementException;
    public CricketTeam fetchCricketTeamById(int id) throws PlayerManagementException;
    public ResponseEntity<?> deleteCricketTeam(int id) throws PlayerManagementException;

    public String assignCaptain(CricketTeam cricketTeam, CricketPlayer cricketPlayer);

    public String assignWicketKeeper(CricketTeam cricketTeam, CricketPlayer cricketPlayer);
}