package com.ideas2it.cricketplayermanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CricketTeamDto {
    private int id;
    private String name;
    private CricketPlayer captain;
    private CricketPlayer wicketKeeper;
    private int totalMatch;
    private int won;
    private int lost;
    private List<CricketPlayer> cricketPlayers;
}
