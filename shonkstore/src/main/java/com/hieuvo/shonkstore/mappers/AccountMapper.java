package com.hieuvo.shonkstore.mappers;

import com.hieuvo.shonkstore.dto.AccountDto;
import com.hieuvo.shonkstore.dto.access.RegisterDto;
import com.hieuvo.shonkstore.models.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public AccountDto convertModelToDto(Account account) {
        AccountDto accountDto = new AccountDto();

        accountDto.setId(account.getId());
        accountDto.setUsername(account.getUsername());
        accountDto.setPassword(account.getPassword());
        accountDto.setActivated(account.isActivated());
        accountDto.setDeleted(account.isDeleted());

        return accountDto;
    }

    public Account convertRegisterDtoToModel(RegisterDto registerDto) {
        Account account = new Account();

        account.setUsername(registerDto.getUsername());
        account.setPassword(registerDto.getPassword());
        account.setActivated(true);
        account.setDeleted(false);

        return account;
    }
}
