package com.liu.example.dubbo.consumer.controller;

import com.liu.example.dubbo.service.UserService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Reference(version = "1.0.0")
    private UserService userService;

    @RequestMapping("/index")
    public String greeting() {
        return "hello, i'm dubbo sonsumer!";
    }

    @GetMapping("/user")
    public String getUser() {
        return userService.getUserName();
    }
}
