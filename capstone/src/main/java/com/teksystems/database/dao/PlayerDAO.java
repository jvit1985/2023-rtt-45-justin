package com.teksystems.database.dao;

import com.teksystems.database.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlayerDAO extends JpaRepository<Player, Long> {

    @Query(value = "select p.* from players p left join team_players tp on tp.player_id = p.id where tp.id is null; ", nativeQuery = true)
    List<Player> getAllUndraftedPlayers();

    Player findById(Integer id);

    List<Player> findByNameContainingIgnoreCase(String name);

    Player findByName(String name);

}
