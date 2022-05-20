package org.apache.dubbo.samples.api.impl;

import org.apache.dubbo.rpc.RpcContext;
import org.apache.dubbo.samples.api.DemoService;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author tian
 */
public class DemoServiceImpl implements DemoService {
    @Override
     public String sayHello(String name){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "] Hello " + name +
                ", request from consumer: " + RpcContext.getContext().getRemoteAddress());
        return "Hello " + name + ", response from provider: " + RpcContext.getContext().getLocalAddress();
    }
}
