package com.hieuvo.shonkstore.services;

import com.hieuvo.shonkstore.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDto> getAllEmployees();

    EmployeeDto createEmployee(EmployeeDto employeeDto);
}
