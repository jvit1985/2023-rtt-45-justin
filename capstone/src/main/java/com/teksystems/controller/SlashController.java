package com.teksystems.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class SlashController {

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView signup() {
        log.info("In the index controller method");
        ModelAndView response = new ModelAndView("signup");
        return response;
    }

    @RequestMapping(value = "/draftboard", method = RequestMethod.GET)
    public ModelAndView draftboard() {
        log.info("In the draftboard controller method");
        ModelAndView response = new ModelAndView("draftboard");
        return response;
    }

    @RequestMapping(value = "/create-team", method = RequestMethod.GET)
    public ModelAndView createTeam() {
        log.info("In the create-team controller method");
        ModelAndView response = new ModelAndView("create-team");
        return response;
    }

    @RequestMapping(value = "/team1", method = RequestMethod.GET)
    public ModelAndView team1() {
        log.info("In the team1 controller method");
        ModelAndView response = new ModelAndView("team1");
        return response;
    }
}
