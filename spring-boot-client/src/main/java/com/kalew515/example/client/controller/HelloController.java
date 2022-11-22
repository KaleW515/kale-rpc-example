package com.kalew515.example.client.controller;

import com.kalew515.common.annotation.RpcReference;
import com.kalew515.example.pojo.Hello;
import com.kalew515.example.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RpcReference(version = "version1", group = "spring")
    private HelloService helloService;

    @PostMapping("/hello")
    public String hello (@RequestBody Hello hello) {
        return helloService.sayHello(hello);
    }
}
