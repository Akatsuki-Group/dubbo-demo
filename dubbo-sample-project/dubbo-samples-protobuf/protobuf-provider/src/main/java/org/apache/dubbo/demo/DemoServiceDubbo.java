
    package org.apache.dubbo.demo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicBoolean;

@javax.annotation.Generated(
value = "by Dubbo generator",
comments = "Source: DemoService.proto")
public final class DemoServiceDubbo {
private static final AtomicBoolean registered = new AtomicBoolean();

private static Class<?> init() {
Class<?> clazz = null;
try {
clazz = Class.forName(DemoServiceDubbo.class.getName());
if (registered.compareAndSet(false, true)) {
    org.apache.dubbo.common.serialize.protobuf.support.ProtobufUtils.marshaller(
    HelloReply.getDefaultInstance());
    org.apache.dubbo.common.serialize.protobuf.support.ProtobufUtils.marshaller(
    HelloRequest.getDefaultInstance());
}
} catch (ClassNotFoundException e) {
// ignore
}
return clazz;
}

private DemoServiceDubbo() {}

public static final String SERVICE_NAME = "org.apache.dubbo.demo.DemoService";

/**
* Code generated for Dubbo
*/
public interface IDemoService {

static Class<?> clazz = init();

    HelloReply sayHello(HelloRequest request);

    CompletableFuture<HelloReply> sayHelloAsync(HelloRequest request);


}

}
