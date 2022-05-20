package org.apache.dubbo.samples.loadbalance.config;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author tian
 */
@Configuration
@EnableDubbo(scanBasePackages = "org.apache.dubbo.samples.loadbalance.action")
@PropertySource(value = "classpath:/spring/dubbo-consumer.properties")
@ComponentScan(basePackages = "org.apache.dubbo.samples.loadbalance.action")
public class ConsumerConfiguration {
}
