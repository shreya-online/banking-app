package com.example.banking.controller;

import com.example.banking.dto.request.LoginRequest;
import com.example.banking.service.impl.AuthenticationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private AuthenticationServiceImpl authenticationServiceImpl;

    @Autowired
    public AuthController(AuthenticationServiceImpl authenticationServiceImpl){
        this.authenticationServiceImpl = authenticationServiceImpl;
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginRequest loginRequest){
        authenticationServiceImpl.login(loginRequest);
        return ResponseEntity.ok("Login Successful");
    }
}
