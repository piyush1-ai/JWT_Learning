package com.cfs.JWT.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public")
public class PublicController {

    @GetMapping("/Hello")
    public String hello(){
        return "Hello Buddy";
    }

    @GetMapping("/info")
    public String info(){
        return "GenAI course starting from 6Apr";
    }
}
