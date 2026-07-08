package com.example.banking.dto.response;

import com.example.banking.entity.enums.Role;

public record LoginResponse(String token,
                            String username,
                            String fullName,
                            String customerId,
                            Role role,
                            long expiresIn
                            ) {}
