package com.hieuvo.shonkstore.mappers;

import com.hieuvo.shonkstore.common.constants.ShonkSExceptionMessage;
import com.hieuvo.shonkstore.dto.EmployeeDto;
import com.hieuvo.shonkstore.dto.access.RegisterDto;
import com.hieuvo.shonkstore.exceptions.NotFoundException;
import com.hieuvo.shonkstore.models.employee.Employee;
import com.hieuvo.shonkstore.models.employee.EmployeeSalary;
import com.hieuvo.shonkstore.models.employee.EmployeeType;
import com.hieuvo.shonkstore.repositories.EmployeeSalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class EmployeeMapper {
    @Autowired
    private EmployeeSalaryRepository employeeSalaryRepository;

    public EmployeeDto convertModelToDto(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setId(employee.getId());
        employeeDto.setSurname(employee.getSurname());
        employeeDto.setName(employee.getName());
        employeeDto.setAddress(employee.getAddress());
        employeeDto.setPhone(employee.getPhone());
        employeeDto.setType(employee.getType().getValue());
        employeeDto.setSalary(getEmployeeSalary(employee));
        employeeDto.setWorked(employee.isWorked());
        employeeDto.setBeginTime(employee.getBeginTime());
        employeeDto.setEndTime(employee.getEndTime());

        return employeeDto;
    }

    public Employee convertDtoToModel(EmployeeDto employeeDto) {
        Employee employee = new Employee();

        employee.setSurname(employeeDto.getSurname());
        employee.setName(employeeDto.getName());
        employee.setAddress(employeeDto.getAddress());
        employee.setPhone(employeeDto.getPhone());
        employee.setType(EmployeeType.getType(employeeDto.getType()));
        employee.setWorked(employeeDto.isWorked());
        employee.setBeginTime(employeeDto.getBeginTime());
        employee.setEndTime(employeeDto.getEndTime());

        return employee;
    }

    public Employee convertRegisterDtoToModel(RegisterDto registerDto) {
        Employee employee = new Employee();
        EmployeeSalary employeeSalary = new EmployeeSalary();

        employeeSalary.setSalary(registerDto.getSalary());
        employeeSalary.setPaid(true);

        employee.setSurname(registerDto.getSurname());
        employee.setName(registerDto.getName());
        employee.setDateOfBirth(registerDto.getDateOfBirth());
        employee.setAge(registerDto.getAge());
        employee.setEmail(registerDto.getEmail());
        employee.setAddress(registerDto.getAddress());
        employee.setPhone(registerDto.getPhone());
        employee.setType(EmployeeType.getType(registerDto.getType()));
        employee.setWorked(true);
        employee.setBeginTime(LocalDateTime.now());
        employee.setEndTime(null);
        employee.setEmployeeSalary(employeeSalary);

        return employee;
    }

    private Double getEmployeeSalary(Employee employee) {
        EmployeeSalary employeeSalary = employeeSalaryRepository.findAll().stream()
              .filter(eSalary -> employee.getEmployeeSalary().getId().equals(eSalary.getId())).findFirst()
              .orElseThrow(() -> new NotFoundException(ShonkSExceptionMessage.SALARY_001 + employee.getId()));

        return employeeSalary.getSalary();
    }
}
