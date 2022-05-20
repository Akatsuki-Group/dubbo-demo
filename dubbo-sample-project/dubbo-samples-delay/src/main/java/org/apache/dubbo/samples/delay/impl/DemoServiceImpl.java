package org.apache.dubbo.samples.delay.impl;

import org.apache.dubbo.samples.delay.api.DemoService;

public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello(String name) {
        return "greeting " + name;
    }
}