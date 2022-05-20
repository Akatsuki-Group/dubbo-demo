package com.tuling.consumer;

import com.tuling.DemoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

@Component
public class Action {
    @Reference(version = "generic", loadbalance = "consistenthash")
    private DemoService demoService;
}
