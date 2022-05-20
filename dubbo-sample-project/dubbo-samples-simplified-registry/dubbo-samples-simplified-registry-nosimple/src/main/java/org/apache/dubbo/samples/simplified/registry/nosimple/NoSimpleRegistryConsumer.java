package org.apache.dubbo.samples.simplified.registry.nosimple;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.samples.simplified.registry.nosimple.api.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.apache.dubbo.common.constants.CommonConstants.RELEASE_KEY;

public class NoSimpleRegistryConsumer {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/simplified-consumer.xml");
        context.start();

        DemoService demoService = context.getBean("demoService", DemoService.class);

        printServiceData();

        String hello = demoService.sayHello("world");
        System.out.println(hello);
    }

    private static void printServiceData() {
        List<String> urls = ZkUtil.getChildren(ZkUtil.toUrlPath("consumers"));
        System.out.println("*********************************************************");
        urls.stream().map(URL::decode).forEach(System.out::println);
        System.out.println("contains 'retries':" + urls.get(0).contains("retries"));
        System.out.println("contains 'owner':" + urls.get(0).contains("owner"));
        System.out.println("contains 'actives':" + urls.get(0).contains("actives"));
        System.out.println("contains 'timeout':" + urls.get(0).contains("timeout"));
        System.out.println("contains 'application':" + urls.get(0).contains("application"));
        System.out.println("contains 'version':" + urls.get(0).contains("version"));
        System.out.println("contains 'group':" + urls.get(0).contains("group"));
        System.out.println("contains 'specVersion(default)':" + urls.get(0).contains(RELEASE_KEY));
        System.out.println("*********************************************************");
    }
}