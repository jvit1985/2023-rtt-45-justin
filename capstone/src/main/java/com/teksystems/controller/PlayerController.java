package com.teksystems.controller;

import com.teksystems.database.dao.PlayerDAO;
import com.teksystems.database.entity.Player;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
@RequestMapping( value = "/player")
public class PlayerController {

    @Autowired
    private PlayerDAO playerDAO;

    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView response = new ModelAndView("player/create");
        log.debug("In player create controller method");

        return response;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Integer id) {
        ModelAndView response = new ModelAndView("player/create");
        log.debug("In player controller - edit player");

        Player player = playerDAO.findById(id);
        PlayerFormBean playerForm = new PlayerFormBean();

        playerForm.setId(player.getId());
        playerForm.setName(player.getName());
        playerForm.setPosition(player.getPosition());
        playerForm.setTeam(player.getTeam());
        playerForm.setBye(player.getBye());

        response.addObject("playerForm", playerForm);

        return response;
    }

    @GetMapping("/createSubmit")
    public ModelAndView createSubmit(PlayerFormBean playerForm) {
        ModelAndView response = new ModelAndView("player/create");
        log.debug("In player createSubmit controller method");
        log.debug(playerForm.toString());

        Player player = new Player();

        if(playerForm.getId() != null && playerForm.getId() >= 0) {
            player = playerDAO.findById(playerForm.getId());
        }

        player.setName(playerForm.getName());
        player.setTeam(playerForm.getTeam());
        player.setPosition(playerForm.getPosition());
        player.setBye(playerForm.getBye());

        playerDAO.save(player);
        response.addObject("playerForm", playerForm);

        return response;

    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable Integer id) {
        ModelAndView response = new ModelAndView("employee/detail");
        log.debug("In employee detail controller method with id = " + id);
        Player player = playerDAO.findById(id);

        response.addObject("player", player);

        log.debug(player + "");
        return response;
    }
}
