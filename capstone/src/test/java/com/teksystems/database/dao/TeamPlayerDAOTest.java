package com.teksystems.database.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TeamPlayerDAOTest {

    @Autowired
    private TeamPlayerDAO teamPlayerDAO;

    @Test
    public void getAllTeamPlayersTest() {
        teamPlayerDAO.getAllTeamPlayers();
    }

    @Test
    public void findAllPlayersByTeamIdTest() {
        teamPlayerDAO.findAllPlayersByTeamId(1);
    }

    @Test
    public void findAllPlayersforAllTeamsTest() {
        teamPlayerDAO.findAllPlayersForAllTeams();
    }
}
