package com.example.banking.service.impl;

import com.example.banking.dto.request.LoginRequest;
import com.example.banking.dto.request.RegisterRequest;
import com.example.banking.dto.response.LoginResponse;
import com.example.banking.dto.response.RegisterResponse;
import com.example.banking.entity.User;
import com.example.banking.entity.enums.Role;
import com.example.banking.exception.UserAlreadyExistsException;
import com.example.banking.repository.UserRepository;
import com.example.banking.security.CustomUserDetails;
import com.example.banking.security.JwtService;
import com.example.banking.service.AuthenticationService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationServiceImpl(AuthenticationManager authenticationManager, JwtService jwtService,
                                     UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        authenticationManager.authenticate(             //verifies credentials
                new UsernamePasswordAuthenticationToken(
                        loginRequest.username(),
                        loginRequest.password()
                )
        );
//  After authentication, we need the complete User object from DB.
//  loginRequest contains just username, pwd but loginResponse contains lot more which only the db has

//  Even though authentication already verified the user, the repository still returns an Optional
//  orElseThrow() safely handles the unlikely case that the user no longer exists.
        User user = userRepository.findByUsername(loginRequest.username())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));  //another database query.

        UserDetails userDetails = new CustomUserDetails(user);
        String token = jwtService.generateToken(userDetails);

        return new LoginResponse(token,
                                user.getUsername(),
                                user.getRole(),
                                jwtService.getJwtExpiration(),
                                user.getFullName());
    }
//authentication.getPrincipal() returns the same CustomUserDetails object that CustomUserDetailsService created earlier.No new DB query is needed
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        loginRequest.username(),
//                        loginRequest.password()));
//        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
//        User user = userDetails.getUser();
//        String token = jwtService.generateToken(userDetails);

    @Override
    public RegisterResponse register(RegisterRequest registerRequest) {
        if(userRepository.existsByUsername(registerRequest.username())){
            throw new UserAlreadyExistsException("Username already exists");
        }
        User user = new User();
        if(registerRequest.fullName() == null || registerRequest.fullName().isBlank()){
            throw new IllegalArgumentException("Fullname is required");
        }
        else{
            user.setFullName(registerRequest.fullName());
        }

        if(registerRequest.username() == null || registerRequest.username().isBlank()){
            throw new IllegalArgumentException("Username is required");
        }
        else{
            user.setUsername(registerRequest.username());
        }

        if(registerRequest.password() == null || registerRequest.password().length()<6){
            throw new IllegalArgumentException("Password must be at least 6 characters");
        }
        else{
            user.setPassword(passwordEncoder.encode(registerRequest.password()));
        }

        user.setRole(Role.USER);
        user.setActive(true);   //Since boolean defaults to false, JPA saves: is_active = 0

        User savedUser = userRepository.save(user);
        return new RegisterResponse(
                savedUser.getId(),
                savedUser.getUsername(),
                "User registered successfully"
        );
    }

}
