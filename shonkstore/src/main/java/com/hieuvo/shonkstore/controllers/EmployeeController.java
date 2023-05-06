package com.hieuvo.shonkstore.controllers;

import com.hieuvo.shonkstore.models.employee.Employee;
import com.hieuvo.shonkstore.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping(path = {"", "/"}, produces = "application/json")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
}
