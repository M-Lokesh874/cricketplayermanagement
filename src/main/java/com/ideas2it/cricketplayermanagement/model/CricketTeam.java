package com.ideas2it.cricketplayermanagement.model;

import java.util.List;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;

@Entity
@Table(name = "teams")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "update teams set is_deleted = 1 where id = ?", check=ResultCheckStyle.COUNT)
public class CricketTeam extends BaseModel {

	private String name;
	@OneToOne
	private CricketPlayer captain;
	@OneToOne
	private CricketPlayer wicketKeeper;
	private int totalMatch;
	private int won;
	private int lost;

	@ManyToMany(mappedBy = "cricketTeams", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<CricketPlayer> cricketPlayers;
	@Override
	public String toString() {
		return "\n---------Cricket Team-----------"
				+ "\nid             :" +getId()
				+ "\nName           :" + name
				+ "\nTotal Match    :" + totalMatch
				+ "\nWon            :" + won
				+ "\nLost           :" + lost
				+ "\nCaptain        :" + captain
				+ "\nWicketKeeper   :" + wicketKeeper
				+"\n-------------------------------";
	}
}
