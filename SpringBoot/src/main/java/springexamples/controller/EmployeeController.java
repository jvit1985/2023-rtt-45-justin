package springexamples.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import springexamples.database.dao.EmployeeDAO;
import springexamples.database.dao.OfficeDAO;
import springexamples.database.entity.Employee;
import springexamples.database.entity.Office;
import springexamples.formbeans.EmployeeFormBean;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping( value = "/employee")
public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Autowired
    private OfficeDAO officeDAO;

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable Integer id) {
        ModelAndView response = new ModelAndView("employee/detail");
        log.debug("In employee detail controller method with id = " + id);
        Employee employee = employeeDAO.findById(id);

        response.addObject("employee", employee);

        log.debug(employee + "");
        return response;
    }

    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView response = new ModelAndView("employee/create");
        log.debug("In employee create controller method");

        List<Office> offices = officeDAO.getAllOffices();
        response.addObject("offices", offices);

        return response;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Integer id) {
        ModelAndView response = new ModelAndView("employee/create");
        log.debug("Im employee controller - edit employee");

        Employee emp = employeeDAO.findById(id);
        EmployeeFormBean form = new EmployeeFormBean();

        form.setId(emp.getId());
        form.setEmail(emp.getEmail());
        form.setFirstName(emp.getFirstName());
        form.setLastName(emp.getLastName());
        form.setExtension(emp.getExtension());
        form.setJobTitle(emp.getJobTitle());
        form.setVacationHours(emp.getVacationHours());
        form.setOfficeId(emp.getOfficeId());
        form.setProfileImage(emp.getProfileImage());

        response.addObject("form", form);

        List<Office> offices = officeDAO.getAllOffices();
        response.addObject("offices", offices);

        return response;

    }

    @GetMapping("/createSubmit")
    public ModelAndView createSubmit(EmployeeFormBean form) {
        ModelAndView response = new ModelAndView("employee/create");

        List<Office> offices = officeDAO.getAllOffices();
        response.addObject("offices", offices);

        log.debug("In employee createSubmit controller method");
        log.debug(form.toString());

        Employee emp = new Employee();

        if (form.getId() != null && form.getId() > 0) {
            emp = employeeDAO.findById(form.getId());
        }

        emp.setEmail(form.getEmail());
        emp.setFirstName(form.getFirstName());
        emp.setLastName(form.getLastName());
        emp.setExtension(form.getExtension());
        emp.setJobTitle(form.getJobTitle());
        emp.setVacationHours(form.getVacationHours());
        emp.setOfficeId(form.getOfficeId());
        emp.setProfileImage(form.getProfileImage());

        employeeDAO.save(emp);
        response.addObject("form", form);

        return response;
    }


    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView employeeSearch(@RequestParam(required = false) String firstSearch, @RequestParam(required = false) String lastSearch) {
        log.debug("In the employee search controller method with firstName = " + firstSearch +" lastName = "+ lastSearch);
        ModelAndView response = new ModelAndView("employee/search");

        List<Employee> employees = new ArrayList<>();

        if ( !StringUtils.isEmpty(firstSearch) && !StringUtils.isEmpty(lastSearch)) {
            employees = employeeDAO.findByFirstNameContainingOrLastNameContainingIgnoreCase(firstSearch, lastSearch);
        } if ( !StringUtils.isEmpty(firstSearch) && StringUtils.isEmpty(lastSearch)) {
            employees = employeeDAO.findByFirstNameContainingIgnoreCase(firstSearch);
        } if ( !StringUtils.isEmpty(lastSearch) && StringUtils.isEmpty(firstSearch)) {
            employees = employeeDAO.findByLastNameContainingIgnoreCase(lastSearch);
        }

        response.addObject("employeesList", employees);
        response.addObject("firstSearchParam", firstSearch);
        response.addObject("lastSearchParam", lastSearch);

        return response;
    }

}
