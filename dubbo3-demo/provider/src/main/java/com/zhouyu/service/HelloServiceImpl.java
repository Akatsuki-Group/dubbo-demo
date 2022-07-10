package com.zhouyu.service;

import org.apache.dubbo.config.annotation.DubboService;

@DubboService(protocol = "rest")
public class HelloServiceImpl implements HelloService{

    @Override
    public String hello() {
        return "dubbo hello";
    }
}
