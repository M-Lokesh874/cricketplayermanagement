package com.ideas2it.cricketplayermanagement.repository;

import com.ideas2it.cricketplayermanagement.model.CricketPlayerStats;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CricketPlayerStatsRepository extends JpaRepository<CricketPlayerStats, Integer> {
}
