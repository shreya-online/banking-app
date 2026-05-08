package com.example.banking.service;

import com.example.banking.dto.AccountDto;

import java.math.BigDecimal;
import java.util.List;

public interface AccountService {
    AccountDto createAccount(AccountDto account);

    AccountDto getAccountById(Long id);

    AccountDto deposit(Long id, BigDecimal amount);

    AccountDto withdraw(Long id, BigDecimal amount);

    List<AccountDto> getAllAccounts();

    void deleteAccount(Long id);
}
