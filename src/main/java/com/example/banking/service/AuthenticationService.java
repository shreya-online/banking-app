package com.example.banking.service;

import com.example.banking.dto.request.LoginRequest;
import com.example.banking.dto.request.RegisterRequest;
import com.example.banking.dto.response.LoginResponse;
import com.example.banking.dto.response.RegisterResponse;

public interface AuthenticationService {

    LoginResponse login(LoginRequest loginRequest);

    RegisterResponse register(RegisterRequest registerRequest);
}
