package com.zhouyu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
public class Provider {
    public static void main(String[] args) {
        SpringApplication.run(Provider.class, args);
    }

}
