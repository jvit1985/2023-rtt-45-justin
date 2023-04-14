package com.teksystems.database.dao;

import com.teksystems.database.entity.Player;
import com.teksystems.database.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlayerDAO extends JpaRepository<Player, Long> {


    @Query("FROM Player p")
    List<Player> getAllPlayers();

    Player findById(Integer id);

    List<Player> findByNameContainingIgnoreCase(String name);
}
