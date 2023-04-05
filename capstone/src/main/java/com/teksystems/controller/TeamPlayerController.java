package com.teksystems.controller;

import com.teksystems.database.dao.PlayerDAO;
import com.teksystems.database.dao.TeamDAO;
import com.teksystems.database.dao.TeamPlayerDAO;
import com.teksystems.database.entity.TeamPlayer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class TeamPlayerController {

    @Autowired
    private TeamPlayerDAO teamPlayerDAO;

    @GetMapping("/team/viewAll")
    public ModelAndView view() {
        ModelAndView response = new ModelAndView("team/viewAll");
        log.debug("In team player view controller method");

        List<TeamPlayer> teamPlayers = teamPlayerDAO.getAllTeamPlayers();

        response.addObject("teamPlayers", teamPlayers);

        return response;
    }
}
