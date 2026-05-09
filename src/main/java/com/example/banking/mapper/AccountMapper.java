package com.example.banking.mapper;

import com.example.banking.dto.AccountDto;
import com.example.banking.entity.Account;

public class AccountMapper {

    //converted accountdto into account jpa entity
    public static Account mapToAccount(AccountDto accountdto){
//        Account account = new Account(
//                accountdto.getId(), accountdto.getAccountHolderName(), accountdto.getBalance()
//        );
        Account account = new Account(
                accountdto.id(), accountdto.accountNumber(), accountdto.user(),
                accountdto.balance(), accountdto.accountType(), accountdto.accountStatus(),
                accountdto.version(), accountdto.createdAt(), accountdto.updatedAt()
        );
        return account;
    }

    public static AccountDto maptoAccountDto(Account account){
        AccountDto accountDto = new AccountDto(
                account.getId(), account.getAccountNumber(), account.getUser(),
                account.getBalance(), account.getAccountType(), account.getAccountStatus(),
                account.getVersion(), account.getCreatedAt(), account.getUpdatedAt()
        );
        return accountDto;
    }

}
