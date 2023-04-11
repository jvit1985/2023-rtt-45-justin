package com.teksystems.controller;

import com.teksystems.database.dao.PlayerDAO;
import com.teksystems.database.dao.TeamDAO;
import com.teksystems.database.dao.TeamPlayerDAO;
import com.teksystems.database.dao.UserDAO;
import com.teksystems.database.entity.Player;
import com.teksystems.database.entity.Team;
import com.teksystems.database.entity.TeamPlayer;
import com.teksystems.database.entity.User;
import com.teksystems.formbeans.TeamFormBean;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping( value = "/team")
public class TeamController {

    @Autowired
    private TeamDAO teamDAO;

    @Autowired
    private TeamPlayerDAO teamPlayerDAO;

    @Autowired
    private UserDAO userDAO;

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable Integer id) {
        ModelAndView response = new ModelAndView("team/detail");
        log.debug("In team detail controller method with id = " + id);
        Team team = teamDAO.findById(id);
        List<Map<String, Object>> players = teamPlayerDAO.findAllPlayersByTeamId(team.getId());

        response.addObject("team", team);
        response.addObject("players", players);

        log.debug(players + "");
        return response;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Integer id, TeamFormBean form, @RequestParam(required = false)MultipartFile fileUpload) throws IOException {
        ModelAndView response = new ModelAndView("team/edit");
        log.debug("In team controller - edit method");

        Team team = teamDAO.findById(id);

        File target = new File("./src/main/webapp/pub/images/" + fileUpload.getOriginalFilename());
        log.debug(target.getAbsolutePath());
        FileUtils.copyInputStreamToFile(fileUpload.getInputStream(), target);


        response.addObject("fileUrl", "/pub/images/" + fileUpload.getOriginalFilename());

        team.setId(form.getId());
        team.setTeamName(form.getTeamName());
        team.setTeamPicture("/pub/images" + fileUpload.getOriginalFilename());


        teamDAO.save(team);

        response.addObject("form", form);

        return response;

    }

    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView response = new ModelAndView("team/create");
        log.debug("In team create controller method");

        return response;
    }

    @GetMapping("/createSubmit")
    public ModelAndView createSubmit(TeamFormBean form, @RequestParam Integer userId) {
        ModelAndView response = new ModelAndView("team/create");
        log.debug("In team createSubmit controller method");
        log.debug(form.toString());

        User user = userDAO.findById(userId);
        Team team = new Team();

        if (form.getId() != null && form.getId() > 0) {
            team = teamDAO.findById(form.getId());
        }

        team.setTeamName(form.getTeamName());
        team.setTeamPicture(form.getTeamPicture());
        team.setId(form.getId());
        team.setUser(user);

        teamDAO.save(team);
        response.addObject("form", form);

        return response;
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView teamSearch(@RequestParam(required = false) String teamSearch) {
        log.debug("In the team search controller method with teamName = " + teamSearch);
        ModelAndView response = new ModelAndView("team/search");

        List<Team> teams = teamDAO.findByTeamNameContainingIgnoreCase(teamSearch);

        response.addObject("teamList", teams);
        response.addObject("teamSearchParam", teamSearch);


        return response;
    }

}
