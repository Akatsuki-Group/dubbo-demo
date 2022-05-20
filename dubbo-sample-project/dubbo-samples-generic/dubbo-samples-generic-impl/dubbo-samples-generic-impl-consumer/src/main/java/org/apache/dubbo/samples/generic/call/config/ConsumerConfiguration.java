package org.apache.dubbo.samples.generic.call.config;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author tian
 */
@Configuration
@EnableDubbo(scanBasePackages = "org.apache.dubbo.samples.generic.call.action")
@PropertySource("classpath:/spring/dubbo-consumer.properties")
@ComponentScan(basePackages = "org.apache.dubbo.samples.generic.call.action")
public class ConsumerConfiguration {
}
