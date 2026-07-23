package com.cfs.JWT.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @GetMapping("/dashboard")
    public String adminDashboard(){
        return "welcome to admin dashboard";
    }

    @GetMapping("/user")
    public String getUser(){
        return "Ashwani , Ajay , Piyush , Monu";
    }
}
