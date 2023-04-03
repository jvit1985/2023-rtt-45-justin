package com.teksystems.controller;

import com.teksystems.database.dao.UserDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping ( value = "/user")
public class UserController {

    @Autowired
    private UserDAO userDAO;
}
