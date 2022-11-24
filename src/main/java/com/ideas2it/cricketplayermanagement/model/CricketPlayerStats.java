package com.ideas2it.cricketplayermanagement.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
@Entity
@Table(name = "stats")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "update stats set is_deleted = 1 where id = ?", check=ResultCheckStyle.COUNT)
public class CricketPlayerStats extends BaseModel {

	private int noOfMatch;
	private int totalRun;
	private double battingAverage;
	private double strikeRate;
	private int topScore;
	private int noOfBallsFaced;
	@OneToOne//(cascade = CascadeType.ALL)
	@JoinColumn(name = "player_id")
	private CricketPlayer cricketPlayer;
	@Override
	public String toString() {
		return  "\n-------------Player stats------------"
				+ "\nid               :"+ getId()
				+ " \nNoOfMatch       :"+ noOfMatch
				+ " \nTotalRuns       :"+ totalRun
				+ " \nTopScore        :"+ topScore
				+ " \nNoOfBallsFaced  :"+ noOfBallsFaced
				+ " \nDelete          :"+ isDeleted()
				+ " \nUpdated         :"+ getUpdatedAt()
				+ " \nCreated         :"+ getCreatedAt()
				+ " \nCricketPlayer  :"+ cricketPlayer
				+ "\n-----------------------------------";
	}
}
