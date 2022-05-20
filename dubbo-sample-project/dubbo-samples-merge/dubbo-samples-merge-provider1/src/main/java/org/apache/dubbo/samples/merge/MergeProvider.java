package org.apache.dubbo.samples.merge;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.CountDownLatch;

public class MergeProvider {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/merge-provider.xml");
        context.start();

        System.out.println("dubbo service started");
        new CountDownLatch(1).await();
    }

}