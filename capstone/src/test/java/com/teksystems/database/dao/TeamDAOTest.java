package com.teksystems.database.dao;

import com.teksystems.database.entity.Team;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TeamDAOTest {

    @Autowired
    private TeamDAO teamDAO;

    @Test
    public void getAllTeamsTest() {
        teamDAO.getAllTeams();
    }

    @Test
    public void getByTeamIdTest() {
        Team t = teamDAO.findById(1);

        assertEquals(t.getTeamName(), "Justin");
        assertEquals(t.getTeamPicture(), "../../../pub/images/profileImage.png");
    }
}
