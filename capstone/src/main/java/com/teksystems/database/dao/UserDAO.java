package com.teksystems.database.dao;

import com.teksystems.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserDAO extends JpaRepository<User, Long> {

    User findById(Integer id);

    User findByEmail(String email);

//    @Query("FROM User u");
//    List<User> getAllUsers();
}
