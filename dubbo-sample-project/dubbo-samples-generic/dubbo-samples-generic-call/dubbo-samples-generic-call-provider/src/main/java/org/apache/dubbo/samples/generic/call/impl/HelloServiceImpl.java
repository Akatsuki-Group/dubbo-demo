package org.apache.dubbo.samples.generic.call.impl;

import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.samples.generic.call.api.GenericType;
import org.apache.dubbo.samples.generic.call.api.HelloService;
import org.apache.dubbo.samples.generic.call.api.Person;

import java.util.concurrent.CompletableFuture;

/**
 * @author tian
 */
@DubboService
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return "sayHello: " + name;
    }

    @Override
    public CompletableFuture<String> sayHelloAsync(String name) {
        CompletableFuture<String> future = new CompletableFuture<>();
        new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            future.complete("sayHelloAsync: " + name);
        }).start();
        return future;
    }

    @Override
    public CompletableFuture<Person> sayHelloAsyncComplex(String name) {
        Person person = new Person(1, "sayHelloAsyncComplex: " + name);
        CompletableFuture<Person> future = new CompletableFuture<>();
        new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            future.complete(person);
        }).start();

        return future;
    }

    @Override
    public CompletableFuture<GenericType<Person>> sayHelloAsyncGenericComplex(String name) {
        Person person = new Person(1, "sayHelloAsyncGenericComplex: " + name);
        GenericType<Person> genericType = new GenericType<>(person);
        CompletableFuture<GenericType<Person>> future = new CompletableFuture<>();
        new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            future.complete(genericType);
        }).start();

        return future;
    }
}
