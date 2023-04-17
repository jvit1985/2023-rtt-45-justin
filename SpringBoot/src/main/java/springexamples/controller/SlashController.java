package springexamples.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import springexamples.database.dao.EmployeeDAO;
import springexamples.database.dao.UserDAO;
import springexamples.database.dao.UserRoleDAO;
import springexamples.database.entity.User;
import springexamples.database.entity.UserRole;
import springexamples.formbeans.CreateUserFormBean;
import springexamples.security.AuthenticatedUserService;
import org.springframework.validation.BindingResult;

@Slf4j
@Controller
@RequestMapping(value = {"/index" ,"/", "/index.html"}, method = RequestMethod.GET)
public class SlashController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserRoleDAO userRoleDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticatedUserService authenticatedUserService;


    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index(HttpSession session) {
        log.debug("In the index controller method");
        ModelAndView response = new ModelAndView("index");

        log.debug("################### SESSION ATTRIBUTE NAME = " + session.getAttribute("name"));

        log.trace("This is a trace log example");
        log.info("This is an info log example");
        log.debug("This is a debug log example");
        log.warn("This is a warn log example");
        log.error("This is an error log example");

        return response;
    }

    @GetMapping("/signup")
    public ModelAndView signup() {
        log.debug("In the signup controller method");
        ModelAndView response = new ModelAndView("signup");
        return response;
    }

    @PostMapping("/signupSubmit")
    public ModelAndView setup(@Valid CreateUserFormBean form, BindingResult bindingResult, HttpSession session) {

        ModelAndView response = new ModelAndView("signup");
        log.debug("In the signup controller post method");

        response.addObject("form", form);

        if (StringUtils.equals(form.getPassword(), form.getConfirmPassword()) == false){
            bindingResult.rejectValue("confirmPassword", "error.confirmPassword", "Passwords do not match");
        }

        if(bindingResult.hasErrors()){
            for ( FieldError error : bindingResult.getFieldErrors()){
                log.debug("Validation Error on field: " + error.getField());

                log.debug("Validation Error Message: " + error.getDefaultMessage());
            }

            response.addObject("bindingResult", bindingResult);

            return response;
        }


        User user = new User();
        user.setEmail(form.getEmail());
        user.setFullName(form.getFullName());

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

        //authenticate the user that was just created, needs to be after user and userrole are saved to db
        authenticatedUserService.changeLoggedInUsername(session, form.getEmail(), form.getPassword());

        log.debug(form.toString());

        return response;
    }

    @RequestMapping(value = "/bootstrap", method = RequestMethod.GET)
    public ModelAndView bootstrap() {
        log.debug("In the bootstrap controller method");
        ModelAndView response = new ModelAndView("bootstrap");
        return response;
    }
}
