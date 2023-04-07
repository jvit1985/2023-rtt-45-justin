package com.teksystems.controller;

import com.teksystems.database.dao.PlayerDAO;
import com.teksystems.database.dao.TeamDAO;
import com.teksystems.database.dao.TeamPlayerDAO;
import com.teksystems.database.dao.UserDAO;
import com.teksystems.database.entity.Player;
import com.teksystems.database.entity.Team;
import com.teksystems.database.entity.User;
import com.teksystems.formbeans.TeamFormBean;
import com.teksystems.formbeans.UserFormBean;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Slf4j
@Controller
public class SlashController {

    @Autowired
    TeamPlayerDAO teamPlayerDAO;

    @Autowired
    TeamDAO teamDAO;

    @Autowired
    UserDAO userDAO;

    @Autowired
    PlayerDAO playerDAO;

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView signup() {
        ModelAndView response = new ModelAndView("signup");
        log.debug("In the signup controller method");
        return response;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ModelAndView signup(UserFormBean userForm) {
        ModelAndView response = new ModelAndView("signup");

        log.debug(userForm.toString());

        User user = new User();



//        if (userForm.getId() != null && userForm.getId() > 0) {
//            user = userDAO.findById(userForm.getId());
//        }

        user.setFirstName(userForm.getFirstName());
        user.setLastName(userForm.getLastName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        userDAO.save(user);


        response.addObject("userForm", userForm);

        return response;
    }

    @RequestMapping(value = "/draftboard", method = RequestMethod.GET)
    public ModelAndView draftboard() {
        ModelAndView response = new ModelAndView("draftboard");
        log.debug("In the draftboard controller method");

        List<Player> players = playerDAO.getAllPlayers();
        List<Team> teams = teamDAO.getAllTeams();
        response.addObject("teams", teams);
        response.addObject("players", players);
        return response;
    }

    @RequestMapping(value = "/create-team", method = RequestMethod.GET)
    public ModelAndView createTeam() {
        log.debug("In the create-team controller method");
        ModelAndView response = new ModelAndView("create-team");
        return response;
    }

    @PostMapping("/create-team")
    public ModelAndView createTeam(TeamFormBean form, @RequestParam Integer userId, @RequestParam(required = false) MultipartFile fileUpload) throws IOException {
        ModelAndView response = new ModelAndView("create-team");

        Team team = new Team();

        File target = new File("./src/main/webapp/pub/images/" + fileUpload.getOriginalFilename());
        log.debug(target.getAbsolutePath());
        FileUtils.copyInputStreamToFile(fileUpload.getInputStream(), target);


        response.addObject("fileUrl", "/pub/images/" + fileUpload.getOriginalFilename());

        team.setId(form.getId());
        team.setTeamName(form.getTeamName());
        team.setTeamPicture("/pub/images" + fileUpload.getOriginalFilename());
        team.setUser(userDAO.findById(userId));

        teamDAO.save(team);

        response.addObject("form", form);

        return response;
    }

}
