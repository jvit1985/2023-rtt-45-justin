package com.teksystems.database.dao;

import com.teksystems.database.entity.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PlayerDAOTest {

    @Autowired
    private PlayerDAO playerDAO;

    @Test
    public void getAllUndraftedPlayersTest() {
        playerDAO.getAllUndraftedPlayers();
    }

    @Test
    public void findByIdTest() {
        Player p = playerDAO.findById(1);

        assertEquals(p.getName(), "Jonathan Taylor");
        assertEquals(p.getBye(), 14);
        assertEquals(p.getTeam(), "Indianapolis Colts");
        assertEquals(p.getPosition(), "RB");
    }

    @Test
    @Order(0)
    public void createPlayerTest() {
        Player given = new Player();
        given.setName("Test Given");
        given.setBye(7);
        given.setPosition("TE");
        given.setTeam("Dallas Cowboys");

        playerDAO.save(given);

        Player actual = playerDAO.findByName("Test Given");
        assertEquals(given.getName(), actual.getName());
        assertEquals(given.getBye(), actual.getBye());
        assertEquals(given.getPosition(), actual.getPosition());
        assertEquals(given.getTeam(), actual.getTeam());
    }

    @Test
    @Order(1)
    public void updatePlayerTest() {
        Player given = playerDAO.findByName("Test Given");

        given.setName("Test Update");

        playerDAO.save(given);

        Player actual = playerDAO.findByName("Test Update");
        assertEquals(given.getName(), actual.getName());
    }

    @Test
    @Order(2)
    public void deletePlayerTest() {
        Player given = playerDAO.findByName("Test Update");

        playerDAO.delete(given);

        Player actual = playerDAO.findByName("Test Update");
        Assertions.assertNull(actual);
    }

}
