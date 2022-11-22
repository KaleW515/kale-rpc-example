package com.kalew515.example;

import com.kalew515.config.RpcServiceConfig;
import com.kalew515.example.pojo.Hello;
import com.kalew515.example.service.HelloService;
import com.kalew515.proxy.RpcClientProxyFactory;

public class DefaultClientExample {
    public static void main (String[] args) {
        RpcServiceConfig<HelloService> rpcServiceConfig = new RpcServiceConfig<>();
        rpcServiceConfig.setVersion("version1");
        rpcServiceConfig.setGroup("default");
        rpcServiceConfig.setClazz(HelloService.class);

        HelloService proxy = RpcClientProxyFactory.getProxy(rpcServiceConfig);
        System.out.println(proxy.sayHello(new Hello("hello", "this is a hello msg")));
    }
}