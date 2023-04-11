package com.teksystems.controller;

import com.teksystems.database.dao.TeamDAO;
import com.teksystems.database.dao.UserDAO;
import com.teksystems.database.entity.Team;
import com.teksystems.database.entity.User;
import com.teksystems.formbeans.TeamFormBean;
import com.teksystems.formbeans.CreateUserFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping ( value = "/user")
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private TeamDAO teamDAO;

//    @GetMapping("/detail/{id}")
//    public ModelAndView detail(@PathVariable Integer id) {
//        ModelAndView response = new ModelAndView("user/detail");
//        log.debug("In user detail controller method with id = " + id);
//        List<User> users = new ArrayList<>();
//
//        response.addObject("users", users);
//
//        log.debug(users + "");
//        return response;
//    }
//
//    @GetMapping("/edit/{id}")
//    public ModelAndView edit(@PathVariable Integer id) {
//        ModelAndView response = new ModelAndView("user/edit");
//        log.debug("In user controller - edit method");
//
//        User user = userDAO.findById(id);
//        Team team = teamDAO.findByUserId(user.getId());
//        TeamFormBean teamForm = new TeamFormBean();
//        CreateUserFormBean userForm = new CreateUserFormBean();
//
//        teamForm.setId(team.getId());
//        teamForm.setTeamName(team.getTeamName());
//        teamForm.setTeamPicture(team.getTeamPicture());
//        userForm.setEmail(user.getEmail());
//        userForm.setPassword(user.getPassword());
//        userForm.setFirstName(user.getFirstName());
//        userForm.setLastName(user.getLastName());
//
//
//        response.addObject("teamForm", teamForm);
//        response.addObject("userForm", userForm);
//
//        return response;
//    }


}
