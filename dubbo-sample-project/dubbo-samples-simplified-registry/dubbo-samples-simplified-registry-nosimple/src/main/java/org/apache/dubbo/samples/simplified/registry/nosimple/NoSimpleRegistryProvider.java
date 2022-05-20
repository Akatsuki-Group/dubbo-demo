package org.apache.dubbo.samples.simplified.registry.nosimple;

import org.apache.dubbo.common.URL;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.concurrent.CountDownLatch;

import static org.apache.dubbo.common.constants.CommonConstants.RELEASE_KEY;

public class NoSimpleRegistryProvider {

    public static void main(String[] args) throws Exception {
        new EmbeddedZooKeeper(2181, false).start();

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/simplified-provider.xml");
        context.start();

        printServiceData();

        System.out.println("dubbo service started");
        new CountDownLatch(1).await();
    }

    private static void printServiceData() {
        List<String> urls = ZkUtil.getChildren(ZkUtil.toUrlPath("providers"));
        System.out.println("*********************************************************");
        urls.stream().map(URL::decode).forEach(System.out::println);
        System.out.println("contains 'executes':" + urls.get(0).contains("executes"));
        System.out.println("contains 'retries':" + urls.get(0).contains("retries"));
        System.out.println("contains 'owner':" + urls.get(0).contains("owner"));
        System.out.println("contains 'timeout(default)':" + urls.get(0).contains("timeout"));
        System.out.println("contains 'version(default)':" + urls.get(0).contains("version"));
        System.out.println("contains 'group(default)':" + urls.get(0).contains("group"));
        System.out.println("contains 'specVersion(default)':" + urls.get(0).contains(RELEASE_KEY));
        System.out.println("*********************************************************");
    }
}