package com.kalew515.example.server;

import com.kalew515.common.annotation.EnableKaleRpc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableKaleRpc
public class NettyExampleServer {

    public static void main (String[] args) {
        SpringApplication.run(NettyExampleServer.class);
    }
}
