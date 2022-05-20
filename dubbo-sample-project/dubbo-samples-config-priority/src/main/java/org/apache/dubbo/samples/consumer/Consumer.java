package org.apache.dubbo.samples.consumer;

import org.apache.dubbo.samples.api.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.CountDownLatch;

/**
 * @author tian
 */
public class Consumer {
    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/consumer.xml");
        context.start();

        DemoService demoService = context.getBean("demoService", DemoService.class);
        String result = demoService.sayHello("world");
        System.out.println(result);
        new CountDownLatch(1).await();
    }
}
