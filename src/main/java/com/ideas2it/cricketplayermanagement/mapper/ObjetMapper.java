package com.ideas2it.cricketplayermanagement.mapper;

import com.ideas2it.cricketplayermanagement.model.*;
import com.ideas2it.cricketplayermanagement.util.exception.PlayerManagementException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class ObjetMapper {
    @Autowired
    public ModelMapper modelMapper;
    public List<CricketPlayerDto> convertPlayerEntityIntoDto(List<CricketPlayer> cricketPlayers) throws PlayerManagementException {
        List<CricketPlayerDto> cricketPlayersDtos = new ArrayList<>();
        CricketPlayerDto cricketPlayerDto;
        for(CricketPlayer cricketPlayer: cricketPlayers) {
            cricketPlayerDto = modelMapper.map(cricketPlayer, CricketPlayerDto.class);
            cricketPlayerDto.setId(cricketPlayerDto.getId());
            cricketPlayersDtos.add(cricketPlayerDto);
        }
        return cricketPlayersDtos;
    }
    public CricketPlayerDto convertPlayerEntityIntoDto(CricketPlayer cricketPlayer) {
        CricketPlayerDto cricketPlayerDto;
        cricketPlayerDto = modelMapper.map(cricketPlayer, CricketPlayerDto.class);
        return cricketPlayerDto;
    }

    public List<CricketPlayerStatsDto> convertStatsEntityIntoDto(List<CricketPlayerStats> cricketPlayersStats) throws PlayerManagementException {
        List<CricketPlayerStatsDto> cricketPlayerStatsDtos = new ArrayList<>();
        CricketPlayerStatsDto cricketPlayerStatsDto;
        for(CricketPlayerStats stats: cricketPlayersStats) {
            cricketPlayerStatsDto = modelMapper.map(stats, CricketPlayerStatsDto.class);
            cricketPlayerStatsDto.setId(cricketPlayerStatsDto.getId());
            cricketPlayerStatsDtos.add(cricketPlayerStatsDto);
        }
        return cricketPlayerStatsDtos;
    }
    public CricketPlayerStatsDto convertStatsEntityIntoDto(CricketPlayerStats cricketPlayerStats) {
        CricketPlayerStatsDto cricketPlayerStatsDto;
        cricketPlayerStatsDto = modelMapper.map(cricketPlayerStats, CricketPlayerStatsDto.class);
        return cricketPlayerStatsDto;
    }

    public List<CricketTeamDto> convertTeamEntityIntoDto(List<CricketTeam> cricketTeams) throws PlayerManagementException {
        List<CricketTeamDto> cricketTeamsDtos = new ArrayList<>();
        CricketTeamDto cricketTeamDto;
        for(CricketTeam cricketTeam: cricketTeams) {
            cricketTeamDto = modelMapper.map(cricketTeam, CricketTeamDto.class);
            cricketTeamDto.setId(cricketTeamDto.getId());
            cricketTeamsDtos.add(cricketTeamDto);
        }
        return cricketTeamsDtos;
    }

    public CricketTeamDto convertTeamEntityIntoDto(CricketTeam cricketTeam) {
        CricketTeamDto cricketTeamDto;
        cricketTeamDto = modelMapper.map(cricketTeam, CricketTeamDto.class);
        return cricketTeamDto;
    }
}
