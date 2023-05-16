package com.hieuvo.shonkstore.services;

import com.hieuvo.shonkstore.dto.UserDto;
import com.hieuvo.shonkstore.dto.access.RegisterDto;

public interface UserService {
//    List<EmployeeDto> getAllEmployees();

    UserDto createEmployee(RegisterDto registerDto);
}
