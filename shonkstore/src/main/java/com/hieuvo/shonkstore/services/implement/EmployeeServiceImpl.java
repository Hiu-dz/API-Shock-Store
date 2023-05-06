package com.hieuvo.shonkstore.services.implement;

import com.hieuvo.shonkstore.models.employee.Employee;
import com.hieuvo.shonkstore.repositories.EmployeeRepository;
import com.hieuvo.shonkstore.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
