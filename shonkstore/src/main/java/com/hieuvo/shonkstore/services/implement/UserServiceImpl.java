package com.hieuvo.shonkstore.services.implement;

import com.hieuvo.shonkstore.dto.UserDto;
import com.hieuvo.shonkstore.dto.access.RegisterDto;
import com.hieuvo.shonkstore.mappers.UserMapper;
import com.hieuvo.shonkstore.models.user.User;
import com.hieuvo.shonkstore.repositories.UserRepository;
import com.hieuvo.shonkstore.services.EmployeeSalaryService;
import com.hieuvo.shonkstore.services.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private EmployeeSalaryService employeeSalaryService;

    @Override
    public UserDto createEmployee(RegisterDto registerDto) {
        User user = userMapper.convertRegisterDtoToModel(registerDto);

        employeeSalaryService.createEmployeeSalary(user);
        userRepository.save(user);

        return userMapper.convertModelToDto(user);
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
