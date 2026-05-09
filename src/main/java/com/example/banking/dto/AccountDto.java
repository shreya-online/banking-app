package com.example.banking.dto;

import com.example.banking.entity.AccountStatus;
import com.example.banking.entity.AccountType;
import com.example.banking.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

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
