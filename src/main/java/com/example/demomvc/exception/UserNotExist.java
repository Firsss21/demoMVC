package com.example.demomvc.exception;

public class UserNotExist extends Exception{
    public UserNotExist(String message) {
        super(message);
    }
}
