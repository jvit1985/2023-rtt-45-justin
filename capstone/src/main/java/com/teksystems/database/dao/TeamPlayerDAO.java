package com.teksystems.database.dao;

import com.teksystems.database.entity.TeamPlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface TeamPlayerDAO extends JpaRepository<TeamPlayer, Long> {

    @Query(value = "select p.*, tp.draft_pick_number from players p, team_players tp where p.id = tp.player_id;", nativeQuery = true)
    List<Map<String, Object>> getAllTeamPlayers();

    TeamPlayer findByDraftPickNumber(Integer id);

    @Query(value = "select p.* from players p, team_players tp WHERE tp.player_id = p.id AND tp.team_id = :id ;", nativeQuery = true)
    List<Map<String, Object>> findAllPlayersByTeamId(Integer id);

    TeamPlayer findByTeamId(Integer teamId);

    @Query(value = "select p.*, t.team_name, tp.team_id from players p, teams t, team_players tp where tp.player_id = p.id AND tp.team_id = t.id order by t.id ;", nativeQuery = true)
    List<Map<String, Object>> findAllPlayersForAllTeams();
}
