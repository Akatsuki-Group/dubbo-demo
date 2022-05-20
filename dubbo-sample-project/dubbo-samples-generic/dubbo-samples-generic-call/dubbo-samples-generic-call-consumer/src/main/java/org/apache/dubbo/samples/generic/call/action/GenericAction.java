package org.apache.dubbo.samples.generic.call.action;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.rpc.RpcContext;
import org.apache.dubbo.rpc.service.GenericService;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;

/**
 * @author tian
 */
@Component(value = "action")
public class GenericAction {

    @DubboReference(id = "genericService",
            interfaceName = "org.apache.dubbo.samples.generic.call.api.HelloService",
            generic = true)
    private GenericService genericService;

    public void invokeSayHello() throws InterruptedException {
        Object result = genericService.$invoke("sayHello", new String[]{"java.lang.String"}, new Object[]{"world"});
        CountDownLatch latch = new CountDownLatch(1);

        CompletableFuture<String> future = RpcContext.getContext().getCompletableFuture();
        future.whenComplete((value, t) -> {
            System.err.println("invokeSayHello(whenComplete): " + value);
            latch.countDown();
        });

        System.err.println("invokeSayHello(return): " + result);
        latch.await();
    }

    public void invokeSayHelloAsync() throws InterruptedException {
        Object result = genericService.$invoke("sayHelloAsync", new String[]{"java.lang.String"}, new Object[]{"world"});
        CountDownLatch latch = new CountDownLatch(1);

        CompletableFuture<String> future = RpcContext.getContext().getCompletableFuture();
        future.whenComplete((value, t) -> {
            System.err.println("invokeSayHelloAsync(whenComplete): " + value);
            latch.countDown();
        });

        System.err.println("invokeSayHelloAsync(return): " + result);
        latch.await();
    }

    public void invokeAsyncSayHelloAsync() throws Exception {
        CompletableFuture<Object> future = genericService.$invokeAsync("sayHelloAsync",
                new String[]{"java.lang.String"}, new Object[]{"world"});
        CountDownLatch latch = new CountDownLatch(1);
        future.whenComplete((value, t) -> {
            System.err.println("invokeAsyncSayHelloAsync(whenComplete): " + value);
            latch.countDown();
        });
        latch.await();
    }

    public void invokeAsyncSayHello() throws Exception {
        CompletableFuture<Object> future = genericService.$invokeAsync("sayHello",
                new String[]{"java.lang.String"}, new Object[]{"world"});
        CountDownLatch latch = new CountDownLatch(1);
        future.whenComplete((value, t) -> {
            System.err.println("invokeAsyncSayHello(whenComplete): " + value);
            latch.countDown();
        });
        latch.await();
    }

    public void invokeSayHelloAsyncComplex() throws Exception {
        Object result = genericService.$invoke("sayHelloAsyncComplex", new String[]{"java.lang.String"},
                new Object[]{"world"});
        CountDownLatch latch = new CountDownLatch(1);

        CompletableFuture<String> future = RpcContext.getContext().getCompletableFuture();
        future.whenComplete((value, t) -> {
            System.err.println("invokeSayHelloAsyncComplex(whenComplete): " + value);
            latch.countDown();
        });

        System.err.println("invokeSayHelloAsync(return): " + result);
        latch.await();
    }

    public void asyncInvokeSayHelloAsyncComplex() throws Exception {
        CompletableFuture<Object> future = genericService.$invokeAsync("sayHelloAsyncComplex",
                new String[]{"java.lang.String"}, new Object[]{"world"});
        CountDownLatch latch = new CountDownLatch(1);

        future.whenComplete((value, t) -> {
            System.err.println("asyncInvokeSayHelloAsyncComplex(whenComplete): " + value);
            latch.countDown();
        });

        latch.await();
    }

    public void invokeSayHelloAsyncGenericComplex() throws Exception {
        Object result = genericService.$invoke("sayHelloAsyncGenericComplex", new String[]{"java.lang.String"},
                new Object[]{"world"});
        CountDownLatch latch = new CountDownLatch(1);

        CompletableFuture<String> future = RpcContext.getContext().getCompletableFuture();
        future.whenComplete((value, t) -> {
            System.err.println("invokeSayHelloAsyncGenericComplex(whenComplete): " + value);
            latch.countDown();
        });

        System.err.println("invokeSayHelloAsyncGenericComplex(return): " + result);
        latch.await();
    }

    public void asyncInvokeSayHelloAsyncGenericComplex() throws Exception {
        CompletableFuture<Object> future = genericService.$invokeAsync("sayHelloAsyncGenericComplex",
                new String[]{"java.lang.String"}, new Object[]{"world"});
        CountDownLatch latch = new CountDownLatch(1);

        future.whenComplete((value, t) -> {
            System.err.println("asyncInvokeSayHelloAsyncGenericComplex(whenComplete): " + value);
            latch.countDown();
        });

        latch.await();
    }
}
