package org.apache.dubbo.samples.loadbalance.impl;

import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.rpc.RpcContext;
import org.apache.dubbo.samples.loadbalance.api.DemoService;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author tian
 */
@DubboService(version = "default")
public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String hello) {
        System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "] Hello " + hello +
                ", request from consumer: " + RpcContext.getContext().getRemoteAddress());
        return "Hello " + hello + ", response from provider: " + RpcContext.getContext().getLocalAddress();
    }
}
