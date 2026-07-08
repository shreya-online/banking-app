package com.example.banking.dto.response;

import com.example.banking.entity.enums.AccountStatus;
import com.example.banking.entity.enums.AccountType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CreateAccountResponse(
        Long id,
        String accountNumber,
        Long customerId,
        String accountHolderName,
        AccountType accountType,
        BigDecimal balance,
        AccountStatus status,
        LocalDateTime createdAt

) {
}
