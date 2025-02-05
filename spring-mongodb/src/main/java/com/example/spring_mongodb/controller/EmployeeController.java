package com.example.spring_mongodb.controller;


import com.example.spring_mongodb.entity.Employee;
import com.example.spring_mongodb.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

//  Controller class handling HTTP requests related to Employee operations

@Controller
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService;

    // Displays the employee form
    @GetMapping("/")
    public String showForm(Model model){
        Employee employee=new Employee();
        model.addAttribute("employee",employee);
        return "index";
    }

    //Handles employee form submission and saves the employee
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.saveEmployee(employee);
        return "redirect:/displayAll";
    }

    //Displays all employees
    @GetMapping("/displayAll")
    public String getAllEmployees(Model model){
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees",employees);
        return "employee-list";

    }

    // Displays details of a specific employee by ID
    @GetMapping("/display/{id}")
    public String getEmployee(@PathVariable String id, Model model){
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "employee-detail";
    }


}
