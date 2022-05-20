package org.apache.dubbo.samples.notice.api;

public interface HelloService {

    String sayHello(String name);

    default String sayGoodbye(String name) {
        return "Goodbye, " + name;
    }
}