package com.liu.example.dubbo.provider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/index")
    public String greeting() {
        return "hello, i'm dubbo provider!";
    }
}
