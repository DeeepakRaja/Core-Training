package com.operative.springbootdemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String welcome(){
        System.out.println("Hello COntroller : Welcome");
        return "Welcome to Spring Boot";
    }

    @GetMapping("/GettingStarted")
    public String gettingStarted(){
        return "Getting Started";
    }
}
