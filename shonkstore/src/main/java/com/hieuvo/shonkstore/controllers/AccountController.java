package com.hieuvo.shonkstore.controllers;

import com.hieuvo.shonkstore.common.responses.ResponseObject;
import com.hieuvo.shonkstore.dto.access.LoginDto;
import com.hieuvo.shonkstore.dto.access.RegisterDto;
import com.hieuvo.shonkstore.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping(path = "/login", produces = "application/json")
    public ResponseEntity<ResponseObject> loginAccount(@RequestBody LoginDto logInDto) {
        HttpStatus httpStatus = HttpStatus.OK;
        String message = "Login account successfully";
        ResponseObject result = new ResponseObject(httpStatus.value(), message, accountService.loginAccount(logInDto));

        return new ResponseEntity<>(result, httpStatus);
    }

    @PostMapping(path = {"", "/"}, produces = "application/json")
    public ResponseEntity<ResponseObject> createAccount(@RequestBody RegisterDto registerDto) {
        HttpStatus httpStatus = HttpStatus.CREATED;
        String message = "Create new account successfully";
        ResponseObject result = new ResponseObject(httpStatus.value(), message, accountService.createAccount(registerDto));

        return new ResponseEntity<>(result, httpStatus);
    }
}
