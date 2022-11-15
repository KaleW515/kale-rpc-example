package com.kalew515.example;

import com.kalew515.example.pojo.Hello;
import com.kalew515.example.service.HelloService;

public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello (Hello hello) {
        return hello.getDescription();
    }
}
