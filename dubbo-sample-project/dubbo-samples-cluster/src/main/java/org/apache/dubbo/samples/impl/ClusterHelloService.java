package org.apache.dubbo.samples.impl;

import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.rpc.RpcContext;
import org.apache.dubbo.samples.api.HelloService;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author tian
 */
@DubboService(version = "cluster")
public class ClusterHelloService implements HelloService {
    @Override
    public String sayHello(String name) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "] Hello " + name +
                ", request from consumer: " + RpcContext.getContext().getRemoteAddress());
        return "Hello " + name + ", response from provider: " + RpcContext.getContext().getLocalAddress();
    }
}
