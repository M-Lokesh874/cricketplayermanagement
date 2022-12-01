package com.ideas2it.cricketplayermanagement.service.impl;

import com.ideas2it.cricketplayermanagement.model.CricketPlayer;
import com.ideas2it.cricketplayermanagement.model.CricketTeam;
import com.ideas2it.cricketplayermanagement.repository.CricketTeamRepository;
import com.ideas2it.cricketplayermanagement.service.CricketTeamService;
import com.ideas2it.cricketplayermanagement.util.exception.PlayerManagementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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
    public CricketTeam insertCricketTeam(CricketTeam cricketTeam) throws PlayerManagementException {
        cricketTeam = cricketTeamRepository.save(cricketTeam);
        if(null != cricketTeam) {
            return cricketTeam;
        } else {
            throw new PlayerManagementException("Cricket player table does not exit");
        }

    }

    @Override
    public List<CricketTeam> fetchCricketTeams() throws PlayerManagementException {
        List<CricketTeam> cricketTeams = cricketTeamRepository.findAll();
        if(!cricketTeams.isEmpty()) {
            return cricketTeams;
        } else {
            throw new PlayerManagementException("Cricket team does not exist");
        }
    }

    @Override
    public CricketTeam fetchCricketTeamById(int id) throws PlayerManagementException {
        Optional<CricketTeam> cricketTeam = cricketTeamRepository.findById(id);
        if(!cricketTeam.isPresent()) {
            throw new PlayerManagementException("Cricket team does not exist with the ID: "+id);
        } else {
            return cricketTeam.get();
        }
    }

    @Override
    public void deleteCricketTeam(int id) throws PlayerManagementException {
        Optional<CricketTeam> cricketTeam = cricketTeamRepository.findById(id);
        if(!cricketTeam.isPresent()) {
            throw new PlayerManagementException("Cricket team does not exist with the ID: "+id);
        } else {
            cricketTeamRepository.deleteById(id);
        }
    }

    @Override
    public String assignCaptain(CricketTeam cricketTeam, CricketPlayer cricketPlayer) {
        cricketTeam.setCaptain(cricketPlayer);
        cricketTeam = cricketTeamRepository.save(cricketTeam);
        if(null != cricketTeam) {
            return "Captain assigned successfully";
        } else {
            return "Not assigned";
        }
    }

    @Override
    public String assignWicketKeeper(CricketTeam cricketTeam, CricketPlayer cricketPlayer) {
        cricketTeam.setWicketKeeper(cricketPlayer);
        cricketTeam = cricketTeamRepository.save(cricketTeam);
        if(null != cricketTeam) {
            return "WicketKeeper assigned successfully";
        } else {
            return "Not assigned";
        }
    }

    @Override
    public String updateCricketTeam(CricketTeam cricketTeam, int id) throws PlayerManagementException {
        cricketTeam = fetchCricketTeamById(id);
        if(null != cricketTeam) {
            cricketTeam.setCaptain(cricketTeam.getCaptain());
            cricketTeam.setWicketKeeper(cricketTeam.getWicketKeeper());
            cricketTeamRepository.save(cricketTeam);
            return "updated successfully";
        } else {
            throw new PlayerManagementException("server error");
        }
    }
}