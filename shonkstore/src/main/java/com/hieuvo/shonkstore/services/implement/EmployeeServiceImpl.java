package com.hieuvo.shonkstore.services.implement;

import com.hieuvo.shonkstore.common.constants.ShonkSExceptionMessage;
import com.hieuvo.shonkstore.dto.EmployeeDto;
import com.hieuvo.shonkstore.dto.access.RegisterDto;
import com.hieuvo.shonkstore.exceptions.BadRequestException;
import com.hieuvo.shonkstore.mappers.EmployeeMapper;
import com.hieuvo.shonkstore.models.employee.Employee;
import com.hieuvo.shonkstore.models.employee.EmployeeSalary;
import com.hieuvo.shonkstore.repositories.EmployeeRepository;
import com.hieuvo.shonkstore.services.EmployeeSalaryService;
import com.hieuvo.shonkstore.services.EmployeeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Log4j2
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private EmployeeSalaryService employeeSalaryService;

    @Override
    public EmployeeDto createEmployee(RegisterDto registerDto) {
        Employee employee = employeeMapper.convertRegisterDtoToModel(registerDto);

        employeeSalaryService.createEmployeeSalary(employee);
        employeeRepository.save(employee);

        return employeeMapper.convertModelToDto(employee);
    }

    /**
     * Get all employees
     *
     * @return employees list
     */
//    @Override
//    public List<EmployeeDto> getAllEmployees() {
//        List<Employee> employees = employeeRepository.findAll();
//
//        return employees.stream().map(employee -> employeeMapper.convertModelToDto(employee)).toList();
//    }

    /**
     * Create new employee. If employeeDto is invalid, this func will throw exception instead of new employee.
     *
     * @param employeeDto: employeeDto
     * @return new employee
     */
//    @Override
//    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
//        if (!isComplete(employeeDto)) {
//            throw new BadRequestException(ShonkSExceptionMessage.SHONKS_001);
//        }
//        if (hasEmployee(employeeDto)) {
//            throw new BadRequestException(ShonkSExceptionMessage.EMPLOYEE_001);
//        }
//
//        Employee employee = employeeMapper.convertDtoToModel(employeeDto);
//        EmployeeSalary employeeSalary = employeeSalaryService.createEmployeeSalary(employee, employeeDto.getSalary());
//
//        employee.setWorked(true);
//        employee.setBeginTime(LocalDateTime.now());
//        employee.setEmployeeSalary(employeeSalary);
//        employeeRepository.save(employee);
//
//        return employeeMapper.convertModelToDto(employee);
//    }

    /**
     * Check employeeDto is completed if required information is not null
     *
     * @param employeeDto: employeeDto
     * @return true if completed or opposite
     */
//    private boolean isComplete(EmployeeDto employeeDto) {
//        return  employeeDto.getSurname() != null &&
//                employeeDto.getName() != null &&
//                employeeDto.getType() != null &&
//                employeeDto.getSalary() != null;
//    }

    /**
     * Check the employee already exists by surname, name and type
     *
     * @param employeeDto: employeeDto
     * @return true if the employee already exists or opposite
     */
//    private boolean hasEmployee(EmployeeDto employeeDto) {
//        return employeeRepository.findAll().stream()
//                .anyMatch(employee -> employeeDto.getSurname().equals(employee.getSurname()) &&
//                                      employeeDto.getName().equals(employee.getName()) &&
//                                      employeeDto.getType().equals(employee.getType().getValue())
//                );
//    }
}
