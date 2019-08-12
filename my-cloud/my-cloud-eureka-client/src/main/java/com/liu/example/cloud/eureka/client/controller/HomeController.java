package com.liu.example.cloud.eureka.client.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {


    @RequestMapping("/user/hello")
    public String getUserInfo(@RequestParam String userName) {
        System.out.println("Hello, " + userName);
        return "Hello, " + userName;
    }
}
