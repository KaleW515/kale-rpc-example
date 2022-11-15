package com.kalew515.example.client.controller;

import com.kalew515.common.annotation.RpcReference;
import com.kalew515.example.pojo.Hello;
import com.kalew515.example.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RpcReference(version = "version1", group = "spring")
    private HelloService helloService;

    @GetMapping("/hello/{word}")
    public String hello (@PathVariable("word") String word) {
        String res = helloService.sayHello(new Hello(word, word));
        return res;
    }
}
