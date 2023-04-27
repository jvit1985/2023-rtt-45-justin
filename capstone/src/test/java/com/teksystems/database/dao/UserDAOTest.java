package com.teksystems.database.dao;

import com.teksystems.database.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserDAOTest {

    @Autowired
    private UserDAO userDAO;

    @Test
    public void findByEmailTest() {
        User u = userDAO.findByEmail("test@a.com");

        assertEquals(u.getFirstName(), "Justin");
        assertEquals(u.getLastName(), "V");
        assertEquals(u.getId(), 10);
    }
}
