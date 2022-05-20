package org.apache.dubbo.samples.simplified.annotation;

import org.apache.dubbo.config.ProviderConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.apache.dubbo.common.URL;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import static org.apache.dubbo.common.constants.CommonConstants.RELEASE_KEY;

public class SimpleRegistryAnnotationProvider {

    public static void main(String[] args) throws Exception {
        new EmbeddedZooKeeper(2181, false).start();

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProviderConfiguration.class);
        context.start();

        printServiceData();

        System.out.println("dubbo service started");
        new CountDownLatch(1).await();
    }

    @Configuration
    @EnableDubbo(scanBasePackages = "org.apache.dubbo.samples.simplified.annotation.impl")
    @PropertySource("classpath:/spring/dubbo-provider.properties")
    static public class ProviderConfiguration {
        @Value("zookeeper://${zookeeper.address:127.0.0.1}:${zookeeper.port:2181}")
        private String zookeeperAddress;

        @Bean
        public ProviderConfig providerConfig() {
            ProviderConfig providerConfig = new ProviderConfig();
            providerConfig.setTimeout(1000);
            return providerConfig;
        }

        @Bean
        public RegistryConfig registryConfig() {
            RegistryConfig registryConfig = new RegistryConfig();
            registryConfig.setAddress(zookeeperAddress);
            registryConfig.setSimplified(true);
            registryConfig.setExtraKeys("retries,owner");
            return registryConfig;
        }
    }

    private static void printServiceData() {
        List<String> urls = ZkUtil.getChildren(ZkUtil.toUrlPath("providers"));
        System.out.println("*********************************************************");
        urls.stream().map(URL::decode).forEach(System.out::println);
        System.out.println("not contains 'executes':" + !urls.get(0).contains("executes"));
        System.out.println("contains 'retries':" + urls.get(0).contains("retries"));
        System.out.println("contains 'owner':" + urls.get(0).contains("owner"));
        System.out.println("contains 'timeout(default)':" + urls.get(0).contains("timeout"));
        System.out.println("contains 'version(default)':" + urls.get(0).contains("version"));
        System.out.println("contains 'group(default)':" + urls.get(0).contains("group"));
        System.out.println("contains 'specVersion(default)':" + urls.get(0).contains(RELEASE_KEY));
        System.out.println("*********************************************************");
    }
}
