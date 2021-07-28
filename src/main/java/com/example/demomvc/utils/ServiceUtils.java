package com.example.demomvc.utils;

import com.example.demomvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Component
public class ServiceUtils {
    private static ServiceUtils instance;

    @Autowired
    private UserService userService;

    /* Post constructor */

    @PostConstruct
    public void fillInstance() {
        instance = this;
    }

    /*static methods */

    public static UserService userService() {
        return instance.userService;
    }
}
