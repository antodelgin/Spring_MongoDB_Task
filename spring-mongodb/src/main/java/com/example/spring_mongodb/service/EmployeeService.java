package com.example.spring_mongodb.service;


import com.example.spring_mongodb.entity.Employee;
import com.example.spring_mongodb.exception.EmployeeNotFoundException;
import com.example.spring_mongodb.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

//  Service class to handle business logic related to Employee operations.

@Service
@AllArgsConstructor
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    //Saves an employee to the database.
    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
    //Retrieves all employees from the database
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }
    //Retrieves a single employee by ID
    //Throws EmployeeNotFoundException if the employee is not found
    public Employee getEmployeeById(String id) {
        return employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
    }

}
