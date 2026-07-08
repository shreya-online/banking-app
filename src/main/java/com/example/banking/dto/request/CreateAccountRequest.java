package com.example.banking.dto.request;

import com.example.banking.entity.enums.AccountType;

import java.math.BigDecimal;

public record CreateAccountRequest(Long customerId, String accountHolderName, AccountType accountType) {}
