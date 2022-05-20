package org.apache.dubbo.samples.generic.call.action;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.rpc.RpcContext;
import org.apache.dubbo.rpc.service.GenericService;
import org.apache.dubbo.samples.generic.call.api.HelloService;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;

/**
 * @author tian
 */
@Component(value = "action")
public class GenericAction {

    @DubboReference(id = "helloService",
            interfaceName = "org.apache.dubbo.samples.generic.call.api.HelloService",
            generic = true)
    private HelloService helloService;
}
