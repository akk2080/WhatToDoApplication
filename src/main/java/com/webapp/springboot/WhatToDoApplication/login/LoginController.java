package com.webapp.springboot.WhatToDoApplication.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {

    AuthenticationService authenticationService;
    public LoginController(AuthenticationService authenticationService){
        this.authenticationService = authenticationService;
    }
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String goToLoginPage(){
        //model.put("name", name);

        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String goToWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model){
        //model.put("name", name);
        if(authenticationService.authenticate(name, password));
            model.put("name", name);
        return "welcome";
    }
}
