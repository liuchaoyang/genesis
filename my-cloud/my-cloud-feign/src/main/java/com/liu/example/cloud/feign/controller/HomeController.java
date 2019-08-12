package com.liu.example.cloud.feign.controller;

import com.liu.example.cloud.feign.api.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    private UserClient userClient;

    @RequestMapping("/api/user/hello")
    public String getUserInfo(@RequestParam String userName) {
        String s = userClient.sayHello(userName);
        return s;
    }
}
