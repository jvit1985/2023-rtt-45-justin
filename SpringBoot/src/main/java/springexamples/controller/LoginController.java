package springexamples.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
public class LoginController {

    @GetMapping("/login/login")
    public ModelAndView setup() {
        log.debug("In the login controller method");
        ModelAndView response = new ModelAndView("login/login");

        return response;
    }
}
