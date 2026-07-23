package com.cfs.JWT.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @GetMapping("/test")
    public String hello(){
        return "Hi Buddy";
    }

    @GetMapping("/info")
    public String info(){
        return "last login at 9pm ";
    }
}
