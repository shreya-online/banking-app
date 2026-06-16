package com.example.banking.dto;

import com.example.banking.entity.enums.AccountStatus;
import com.example.banking.entity.enums.AccountType;
import com.example.banking.entity.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;

//@Data
//@AllArgsConstructor
//public class AccountDto {
//    private Long id;
//    private String accountHolderName;
//    private double balance;
//}

public record AccountDto(Long id,
                         String accountNumber,
                         User user,
                         BigDecimal balance,
                         AccountType accountType,
                         AccountStatus accountStatus,
                         Long version,
                         LocalDateTime createdAt,
                         LocalDateTime updatedAt
) {
}