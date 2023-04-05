package com.teksystems.database.dao;

import com.teksystems.database.entity.Player;
import com.teksystems.database.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeamDAO extends JpaRepository<Team, Long> {

    @Query("FROM Team t")
    List<Team> getAllTeams();

    Team findById(Integer id);

    @Query(value = "select p.name, p.team, p.position, p.bye from players p, team_players tp, teams t WHERE p.id = tp.player_id AND :id = tp.team_id ;", nativeQuery = true)
    List<Player> findAllPlayersByTeamId(Integer id);

    Team findByUserId(Integer userId);
}
