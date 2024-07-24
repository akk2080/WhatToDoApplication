package com.webapp.springboot.WhatToDoApplication.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    public boolean authenticate(String username, String password){
        boolean isValidUsername = username.equalsIgnoreCase("akk");
        boolean isValidPassword = username.equalsIgnoreCase("1234");
        return isValidUsername && isValidPassword;
    }
}
