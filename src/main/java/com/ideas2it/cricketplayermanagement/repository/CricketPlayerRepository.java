package com.ideas2it.cricketplayermanagement.repository;

import com.ideas2it.cricketplayermanagement.model.CricketPlayer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CricketPlayerRepository extends JpaRepository<CricketPlayer, Integer> {
}
