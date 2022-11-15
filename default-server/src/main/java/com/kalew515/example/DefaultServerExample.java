package com.kalew515.example;

import com.kalew515.config.RpcServiceConfig;
import com.kalew515.example.service.HelloService;
import com.kalew515.transport.RpcServer;
import com.kalew515.transport.RpcServerFactory;

public class DefaultServerExample {
    public static void main (String[] args) {
        RpcServer rpcServer = RpcServerFactory.getRpcServer();

        RpcServiceConfig<HelloService> rpcServiceConfig = new RpcServiceConfig<>();
        rpcServiceConfig.setVersion("version1");
        rpcServiceConfig.setGroup("default");
        rpcServiceConfig.setService(new HelloServiceImpl());
        rpcServiceConfig.setClazz(HelloService.class);

        rpcServer.registerService(rpcServiceConfig);

        rpcServer.start();
    }
}