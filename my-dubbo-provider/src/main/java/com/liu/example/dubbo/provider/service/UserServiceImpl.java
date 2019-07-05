package com.liu.example.dubbo.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.liu.example.dubbo.service.UserService;

// 注册为 Dubbo 服务
@Service(version = "1.0.0")
public class UserServiceImpl implements UserService {


    @Override
    public String getUserName() {
        return "liuchaoyang";
    }
}
