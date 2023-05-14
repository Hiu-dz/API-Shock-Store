package com.hieuvo.shonkstore.services;

import com.hieuvo.shonkstore.dto.EmployeeDto;
import com.hieuvo.shonkstore.mappers.EmployeeMapper;
import com.hieuvo.shonkstore.models.employee.Employee;
import com.hieuvo.shonkstore.models.employee.EmployeeSalary;
import com.hieuvo.shonkstore.models.employee.EmployeeType;
import com.hieuvo.shonkstore.repositories.EmployeeRepository;
import com.hieuvo.shonkstore.services.implement.EmployeeServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {
    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private EmployeeMapper employeeMapper;

    @InjectMocks
    private EmployeeService employeeService = Mockito.spy(new EmployeeServiceImpl());

    private List<EmployeeDto> createEmployeeDtoList(List<Employee> employees) {
        return employees.stream()
                .map(employee -> employeeMapper.convertModelToDto(employee))
                .collect(Collectors.toList());
    }

    private List<Employee> createEmployees() {
        List<Employee> employees = new ArrayList<Employee>();

        Employee ownerEmployee = new Employee();
        ownerEmployee.setSurname("Võ");
        ownerEmployee.setName("Trọng Hiếu");
        ownerEmployee.setAddress("Thành An - An Khê - Gia Lai");
        ownerEmployee.setPhone("01234567890");
        ownerEmployee.setType(EmployeeType.OWNER);
        ownerEmployee.setWorked(true);
        ownerEmployee.setBeginTime(LocalDateTime.now());
        ownerEmployee.setEndTime(null);
        ownerEmployee.setEmployeeSalary(createEmployeeSalary(ownerEmployee.getType()));
        employees.add(ownerEmployee);

        Employee managerEmployee = new Employee();
        managerEmployee.setSurname("Nguyễn");
        managerEmployee.setName("Linh Ngân");
        managerEmployee.setAddress("An Khê - Gia Lai");
        managerEmployee.setPhone("01234567890");
        managerEmployee.setType(EmployeeType.MANAGER);
        managerEmployee.setWorked(true);
        managerEmployee.setBeginTime(LocalDateTime.now());
        managerEmployee.setEndTime(null);
        managerEmployee.setEmployeeSalary(createEmployeeSalary(managerEmployee.getType()));
        employees.add(managerEmployee);

        Employee cashierEmployee = new Employee();
        cashierEmployee.setSurname("Nguyễn");
        cashierEmployee.setName("Linh Tinh");
        cashierEmployee.setAddress("Quy Nhơn - Bình Định");
        cashierEmployee.setPhone("01234567890");
        cashierEmployee.setType(EmployeeType.CASHIER);
        cashierEmployee.setWorked(true);
        cashierEmployee.setBeginTime(LocalDateTime.now());
        cashierEmployee.setEndTime(null);
        cashierEmployee.setEmployeeSalary(createEmployeeSalary(cashierEmployee.getType()));
        employees.add(cashierEmployee);

        return employees;
    }

    private EmployeeSalary createEmployeeSalary(EmployeeType employeeType) {
        EmployeeSalary ownerSalary = new EmployeeSalary();
        ownerSalary.setSalary(5000.00);
        ownerSalary.setPaid(true);

        EmployeeSalary managerSalary = new EmployeeSalary();
        managerSalary.setSalary(2000.00);
        managerSalary.setPaid(true);

        EmployeeSalary cashierSalary = new EmployeeSalary();
        cashierSalary.setSalary(1500.00);
        cashierSalary.setPaid(true);

        return switch (employeeType) {
            case OWNER ->  ownerSalary;
            case MANAGER ->  managerSalary;
            case CASHIER -> cashierSalary;
        };
    }

    @Test
    void getAllEmployeesWhenValidThenSuccessfully() {
        List<Employee> employees = createEmployees();
        List<EmployeeDto> employeeDtoList = createEmployeeDtoList(employees);

        Mockito.when(employeeRepository.findAll()).thenReturn(employees);
        for (int i = 0; i < employeeDtoList.size(); i++) {
            Mockito.when(employeeMapper.convertModelToDto(employees.get(i))).thenReturn(employeeDtoList.get(i));
        }

        List<EmployeeDto> result = employeeService.getAllEmployees();

        Assertions.assertNotNull(result);
        Assertions.assertEquals(employeeDtoList.size(), result.size());
        Assertions.assertTrue(result.containsAll(employeeDtoList));
        Mockito.verify(employeeService, Mockito.times(1)).getAllEmployees();
    }
}
