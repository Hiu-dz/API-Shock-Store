package com.hieuvo.shonkstore.services;


import com.hieuvo.shonkstore.models.employee.Employee;
import com.hieuvo.shonkstore.models.employee.EmployeeSalary;

public interface EmployeeSalaryService {
    EmployeeSalary createEmployeeSalary(Employee employee, Double salary);
}
