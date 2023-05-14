package com.hieuvo.shonkstore.services.implement;

import com.hieuvo.shonkstore.common.constants.ShonkSExceptionMessage;
import com.hieuvo.shonkstore.dto.AccountDto;
import com.hieuvo.shonkstore.dto.access.LoginDto;
import com.hieuvo.shonkstore.dto.access.RegisterDto;
import com.hieuvo.shonkstore.exceptions.BadRequestException;
import com.hieuvo.shonkstore.exceptions.NotFoundException;
import com.hieuvo.shonkstore.mappers.AccountMapper;
import com.hieuvo.shonkstore.mappers.EmployeeMapper;
import com.hieuvo.shonkstore.mappers.LoginMapper;
import com.hieuvo.shonkstore.models.Account;
import com.hieuvo.shonkstore.repositories.AccountRepository;
import com.hieuvo.shonkstore.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private LoginMapper loginMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public LoginDto loginAccount(LoginDto loginDto) {
        if (!hasAccountByUsername(loginDto.getUsername())) {
            throw new BadRequestException(ShonkSExceptionMessage.ACCOUNT_003);
        }
        if (!isPasswordOfUsername(loginDto.getUsername(), loginDto.getPassword())) {
            throw new BadRequestException(ShonkSExceptionMessage.ACCOUNT_004);
        }

        Account account = accountRepository.findAll().stream()
                .filter(acc -> loginDto.getUsername().equals(acc.getUsername()) &&
                               passwordEncoder.encode(loginDto.getPassword()).equals(acc.getPassword())).findFirst()
                .orElseThrow(null);

        return loginMapper.convertAccountToDto(account);
    }

    @Override
    public AccountDto createAccount(RegisterDto registerDto) {
        if (hasAccountByUsername(registerDto.getUsername())) {
            throw new BadRequestException(ShonkSExceptionMessage.ACCOUNT_002 + registerDto.getUsername());
        }
        if (!Objects.equals(registerDto.getPassword(), registerDto.getConfirmPassword())) {
            throw new BadRequestException(ShonkSExceptionMessage.ACCOUNT_001);
        }

        Account account = accountMapper.convertRegisterDtoToModel(registerDto);

        account.setPassword(passwordEncoder.encode(account.getPassword()));
        account.setEmployee(employeeMapper.convertRegisterDtoToModel(registerDto));
        accountRepository.save(account);

        return accountMapper.convertModelToDto(account);
    }

    private boolean hasAccountByUsername(String username) {
        return accountRepository.findAll().stream()
                .anyMatch(account -> username.equals(account.getUsername()));
    }

    private boolean isPasswordOfUsername(String username, String password) {
        return passwordEncoder.matches(password, getAccountByUsername(username).getPassword());
    }

    private Account getAccountByUsername(String username) {
        return accountRepository.findAll().stream()
                .filter(acc -> username.equals(acc.getUsername())).findFirst()
                .orElseThrow(() -> new NotFoundException(ShonkSExceptionMessage.ACCOUNT_003));
    }
}
