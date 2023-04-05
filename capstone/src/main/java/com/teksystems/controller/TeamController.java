package com.teksystems.controller;

import com.teksystems.database.dao.TeamDAO;
import com.teksystems.database.dao.TeamPlayerDAO;
import com.teksystems.database.dao.UserDAO;
import com.teksystems.database.entity.Player;
import com.teksystems.database.entity.Team;
import com.teksystems.database.entity.TeamPlayer;
import com.teksystems.formbeans.TeamFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping( value = "/team")
public class TeamController {

    @Autowired
    private TeamDAO teamDAO;

    @Autowired
    private TeamPlayerDAO teamPlayerDAO;

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable Integer id) {
        ModelAndView response = new ModelAndView("team/detail");
        log.debug("In team detail controller method with id = " + id);
//        Team team = teamDAO.findById(id);
        List<Player> players = teamPlayerDAO.findAllPlayersByTeamId(1);

        response.addObject("players", players);

        log.debug(players + "");
        return response;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Integer id) {
        ModelAndView response = new ModelAndView("team/edit");
        log.debug("In team controller - edit method");

        Team team = teamDAO.findById(id);
        TeamFormBean teamForm = new TeamFormBean();

        teamForm.setId(team.getId());
        teamForm.setTeamName(team.getTeamName());
        teamForm.setTeamPicture(team.getTeamPicture());
        teamForm.setUserId(team.getUserId());

        response.addObject("teamForm", teamForm);

        return response;
    }

    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView response = new ModelAndView("team/create");
        log.debug("In team create controller method");

        return response;
    }

    @GetMapping("/createSubmit")
    public ModelAndView createSubmit(TeamFormBean teamForm) {
        ModelAndView response = new ModelAndView("team/create");
        log.debug("In team createSubmit controller method");
        log.debug(teamForm.toString());

        Team team = new Team();

        if (teamForm.getId() != null && teamForm.getId() > 0) {
            team = teamDAO.findById(teamForm.getId());
        }

        team.setTeamName(teamForm.getTeamName());
        team.setTeamPicture(teamForm.getTeamPicture());
        team.setUserId(team.getUserId());
        team.setId(teamForm.getId());

        teamDAO.save(team);
        response.addObject("teamForm", teamForm);

        return response;
    }

}
