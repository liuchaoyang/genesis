package com.liu.example.cloud.feign.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "my-feign", url = "http://localhost:8091")
public interface UserClient {

    @RequestMapping("/user/hello")
    String sayHello(@RequestParam String userName);

}
