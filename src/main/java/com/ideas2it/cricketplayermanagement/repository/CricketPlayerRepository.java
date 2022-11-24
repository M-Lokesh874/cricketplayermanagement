package com.ideas2it.cricketplayermanagement.repository;

import com.ideas2it.cricketplayermanagement.model.CricketPlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface CricketPlayerRepository extends JpaRepository<CricketPlayer, Integer> {
    public void deleteById(int id);
    @Query(value="select * from players where is_deleted='0' and id=:id", nativeQuery = true)
    public CricketPlayer fetchById(int id);

    @Query(value="select * from players where name=:name and is_deleted ='0'", nativeQuery = true)
    public List<CricketPlayer> findByName(String name);

    @Query(value = "select * from players where is_deleted = '0' ", nativeQuery = true)
    public List<CricketPlayer> findAll();

}
