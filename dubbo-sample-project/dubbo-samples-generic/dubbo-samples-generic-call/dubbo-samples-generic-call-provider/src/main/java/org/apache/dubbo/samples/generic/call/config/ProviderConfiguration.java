package org.apache.dubbo.samples.generic.call.config;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author tian
 */
@Configuration
@EnableDubbo(scanBasePackages = "org.apache.dubbo.samples.generic.call.impl")
@PropertySource("classpath:/spring/dubbo-provider.properties")
public class ProviderConfiguration {
}
