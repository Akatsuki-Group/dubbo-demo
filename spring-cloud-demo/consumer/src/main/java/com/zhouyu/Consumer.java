package com.zhouyu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Consumer {

//    @Bean
//    @LoadBalanced
//    public RestTemplate restTemplate(){
//        return new RestTemplate();
//    }

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(Consumer.class, args);

//        RestTemplate restTemplate = applicationContext.getBean(RestTemplate.class);
//        String result = restTemplate.getForObject("http://spring-cloud-provider-application" + "/hello", String.class);
//        System.out.println(result);

        HelloService helloService = applicationContext.getBean(HelloService.class);
        String result = helloService.hello();
        System.out.println(result);


    }
}
