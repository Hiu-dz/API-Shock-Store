package com.hieuvo.shonkstore.services;

import com.hieuvo.shonkstore.dto.AccountDto;
import com.hieuvo.shonkstore.dto.access.LoginDto;
import com.hieuvo.shonkstore.dto.access.RegisterDto;

public interface AccountService {
    LoginDto loginAccount(LoginDto loginDto);
    AccountDto createAccount(RegisterDto registerDto);
}
