package com.hieuvo.shonkstore.services.implement;

import com.hieuvo.shonkstore.common.constants.ShonkSExceptionMessage;
import com.hieuvo.shonkstore.dto.EmployeeDto;
import com.hieuvo.shonkstore.exceptions.BadRequestException;
import com.hieuvo.shonkstore.mappers.EmployeeMapper;
import com.hieuvo.shonkstore.models.employee.Employee;
import com.hieuvo.shonkstore.models.employee.EmployeeSalary;
import com.hieuvo.shonkstore.repositories.EmployeeRepository;
import com.hieuvo.shonkstore.services.EmployeeSalaryService;
import com.hieuvo.shonkstore.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private EmployeeSalaryService employeeSalaryService;

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();

        return employees.stream().map(employee -> employeeMapper.convertModelToDto(employee)).toList();
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        if (!isComplete(employeeDto)) {
            throw new BadRequestException(ShonkSExceptionMessage.SHONKS_001);
        }

        Employee employee = employeeMapper.convertDtoToModel(employeeDto);
        EmployeeSalary employeeSalary = employeeSalaryService.createEmployeeSalary(employee, employeeDto.getSalary());

        employee.setWorked(true);
        employee.setBeginTime(LocalDateTime.now());
        employee.setDeleted(false);
        employee.setEmployeeSalary(employeeSalary);
        employeeRepository.save(employee);

        return employeeMapper.convertModelToDto(employee);
    }

    private boolean isComplete(EmployeeDto employeeDto) {
        return  employeeDto.getSurname() != null &&
                employeeDto.getName() != null &&
                employeeDto.getType() != null &&
                employeeDto.getSalary() != null;
    }

    private boolean hasEmployeeName(EmployeeDto employeeDto) {
        return employeeRepository.findAll().stream()
                .anyMatch(employee -> employeeDto.getName().equals(employee.getName()));
    }
}
