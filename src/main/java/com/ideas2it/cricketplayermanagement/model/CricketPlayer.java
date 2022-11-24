package com.ideas2it.cricketplayermanagement.model;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import com.ideas2it.cricketplayermanagement.util.constant.Gender;
import org.hibernate.annotations.Where;
import org.hibernate.sql.ast.Clause;

/**
 * <p>
 * CricketPlayer program contains the detail of the cricket players.
 * </p>
 */
@Entity
@Table(name = "players")
@SQLDelete(sql = "UPDATE players SET is_deleted = 1 WHERE id = ?", check = ResultCheckStyle.COUNT)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CricketPlayer extends BaseModel {
	private String playerCode;
	private String name;
	private String country;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	private String email;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "playersandteams")
	@JsonIgnore
	private List<CricketTeam> cricketTeams;
	@Override
	public String toString() {
		return  "\n-------Player details----------"
				+ "\nId          :" + getId()
				+ "\nPlayer code :" + playerCode
				+ "\nName        :" + name
				+ "\nCountry     :" + country
				+ "\nGender      :" + gender
				+ "\nDateOfBirth :" + dateOfBirth
				+ "\nEmail       :" + email
				+"\n-------------------------------";
	}
}