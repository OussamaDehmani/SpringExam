package com.exam.controllers;

import com.exam.exceptions.ResourceNotFoundException;
import com.exam.models.Emp_Normal;
import com.exam.models.Employee;
import com.exam.services.DepartementService;
import com.exam.services.EmployeeServiceImpl;
import com.exam.services.RemunerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;
    @Autowired
    private DepartementService departementService;
    @Autowired
    private RemunerationService RemunerationService;

    // display list of employees
    @GetMapping("/Employee")
    public String viewHomePage(Model model) {
        model.addAttribute("listEmployees", employeeService.getAllEmployees());

        return "home/home";
    }

    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(ModelMap model, Employee employee, HttpServletRequest request) {
        // create model attribute to bind form data
        model.addAttribute("departement", departementService.findAll());
        model.addAttribute("remuneration", departementService.findAll());
        model.addAttribute("employee", employee);
        return "home/new_employee";
    }


    @PostMapping("/saveEmployee")
    public String saveEmployee(@Valid @ModelAttribute("employees") Employee employee, BindingResult result, ModelMap model, HttpServletRequest request) throws ResourceNotFoundException {
        // save employee to database
        Employee emp= new Emp_Normal();
        employeeService.saveEmployee(employee);
        return "redirect:/Employee";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        // get employee from the service
        Employee employee = employeeService.getEmployeeById(id);
        // set employee as a model attribute to pre-populate the form
        model.addAttribute("employee", employee);
        return "update_employee";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id) {
        // call delete employee method
        this.employeeService.deleteEmployeeById(id);
        return "redirect:/";
    }

}
