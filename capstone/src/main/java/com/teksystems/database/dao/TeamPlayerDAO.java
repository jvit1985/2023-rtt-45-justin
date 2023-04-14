package com.teksystems.database.dao;

import com.teksystems.database.entity.Player;
import com.teksystems.database.entity.TeamPlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface TeamPlayerDAO extends JpaRepository<TeamPlayer, Long> {

    @Query(value = "select p.*, tp.draft_pick_number from players p, team_players tp where p.id = tp.player_id;", nativeQuery = true)
    List<Map<String, Object>> getAllTeamPlayers();

    TeamPlayer findById(Integer id);

    @Query(value = "select p.* from players p, team_players tp WHERE tp.player_id = p.id AND tp.team_id = :id ;", nativeQuery = true)
    List<Map<String,Object>> findAllPlayersByTeamId(Integer id);

    TeamPlayer findByPlayerId(Integer playerId);
}
