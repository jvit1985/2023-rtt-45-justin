package com.teksystems.controller;

import com.teksystems.database.dao.TeamDAO;
import com.teksystems.database.dao.UserDAO;
import com.teksystems.database.entity.Team;
import com.teksystems.database.entity.User;
import com.teksystems.formbeans.TeamFormBean;
import com.teksystems.formbeans.UserFormBean;
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

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable Integer id) {
        ModelAndView response = new ModelAndView("user/detail");
        log.debug("In user detail controller method with id = " + id);
        List<User> users = new ArrayList<>();

        response.addObject("users", users);

        log.debug(users + "");
        return response;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Integer id) {
        ModelAndView response = new ModelAndView("user/edit");
        log.debug("In user controller - edit method");

        User user = userDAO.findById(id);
        Team team = teamDAO.findByUserId(user.getId());
        TeamFormBean teamForm = new TeamFormBean();
        UserFormBean userForm = new UserFormBean();

        teamForm.setId(team.getId());
        teamForm.setTeamName(team.getTeamName());
        teamForm.setTeamPicture(team.getTeamPicture());
        teamForm.setUserId(team.getUserId());
        userForm.setEmail(user.getEmail());
        userForm.setPassword(user.getPassword());
        userForm.setFirstName(user.getFirstName());
        userForm.setLastName(user.getLastName());
        userForm.setId(user.getId());

        response.addObject("teamForm", teamForm);
        response.addObject("userForm", userForm);

        return response;
    }

    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView response = new ModelAndView("user/create");
        log.debug("In user create controller method");

        return response;
    }

    @GetMapping("/createSubmit")
    public ModelAndView createSubmit(TeamFormBean teamForm, UserFormBean userForm) {
        ModelAndView response = new ModelAndView("user/create");
        log.debug("In user createSubmit controller method");
        log.debug(teamForm.toString());
        log.debug(userForm.toString());

        Team team = new Team();
        User user = new User();

        if (teamForm.getId() != null && teamForm.getId() > 0) {
            team = teamDAO.findById(teamForm.getId());
        }

        if (userForm.getId() != null && userForm.getId() > 0) {
            user = userDAO.findById(userForm.getId());
        }

        team.setTeamName(teamForm.getTeamName());
        team.setTeamPicture(teamForm.getTeamPicture());
        team.setUserId(team.getUserId());
        team.setId(teamForm.getId());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setFirstName(userForm.getFirstName());
        user.setLastName(userForm.getLastName());
        user.setId(userForm.getId());

        teamDAO.save(team);
        userDAO.save(user);
        response.addObject("teamForm", teamForm);
        response.addObject("userForm", userForm);

        return response;
    }

}
