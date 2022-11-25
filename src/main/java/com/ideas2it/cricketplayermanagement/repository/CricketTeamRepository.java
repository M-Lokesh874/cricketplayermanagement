package com.ideas2it.cricketplayermanagement.repository;

import com.ideas2it.cricketplayermanagement.model.CricketTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Optional;

public interface CricketTeamRepository extends JpaRepository<CricketTeam, Integer>{

    @Query(value = "select * from teams where is_deleted = 0 and id=:id", nativeQuery = true)
    public Optional<CricketTeam> findById(int id);
    @Query(value = "select * from teams where is_deleted = '0'", nativeQuery = true)
    public List<CricketTeam> findAll();
}
