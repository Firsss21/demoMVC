package com.example.demomvc.exception;

public class UserAlreadyExist extends Exception {
    public UserAlreadyExist(String message) {
        super(message);
    }
}
