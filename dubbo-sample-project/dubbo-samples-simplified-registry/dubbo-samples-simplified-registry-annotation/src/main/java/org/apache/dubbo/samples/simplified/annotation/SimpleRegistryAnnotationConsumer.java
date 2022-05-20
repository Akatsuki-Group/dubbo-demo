package org.apache.dubbo.samples.simplified.annotation;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.apache.dubbo.samples.simplified.annotation.action.AnnotationAction;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import java.util.List;

import static org.apache.dubbo.common.constants.CommonConstants.RELEASE_KEY;

public class SimpleRegistryAnnotationConsumer {

    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConsumerConfiguration.class);
        context.start();

        AnnotationAction annotationAction = context.getBean("annotationAction", AnnotationAction.class);
        printServiceData();

        String hello = annotationAction.doSayHello("world");
        System.out.println("result :" + hello);
    }

    @Configuration
    @EnableDubbo(scanBasePackages = "org.apache.dubbo.samples.simplified.annotation.action")
    @PropertySource("classpath:/spring/dubbo-consumer.properties")
    @ComponentScan(value = {"org.apache.dubbo.samples.simplified.annotation.action"})
    static public class ConsumerConfiguration {
        @Value("zookeeper://${zookeeper.address:127.0.0.1}:${zookeeper.port:2181}")
        private String zookeeperAddress;

        @Bean
        public RegistryConfig registryConfig() {
            RegistryConfig registryConfig = new RegistryConfig();
            registryConfig.setAddress(zookeeperAddress);
            registryConfig.setSimplified(true);
            return registryConfig;
        }
    }

    private static void printServiceData() {
        List<String> urls = ZkUtil.getChildren(ZkUtil.toUrlPath("consumers"));
        System.out.println("*********************************************************");
        urls.stream().map(URL::decode).forEach(System.out::println);
        System.out.println("not contains 'retries':" + !urls.get(0).contains("retries"));
        System.out.println("not contains 'owner':" + !urls.get(0).contains("owner"));
        System.out.println("not contains 'actives':" + !urls.get(0).contains("actives"));
        System.out.println("not contains 'timeout':" + !urls.get(0).contains("timeout"));
        System.out.println("contains 'application':" + urls.get(0).contains("application"));
        System.out.println("contains 'version':" + urls.get(0).contains("version"));
        System.out.println("contains 'group':" + urls.get(0).contains("group"));
        System.out.println("contains 'specVersion(default)':" + urls.get(0).contains(RELEASE_KEY));
        System.out.println("*********************************************************");
    }
}