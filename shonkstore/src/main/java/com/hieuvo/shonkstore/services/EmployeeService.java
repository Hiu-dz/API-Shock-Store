package com.hieuvo.shonkstore.services;

import com.hieuvo.shonkstore.dto.EmployeeDto;
import com.hieuvo.shonkstore.dto.access.RegisterDto;

import java.util.List;

public interface EmployeeService {
//    List<EmployeeDto> getAllEmployees();

    EmployeeDto createEmployee(RegisterDto registerDto);
}
