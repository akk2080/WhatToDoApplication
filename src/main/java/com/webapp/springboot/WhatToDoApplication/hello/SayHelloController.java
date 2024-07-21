package com.webapp.springboot.WhatToDoApplication.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
    @RequestMapping("say-hello-jsp")
    public String sayHello(){
        return "sayHello";
    }
}
