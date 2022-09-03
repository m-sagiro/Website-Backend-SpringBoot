package com.msagiroglu.backendspringboot.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String mesage) {
        super(mesage);
    }
}
