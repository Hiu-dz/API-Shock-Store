package com.hieuvo.shonkstore.dto.access;

import com.hieuvo.shonkstore.dto.AccountDto;
import com.hieuvo.shonkstore.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationDto {
    private AccountDto account;
    private UserDto employee;
}
