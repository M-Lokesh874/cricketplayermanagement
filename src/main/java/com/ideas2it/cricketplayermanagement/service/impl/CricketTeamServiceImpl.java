package com.ideas2it.cricketplayermanagement.service.impl;

import com.ideas2it.cricketplayermanagement.model.CricketPlayer;
import com.ideas2it.cricketplayermanagement.model.CricketTeam;
import com.ideas2it.cricketplayermanagement.repository.CricketTeamRepository;
import com.ideas2it.cricketplayermanagement.service.CricketTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * <p>
 * The CricketTeamServiceImpl contains all method definitions of the cricketTeam
 * service class.
 * </p>
 *
 * @author Lokesh
 */
@Service
public class CricketTeamServiceImpl implements CricketTeamService {

    @Autowired
    CricketTeamRepository cricketTeamRepository;

    @Override
    public CricketTeam insertCricketTeam(CricketTeam cricketTeam) {
        return cricketTeamRepository.save(cricketTeam);
    }

    @Override
    public List<CricketTeam> fetchCricketTeams() {
        return cricketTeamRepository.findAll();
    }

    @Override
    public CricketTeam fetchCricketTeamById(int id) {
        return cricketTeamRepository.findById(id).get();
    }

    @Override
    public String deleteCricketTeam(int id) {
        CricketTeam cricketTeam = cricketTeamRepository.findById(id).get();
        cricketTeamRepository.deleteById(id);
        return "Id : "+ id +" Deleted successfully";
    }

    @Override
    public CricketTeam assignCaptain(CricketTeam cricketTeam, CricketPlayer cricketPlayer) {
        cricketTeam.setCaptain(cricketPlayer);
        insertCricketTeam(cricketTeam);
        return cricketTeam;
    }

    @Override
    public CricketTeam assignWicketKeeper(CricketTeam cricketTeam, CricketPlayer cricketPlayer) {
        cricketTeam.setWicketKeeper(cricketPlayer);
        insertCricketTeam(cricketTeam);
        return cricketTeam;
    }

    @Override
    public CricketTeam updateCricketTeam(CricketTeam cricketTeam) {
        return cricketTeamRepository.save(cricketTeam);
    }
}