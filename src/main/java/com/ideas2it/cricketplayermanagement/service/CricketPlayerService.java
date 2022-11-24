package com.ideas2it.cricketplayermanagement.service;

import com.ideas2it.cricketplayermanagement.model.CricketPlayer;
import com.ideas2it.cricketplayermanagement.model.CricketTeam;
import com.ideas2it.cricketplayermanagement.util.exception.PlayerManagementException;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * <p>
 * The CricketPlayerService interface contains only the method declaration of
 * the cricket player.
 * </p>
 *
 * @author Lokesh
 */

public interface CricketPlayerService {

	public CricketPlayer insertCricketPlayer(CricketPlayer cricketPlayer);
	public List<CricketPlayer> fetchCricketPlayers();
	public CricketPlayer updateCricketPlayer(CricketPlayer cricketPlayer);
	public CricketPlayer fetchCricketPlayerById(int id) throws PlayerManagementException;
	public boolean deleteCricketPlayer(int id) throws PlayerManagementException;
	public String assignTeam(List<CricketTeam > cricketTeams, CricketPlayer cricketPlayer);

}