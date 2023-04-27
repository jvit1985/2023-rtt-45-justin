package com.teksystems.controller;

import com.teksystems.database.dao.TeamDAO;
import com.teksystems.database.dao.TeamPlayerDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class TeamPlayerController {

    @Autowired
    private TeamDAO teamDao;

    @Autowired
    private TeamPlayerDAO teamPlayerDAO;

    @GetMapping("/team/viewAll")
    public ModelAndView view() {
        ModelAndView response = new ModelAndView("team/viewAll");
        log.debug("In team player viewAll controller method");

        List<Map<String, Object>> teamPlayers = teamPlayerDAO.findAllPlayersForAllTeams();

        response.addObject("teamPlayers", teamPlayers);

        return response;

    }

    // @GetMapping("/team/viewAllSubmit")
    // public ModelAndView detail(@PathVariable Integer id) {
    // ModelAndView response = new ModelAndView("team/viewAll");
    // log.debug("In team player viewAll submit controller method");
    // Team team = teamDao.findById(id);
    // List<Map<String, Object>> players =
    // teamPlayerDAO.findAllPlayersByTeamId(team.getId());
    //
    // response.addObject("team", team);
    // response.addObject("players", players);
    //
    // log.debug(players + "");
    // return response;
    // }
}
