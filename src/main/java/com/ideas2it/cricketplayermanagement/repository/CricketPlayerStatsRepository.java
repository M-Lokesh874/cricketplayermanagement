package com.ideas2it.cricketplayermanagement.repository;

import com.ideas2it.cricketplayermanagement.model.CricketPlayerStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Optional;

public interface CricketPlayerStatsRepository extends JpaRepository<CricketPlayerStats, Integer> {
    @Query(value = "select * from stats where is_deleted = 0 and id=:id", nativeQuery = true)
    public Optional<CricketPlayerStats> findById(int id);
    @Query(value = "select * from stats where is_deleted = '0'", nativeQuery = true)
    public List<CricketPlayerStats> findAll();
}
