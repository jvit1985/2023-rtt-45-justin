package com.teksystems.controller;

import com.teksystems.database.dao.PlayerDAO;
import com.teksystems.database.dao.TeamDAO;
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
    private TeamDAO teamDAO;

    @Autowired
    private PlayerDAO playerDAO;

    @GetMapping("/team/viewAll")
    public ModelAndView view() {
        ModelAndView response = new ModelAndView("team/viewAll");
        log.debug("In team player view controller method");

        List<TeamPlayer> teamPlayers = new ArrayList<>();

        response.addObject("teamPlayersList", teamPlayers);

        return response;
    }
}
