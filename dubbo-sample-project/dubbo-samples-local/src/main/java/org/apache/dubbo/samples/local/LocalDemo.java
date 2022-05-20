package org.apache.dubbo.samples.local;

import org.apache.dubbo.samples.local.api.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.CountDownLatch;

/**
 * @author tian
 */
public class LocalDemo {
    public static void main(String[] args) throws InterruptedException{
        new EmbeddedZooKeeper(2181,true).start();
        ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring/dubbo-demo.xml");
        applicationContext.start();
        System.out.println("dubbo service started......");
        DemoService demoService = applicationContext.getBean("demoService",DemoService.class);
        String world = demoService.sayHello("world");
        System.out.println(world);
        new CountDownLatch(1).await();
//        System.in.read();
    }
}
