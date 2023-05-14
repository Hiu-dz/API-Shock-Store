package com.hieuvo.shonkstore.mappers;

import com.hieuvo.shonkstore.dto.access.LoginDto;
import com.hieuvo.shonkstore.models.Account;
import org.springframework.stereotype.Component;

@Component
public class LoginMapper {
    public LoginDto convertAccountToDto(Account account) {
        LoginDto loginDto = new LoginDto();

        loginDto.setUsername(account.getUsername());
        loginDto.setPassword(account.getPassword());

        return loginDto;
    }
}
