package com.hieuvo.shonkstore.services.implement;

import com.hieuvo.shonkstore.models.user.User;
import com.hieuvo.shonkstore.models.user.EmployeeSalary;
import com.hieuvo.shonkstore.repositories.EmployeeSalaryRepository;
import com.hieuvo.shonkstore.services.EmployeeSalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeSalaryServiceImpl implements EmployeeSalaryService {
    @Autowired
    private EmployeeSalaryRepository employeeSalaryRepository;

    @Override
    public EmployeeSalary createEmployeeSalary(User user) {
        return employeeSalaryRepository.save(user.getEmployeeSalary());
    }

    @Override
    public EmployeeSalary createEmployeeSalary(User user, Double salary) {
        EmployeeSalary employeeSalary = new EmployeeSalary();

        employeeSalary.setSalary(salary);
        employeeSalary.setPaid(true);
        employeeSalaryRepository.save(employeeSalary);

        return employeeSalary;
    }
}
