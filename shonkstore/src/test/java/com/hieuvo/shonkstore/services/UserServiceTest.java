package com.hieuvo.shonkstore.services;

import com.hieuvo.shonkstore.dto.UserDto;
import com.hieuvo.shonkstore.mappers.UserMapper;
import com.hieuvo.shonkstore.models.user.User;
import com.hieuvo.shonkstore.models.user.EmployeeSalary;
import com.hieuvo.shonkstore.models.user.UserType;
import com.hieuvo.shonkstore.repositories.UserRepository;
import com.hieuvo.shonkstore.services.implement.UserServiceImpl;
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

//@ExtendWith(MockitoExtension.class)
class UserServiceTest {
//    @Mock
//    private UserRepository userRepository;
//
//    @Mock
//    private UserMapper userMapper;
//
//    @InjectMocks
//    private UserService userService = Mockito.spy(new UserServiceImpl());
//
//    private List<UserDto> createEmployeeDtoList(List<User> users) {
//        return users.stream()
//                .map(employee -> userMapper.convertModelToDto(employee))
//                .collect(Collectors.toList());
//    }
//
//    private List<User> createEmployees() {
//        List<User> users = new ArrayList<User>();
//
//        User ownerUser = new User();
//        ownerUser.setSurname("Võ");
//        ownerUser.setName("Trọng Hiếu");
//        ownerUser.setAddress("Thành An - An Khê - Gia Lai");
//        ownerUser.setPhone("01234567890");
//        ownerUser.setType(UserType.OWNER);
//        ownerUser.setBeginTime(LocalDateTime.now());
//        ownerUser.setEndTime(null);
//        ownerUser.setEmployeeSalary(createEmployeeSalary(ownerUser.getType()));
//        users.add(ownerUser);
//
//        User managerUser = new User();
//        managerUser.setSurname("Nguyễn");
//        managerUser.setName("Linh Ngân");
//        managerUser.setAddress("An Khê - Gia Lai");
//        managerUser.setPhone("01234567890");
//        managerUser.setType(UserType.MANAGER);
//        managerUser.setBeginTime(LocalDateTime.now());
//        managerUser.setEndTime(null);
//        managerUser.setEmployeeSalary(createEmployeeSalary(managerUser.getType()));
//        users.add(managerUser);
//
//        User cashierUser = new User();
//        cashierUser.setSurname("Nguyễn");
//        cashierUser.setName("Linh Tinh");
//        cashierUser.setAddress("Quy Nhơn - Bình Định");
//        cashierUser.setPhone("01234567890");
//        cashierUser.setType(UserType.CASHIER);
//        cashierUser.setBeginTime(LocalDateTime.now());
//        cashierUser.setEndTime(null);
//        cashierUser.setEmployeeSalary(createEmployeeSalary(cashierUser.getType()));
//        users.add(cashierUser);
//
//        return users;
//    }
//
//    private EmployeeSalary createEmployeeSalary(UserType userType) {
//        EmployeeSalary ownerSalary = new EmployeeSalary();
//        ownerSalary.setSalary(5000.00);
//        ownerSalary.setPaid(true);
//
//        EmployeeSalary managerSalary = new EmployeeSalary();
//        managerSalary.setSalary(2000.00);
//        managerSalary.setPaid(true);
//
//        EmployeeSalary cashierSalary = new EmployeeSalary();
//        cashierSalary.setSalary(1500.00);
//        cashierSalary.setPaid(true);
//
//        return switch (userType) {
//            case OWNER ->  ownerSalary;
//            case MANAGER ->  managerSalary;
//            case CASHIER -> cashierSalary;
//        };
//    }
//
//    @Test
//    void getAllEmployeesWhenValidThenSuccessfully() {
//        List<User> users = createEmployees();
//        List<UserDto> userDtoList = createEmployeeDtoList(users);
//
//        Mockito.when(userRepository.findAll()).thenReturn(users);
//        for (int i = 0; i < userDtoList.size(); i++) {
//            Mockito.when(userMapper.convertModelToDto(users.get(i))).thenReturn(userDtoList.get(i));
//        }
//
//        List<UserDto> result = userService.getAllEmployees();
//
//        Assertions.assertNotNull(result);
//        Assertions.assertEquals(userDtoList.size(), result.size());
//        Assertions.assertTrue(result.containsAll(userDtoList));
//        Mockito.verify(userService, Mockito.times(1)).getAllEmployees();
//    }
}
