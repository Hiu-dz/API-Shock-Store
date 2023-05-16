package com.hieuvo.shonkstore.services.implement;

import com.hieuvo.shonkstore.common.constants.ShonkSExceptionMessage;
import com.hieuvo.shonkstore.common.responses.AuthenticationResponse;
import com.hieuvo.shonkstore.dto.access.AuthenticationDto;
import com.hieuvo.shonkstore.dto.access.LoginDto;
import com.hieuvo.shonkstore.dto.access.RegisterDto;
import com.hieuvo.shonkstore.exceptions.BadRequestException;
import com.hieuvo.shonkstore.exceptions.NotFoundException;
import com.hieuvo.shonkstore.exceptions.NotImplementedException;
import com.hieuvo.shonkstore.mappers.AccountMapper;
import com.hieuvo.shonkstore.mappers.AuthenticationMapper;
import com.hieuvo.shonkstore.mappers.UserMapper;
import com.hieuvo.shonkstore.models.Account;
import com.hieuvo.shonkstore.repositories.AccountRepository;
import com.hieuvo.shonkstore.services.AccountService;
import com.hieuvo.shonkstore.services.JwtService;
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
    private UserMapper userMapper;
    @Autowired
    private AuthenticationMapper authenticationMapper;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public AuthenticationResponse loginAccount(LoginDto loginDto) {
        if (!hasAccountByUsername(loginDto.getUsername())) {
            throw new BadRequestException(ShonkSExceptionMessage.ACCOUNT_003);
        }
        if (!hasAccountByUsernameAndPassword(loginDto.getUsername(), loginDto.getPassword())) {
            throw new BadRequestException(ShonkSExceptionMessage.ACCOUNT_004);
        }

        Account account = accountRepository.findAll().stream()
                .filter(acc -> loginDto.getUsername().equals(acc.getUsername()) &&
                        passwordEncoder.matches(loginDto.getPassword(), acc.getPassword()))
                .findFirst()
                .orElseThrow(() -> new NotImplementedException(ShonkSExceptionMessage.SHONKS_002));
        String jwtToken = jwtService.generateToken(account);

        return new AuthenticationResponse(jwtToken);
    }

    @Override
    public AuthenticationDto createAccount(RegisterDto registerDto) {
        if (hasAccountByUsername(registerDto.getUsername())) {
            throw new BadRequestException(ShonkSExceptionMessage.ACCOUNT_002 + registerDto.getUsername());
        }
        if (!Objects.equals(registerDto.getPassword(), registerDto.getConfirmPassword())) {
            throw new BadRequestException(ShonkSExceptionMessage.ACCOUNT_001);
        }

        Account account = accountMapper.convertRegisterDtoToModel(registerDto);
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        account.setUser(userMapper.convertRegisterDtoToModel(registerDto));
        accountRepository.save(account);

        return authenticationMapper.convertAccountToDto(account);
    }

    private boolean hasAccountByUsername(String username) {
        return accountRepository.findAll().stream()
                .anyMatch(account -> username.equals(account.getUsername()));
    }

    private boolean hasAccountByUsernameAndPassword(String username, String password) {
        return accountRepository.findAll().stream()
                .anyMatch(acc -> username.equals(acc.getUsername()) &&
                                 passwordEncoder.matches(password, acc.getPassword()));
    }

    private Account getAccountByUsername(String username) {
        return accountRepository.findAll().stream()
                .filter(acc -> username.equals(acc.getUsername())).findFirst()
                .orElseThrow(() -> new NotFoundException(ShonkSExceptionMessage.ACCOUNT_003));
    }
}
