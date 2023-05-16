package com.hieuvo.shonkstore.mappers;

import com.hieuvo.shonkstore.common.constants.ShonkSExceptionMessage;
import com.hieuvo.shonkstore.dto.UserDto;
import com.hieuvo.shonkstore.dto.access.RegisterDto;
import com.hieuvo.shonkstore.exceptions.NotFoundException;
import com.hieuvo.shonkstore.models.user.User;
import com.hieuvo.shonkstore.models.user.EmployeeSalary;
import com.hieuvo.shonkstore.models.user.UserType;
import com.hieuvo.shonkstore.repositories.EmployeeSalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserMapper {
    @Autowired
    private EmployeeSalaryRepository employeeSalaryRepository;

    public UserDto convertModelToDto(User user) {
        UserDto userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setSurname(user.getSurname());
        userDto.setName(user.getName());
        userDto.setDateOfBirth(user.getDateOfBirth());
        userDto.setAge(user.getAge());
        userDto.setEmail(user.getEmail());
        userDto.setAddress(user.getAddress());
        userDto.setPhone(user.getPhone());
        userDto.setType(user.getType().getValue());
        userDto.setSalary(getEmployeeSalary(user));
        userDto.setBeginTime(user.getBeginTime());
        userDto.setEndTime(user.getEndTime());

        return userDto;
    }

    public User convertDtoToModel(UserDto userDto) {
        User user = new User();

        user.setSurname(userDto.getSurname());
        user.setName(userDto.getName());
        user.setAddress(userDto.getAddress());
        user.setPhone(userDto.getPhone());
        user.setType(UserType.getType(userDto.getType()));
        user.setBeginTime(userDto.getBeginTime());
        user.setEndTime(userDto.getEndTime());

        return user;
    }

    public User convertRegisterDtoToModel(RegisterDto registerDto) {
        User user = new User();
        EmployeeSalary employeeSalary = new EmployeeSalary();

        employeeSalary.setSalary(registerDto.getSalary());
        employeeSalary.setPaid(true);

        user.setSurname(registerDto.getSurname());
        user.setName(registerDto.getName());
        user.setDateOfBirth(registerDto.getDateOfBirth());
        user.setAge(registerDto.getAge());
        user.setEmail(registerDto.getEmail());
        user.setAddress(registerDto.getAddress());
        user.setPhone(registerDto.getPhone());
        user.setType(UserType.getType(registerDto.getType()));
        user.setBeginTime(LocalDateTime.now());
        user.setEndTime(null);
        user.setEmployeeSalary(employeeSalary);

        return user;
    }

    private Double getEmployeeSalary(User user) {
        EmployeeSalary employeeSalary = employeeSalaryRepository.findAll().stream()
                .filter(eSalary -> user.getEmployeeSalary().getId().equals(eSalary.getId())).findFirst()
                .orElseThrow(() -> new NotFoundException(ShonkSExceptionMessage.SALARY_001 + user.getId()));

        return employeeSalary.getSalary();
    }
}
