package com.teksystems.controller;

import com.teksystems.database.dao.*;
import com.teksystems.database.entity.Player;
import com.teksystems.database.entity.Team;
import com.teksystems.database.entity.User;
import com.teksystems.database.entity.UserRole;
import com.teksystems.formbeans.TeamFormBean;
import com.teksystems.formbeans.CreateUserFormBean;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.crypto.password.PasswordEncoder;


import java.io.File;
import java.io.IOException;
import java.util.List;

@Slf4j
@Controller
@RequestMapping(value = {"/index", "/", "/index.html"}, method = RequestMethod.GET)
public class SlashController {

    @Autowired
    private TeamPlayerDAO teamPlayerDAO;

    @Autowired
    private UserRoleDAO userRoleDAO;

    @Autowired
    private TeamDAO teamDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private PlayerDAO playerDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index() {
        log.debug("In the index controller method");
        ModelAndView response = new ModelAndView("index");

        return response;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView signup() {
        ModelAndView response = new ModelAndView("signup");
        log.debug("In the signup controller method");
        return response;
    }

    @PostMapping("/signupSubmit")
    public ModelAndView signup(@Valid CreateUserFormBean form, BindingResult bindingResult) {
        ModelAndView response = new ModelAndView("signup");
        log.debug("In the signup controller post method");

        if(bindingResult.hasErrors()) {
            for (FieldError error: bindingResult.getFieldErrors()) {
                log.debug("Validation Error on field : " + error.getField() + " with message : " + error.getDefaultMessage());
            }

            response.addObject("form", form);
            response.addObject("bindingResult", bindingResult);

            return response;
        }

        User user = new User();
        user.setEmail(form.getEmail());
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());

        String encryptedPassword = passwordEncoder.encode(form.getPassword());
        user.setPassword(encryptedPassword);

        //will auto generate the ID and it will populate the field in the user entity
        userDAO.save(user);
        response.addObject("form", form);
        response.addObject("success", true);

        UserRole userRole = new UserRole();
        userRole.setRoleName("USER");
        //so when we go to set the user id FK on the user role entity the user id has already populated.
        userRole.setUserId(user.getId());

        userRoleDAO.save(userRole);

        log.debug(form.toString());

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
