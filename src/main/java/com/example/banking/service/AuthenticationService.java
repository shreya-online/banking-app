package com.example.banking.service;

import com.example.banking.dto.request.LoginRequest;
import com.example.banking.dto.response.LoginResponse;

public interface AuthenticationService {

    LoginResponse login(LoginRequest loginRequest);
}
