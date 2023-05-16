package com.hieuvo.shonkstore.mappers;

import com.hieuvo.shonkstore.dto.access.AuthenticationDto;
import com.hieuvo.shonkstore.models.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationMapper {
    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private UserMapper userMapper;

    public AuthenticationDto convertAccountToDto(Account account) {
        AuthenticationDto authenticationDto = new AuthenticationDto();

        authenticationDto.setAccount(accountMapper.convertModelToDto(account));
        authenticationDto.setEmployee(userMapper.convertModelToDto(account.getUser()));

        return authenticationDto;
    }
}
