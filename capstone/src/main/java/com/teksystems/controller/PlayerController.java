package com.teksystems.controller;

import com.teksystems.database.dao.PlayerDAO;
import com.teksystems.database.entity.Player;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.teksystems.formbeans.PlayerFormBean;

import java.util.List;

@Slf4j
@Controller
@RequestMapping( value = "/player")
public class PlayerController {

    @Autowired
    private PlayerDAO playerDAO;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView response = new ModelAndView("player/create");
        log.debug("In player create controller method");

        return response;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Integer id) {
        ModelAndView response = new ModelAndView("player/create");
        log.debug("In player controller - edit player");

        Player player = playerDAO.findById(id);
        PlayerFormBean form = new PlayerFormBean();

        form.setId(player.getId());
        form.setName(player.getName());
        form.setPosition(player.getPosition());
        form.setTeam(player.getTeam());
        form.setBye(player.getBye());

        response.addObject("form", form);

        return response;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/createSubmit")
    public ModelAndView createSubmit(PlayerFormBean form) {
        ModelAndView response = new ModelAndView("player/create");
        log.debug("In player createSubmit controller method");
        log.debug(form.toString());

        Player player = new Player();

        if(form.getId() != null && form.getId() >= 0) {
            player = playerDAO.findById(form.getId());
        }

        player.setName(form.getName());
        player.setTeam(form.getTeam());
        player.setPosition(form.getPosition());
        player.setBye(form.getBye());

        playerDAO.save(player);
        response.addObject("form", form);

        response.setViewName("redirect:/player/edit/" + player.getId());

        return response;

    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable Integer id) {
        ModelAndView response = new ModelAndView("player/detail");
        log.debug("In player detail controller method with id = " + id);
        Player player = playerDAO.findById(id);

        response.addObject("player", player);

        log.debug(player + "");
        return response;
    }
}
