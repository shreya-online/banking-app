package com.example.banking.dto.request;

public record RegisterRequest(
        String fullName,
        String username,
        String password

) {
}
