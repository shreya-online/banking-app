package com.example.banking.exception;

//Custom Exception, which is handled in GlobalExceptionHandler
public class UserAlreadyExistsException extends RuntimeException{
    public UserAlreadyExistsException(String message){
        super(message);
    }
}
