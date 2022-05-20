package org.apache.dubbo.samples.api;

import org.apache.dubbo.rpc.RpcContext;
import org.apache.dubbo.samples.api.GroupService;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author tian
 */
public class GroupAServiceImpl implements GroupService {
    public String sayHello(String name) {
        System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "] Hello " + name +
                ", request from consumer: " + RpcContext.getContext().getRemoteAddress() + "in groupA");
        return "Hello " + name + ", response from provider: " + RpcContext.getContext().getLocalAddress() + " in group A";
    }
}
