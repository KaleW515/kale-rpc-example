package com.kalew515.example.server;

import com.kalew515.common.annotation.RpcService;
import com.kalew515.example.pojo.Hello;
import com.kalew515.example.service.HelloService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RpcService(version = "version1", group = "spring")
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello (Hello hello) {
        log.info("HelloServiceImpl收到: {}.", hello.getMessage());
        String result = "Hello description is " + hello.getDescription();
        log.info("HelloServiceImpl返回: {}.", result);
        return result;
    }
}
