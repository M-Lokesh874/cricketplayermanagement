package com.ideas2it.cricketplayermanagement.service;

import com.ideas2it.cricketplayermanagement.model.CricketPlayer;
import com.ideas2it.cricketplayermanagement.model.CricketTeam;

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
	public CricketPlayer fetchCricketPlayerById(int id);
	public String deleteCricketPlayer(int id);
	CricketPlayer assignTeam(List<CricketTeam > cricketTeams, CricketPlayer cricketPlayer);

}