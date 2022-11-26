package com.ideas2it.cricketplayermanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CricketPlayerStatsDto {

    private int id;
    private int noOfMatch;
    private int totalRun;
    private double battingAverage;
    private double strikeRate;
    private int topScore;
    private int noOfBallsFaced;
    private CricketPlayer cricketPlayer;
}
