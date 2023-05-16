package com.hieuvo.shonkstore.controllers;

import com.hieuvo.shonkstore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/employees")
public class UserController {
    @Autowired
    private UserService userService;

//    @GetMapping(path = {"", "/"}, produces = "application/json")
//    public ResponseEntity<ResponseObject> getAllEmployees() {
//        HttpStatus httpStatus = HttpStatus.OK;
//        String message = "Get all employees successfully";
//        ResponseObject responseObject = new ResponseObject(httpStatus.value(), message, employeeService.getAllEmployees());
//
//        return new ResponseEntity<>(responseObject, httpStatus);
//    }
//
//    @PostMapping(path = {"", "/"}, produces = "application/json")
//    public ResponseEntity<ResponseObject> createEmployee(@RequestBody EmployeeDto employeeDto) {
//        HttpStatus httpStatus = HttpStatus.CREATED;
//        String message = "Create new employee successfully";
//        ResponseObject responseObject = new ResponseObject(httpStatus.value(), message, employeeService.createEmployee(employeeDto));
//
//        return new ResponseEntity<>(responseObject, httpStatus);
//    }
}
