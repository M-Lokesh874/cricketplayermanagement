package com.ideas2it.cricketplayermanagement.model;

import com.ideas2it.cricketplayermanagement.util.constant.Gender;
import lombok.*;
import javax.persistence.*;
import java.util.Date;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CricketPlayerDto {
    private int id;
    private String playerCode;
    private String name;
    private String country;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    private String email;
    private List<CricketTeam> cricketTeams;
}
