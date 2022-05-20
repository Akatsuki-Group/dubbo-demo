package org.apache.dubbo.samples.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.CountDownLatch;

/**
 * @author tian
 */
public class Provider {
    public static void main(String[] args) throws InterruptedException {
        new EmbeddedZooKeeper(2181, false).start();
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/provider.xml");
        context.start();
        System.out.println("dubbo service started");
        new CountDownLatch(1).await();
    }
}
