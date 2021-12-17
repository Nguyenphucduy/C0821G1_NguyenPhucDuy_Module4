package com.codegym.controller;

import com.codegym.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("employee/")
public class EmployeeController {

    @GetMapping(value = "showForm")
    public String showForm(ModelMap model) {
        model.addAttribute("employee", new Employee());
        return "employee/create";
    }

    @PostMapping(value = "/addEmployee")
    public String submit(@ModelAttribute("employee") Employee employee, ModelMap model) {
        model.addAttribute("name", employee.getName());
        model.addAttribute("contactNumber", employee.getContactNumber());
        model.addAttribute("id", employee.getId());
        return "employee/info";
    }
}