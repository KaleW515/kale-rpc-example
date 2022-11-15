# kale-rpc-example
kale-rpc examples

## 在spring boot中使用

### server端

- 启动类，使用`@EnableKaleRpc`注解即可使用kale-rpc

```java
@SpringBootApplication
@EnableKaleRpc
public class NettyExampleServer {

    public static void main (String[] args) {
        SpringApplication.run(NettyExampleServer.class);
    }
}
```

- 服务类，用`@RpcService`注解标识的类为服务类

```java
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
```

- 支持配置，kale-rpc支持大量配置，如果不更改则为默认配置，优先读取spring boot的application.yml或者application.properties等配置，次优先级读取rpc.yml配置文件

```yaml
kale-rpc:
  transporter: netty
  server:
    port: 12800
    mq: local
    mq-address: 172.21.0.10:9876
  register-center:
    name: zk
    address: 127.0.0.1:2181
```

### client端

- 启动类

```java
@SpringBootApplication
public class NettyExampleClient {

    public static void main (String[] args) {
        SpringApplication.run(NettyExampleClient.class);
    }
}
```

- 服务引用类

```java
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
```

## 原生用法

### server端

```java
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
```

### client端

```java
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
```

