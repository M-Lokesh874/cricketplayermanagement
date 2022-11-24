package com.ideas2it.cricketplayermanagement.service.impl;

import com.ideas2it.cricketplayermanagement.model.CricketPlayer;
import com.ideas2it.cricketplayermanagement.model.CricketTeam;
import com.ideas2it.cricketplayermanagement.repository.CricketTeamRepository;
import com.ideas2it.cricketplayermanagement.service.CricketTeamService;
import com.ideas2it.cricketplayermanagement.util.exception.PlayerManagementException;
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
    public CricketTeam fetchCricketTeamById(int id) throws PlayerManagementException {
        CricketTeam cricketTeam = cricketTeamRepository.findById(id)
                .orElseThrow(() -> new PlayerManagementException(id + " team not found"));
        return cricketTeam;
    }

    @Override
    public String deleteCricketTeam(int id) throws PlayerManagementException {
        CricketTeam cricketTeam = cricketTeamRepository.findById(id)
                .orElseThrow(() -> new PlayerManagementException(id + " Record not found "));
        cricketTeamRepository.delete(cricketTeam);
        return "Id : "+ id +" Deleted successfully";
    }

    @Override
    public String assignCaptain(CricketTeam cricketTeam, CricketPlayer cricketPlayer) {
        cricketTeam.setCaptain(cricketPlayer);
        CricketTeam cricketTeam1 = cricketTeamRepository.save(cricketTeam);
        if(null != cricketTeam1) {
            return "Captain assigned successfully";
        } else {
            return "Not assigned";
        }
    }

    @Override
    public String assignWicketKeeper(CricketTeam cricketTeam, CricketPlayer cricketPlayer) {
        cricketTeam.setWicketKeeper(cricketPlayer);
        CricketTeam cricketTeam1 = cricketTeamRepository.save(cricketTeam);
        if(null != cricketTeam1) {
            return "WicketKeeper assigned successfully";
        } else {
            return "Not assigned";
        }
    }

    @Override
    public CricketTeam updateCricketTeam(CricketTeam cricketTeam) {
        return cricketTeamRepository.save(cricketTeam);
    }
}