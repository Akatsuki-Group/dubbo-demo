1.使用注解的方式配置dubbo

## Provider Configuration
```Java
@Configuration
@EnableDubbo(scanBasePackages = "org.apache.dubbo.samples.annotation.impl")
@PropertySource("classpath:/spring/dubbo-provider.properties")
static class ProviderConfiguration {
}
``` 
' @EnableDubbo '将启用Spring 'impl ' package来查找任何被Dubbo注释的东西。
作为提供者，接口实现类必须用' @Service '进行注释:

```Java
@Service
public class AnnotatedGreetingService implements GreetingService {

    public String sayHello(String name) {
        System.out.println("greeting service received: " + name);
        return "hello, " + name;
    }

}
```
## Consumer Configuration

```Java
@Configuration
@EnableDubbo(scanBasePackages = "org.apache.dubbo.samples.annotation.action")
@PropertySource("classpath:/spring/dubbo-consumer.properties")
@ComponentScan(value = {"org.apache.dubbo.samples.annotation.action"})
static class ConsumerConfiguration {

}
```

可以通过`@Reference`注入服务提供者到消费者的服务中
```Java
@Component("annotatedConsumer")
public class GreetingServiceConsumer {

    @Reference
    private GreetingService greetingService;
    
}
```