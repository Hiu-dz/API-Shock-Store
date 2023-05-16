package com.hieuvo.shonkstore.services;

import com.hieuvo.shonkstore.common.responses.AuthenticationResponse;
import com.hieuvo.shonkstore.dto.access.AuthenticationDto;
import com.hieuvo.shonkstore.dto.access.LoginDto;
import com.hieuvo.shonkstore.dto.access.RegisterDto;

public interface AccountService {
    AuthenticationResponse loginAccount(LoginDto loginDto);
    AuthenticationDto createAccount(RegisterDto registerDto);
}
