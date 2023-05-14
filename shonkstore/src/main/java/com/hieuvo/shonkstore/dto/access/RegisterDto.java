package com.hieuvo.shonkstore.dto.access;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class RegisterDto {
    private String username;
    private String password;
    private String confirmPassword;
    private String surname;
    private String name;
    private LocalDate dateOfBirth;
    private int age;
    private String email;
    private String address;
    private String phone;
    private String type;
    private Double salary;
}
