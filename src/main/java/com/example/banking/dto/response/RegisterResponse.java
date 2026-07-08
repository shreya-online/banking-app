package com.example.banking.dto.response;

public record RegisterResponse(Long userId,
                               String username,
                               String customerId,
                               String email,
                               String message) {
}
