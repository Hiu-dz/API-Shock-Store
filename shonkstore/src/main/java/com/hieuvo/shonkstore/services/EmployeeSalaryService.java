package com.hieuvo.shonkstore.services;


import com.hieuvo.shonkstore.models.user.User;
import com.hieuvo.shonkstore.models.user.EmployeeSalary;

public interface EmployeeSalaryService {
    EmployeeSalary createEmployeeSalary(User user);
    EmployeeSalary createEmployeeSalary(User user, Double salary);
}
