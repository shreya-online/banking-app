package com.example.banking.service;

import com.example.banking.dto.request.LoginRequest;

public interface AuthenticationService {

    void login(LoginRequest loginRequest);
}
