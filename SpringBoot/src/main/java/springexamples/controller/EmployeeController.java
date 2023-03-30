package springexamples.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import springexamples.database.dao.EmployeeDAO;
import springexamples.database.entity.Employee;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping( value = "/employee")
public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDAO;

    @RequestMapping(value = "/employee-search", method = RequestMethod.GET)
    public ModelAndView employeeSearch(@RequestParam(required = false) String firstSearch, @RequestParam(required = false) String lastSearch) {
        log.info("In the employee search controller method with firstName = " + firstSearch +" lastName = "+ lastSearch);
        ModelAndView response = new ModelAndView("employee/employee-search");

        List<Employee> employees = new ArrayList<>();

        if ( !StringUtils.isEmpty(firstSearch) && ! StringUtils.isEmpty(lastSearch)) {
            employees = employeeDAO.findByFirstNameContainingOrLastNameContainingIgnoreCase(firstSearch, lastSearch);
        } if ( ! StringUtils.isEmpty(firstSearch) && StringUtils.isEmpty(lastSearch)) {
            employees = employeeDAO.findByFirstNameContainingIgnoreCase(firstSearch);
        } if ( ! StringUtils.isEmpty(lastSearch) && StringUtils.isEmpty(firstSearch)) {
            employees = employeeDAO.findByLastNameContainingIgnoreCase(lastSearch);
        }

        response.addObject("employeesList", employees);
        response.addObject("firstSearchParam", firstSearch);
        response.addObject("lastSearchParam", lastSearch);

        return response;
    }

}
