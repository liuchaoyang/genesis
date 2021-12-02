package com.liu.example.cloud.feign.api;

import org.springframework.stereotype.Service;

@Service
public class UserClientImpl implements UserClient {
    @Override
    public String sayHello(String userName) {
        return "user is not existed in the system.";
    }
}
