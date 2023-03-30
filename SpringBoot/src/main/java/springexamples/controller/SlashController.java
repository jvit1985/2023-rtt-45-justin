package springexamples.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import springexamples.database.dao.EmployeeDAO;

@Slf4j
@Controller
@RequestMapping(value = {"/index" ,"/", "/index.html"}, method = RequestMethod.GET)
public class SlashController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index() {
        log.info("In the index controller method");
        ModelAndView response = new ModelAndView("index");
        return response;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView signup() {
        log.info("In the signup controller method");
        ModelAndView response = new ModelAndView("signup");
        return response;
    }

    @RequestMapping(value = "/bootstrap", method = RequestMethod.GET)
    public ModelAndView bootstrap() {
        log.info("In the bootstrap controller method");
        ModelAndView response = new ModelAndView("bootstrap");
        return response;
    }
}
