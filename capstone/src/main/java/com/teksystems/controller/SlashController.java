package com.teksystems.controller;

import com.teksystems.database.dao.PlayerDAO;
import com.teksystems.database.dao.TeamDAO;
import com.teksystems.database.dao.TeamPlayerDAO;
import com.teksystems.database.entity.Player;
import com.teksystems.database.entity.Team;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
public class SlashController {

    @Autowired
    TeamPlayerDAO teamPlayerDAO;

    @Autowired
    TeamDAO teamDAO;

    @Autowired
    PlayerDAO playerDAO;

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView signup() {
        ModelAndView response = new ModelAndView("signup");
        log.debug("In the signup controller method");
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

}
