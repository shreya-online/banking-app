package com.example.banking.entity;

public enum AuditAction {
    LOGIN,
    LOGOUT,
    CREATE_ACCOUNT,
    DEPOSIT,
    WITHDRAW,
    BLOCK_ACCOUNT;

    public enum AccountStatus {
        ACTIVE,
        BLOCKED,
        CLOSED
    }
}
