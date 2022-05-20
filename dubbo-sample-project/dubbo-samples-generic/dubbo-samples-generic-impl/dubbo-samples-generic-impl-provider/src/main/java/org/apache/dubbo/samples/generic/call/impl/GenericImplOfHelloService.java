package org.apache.dubbo.samples.generic.call.impl;

import org.apache.dubbo.rpc.service.GenericException;
import org.apache.dubbo.rpc.service.GenericService;

import java.util.concurrent.CompletableFuture;

public class GenericImplOfHelloService implements GenericService {
    @Override
    public Object $invoke(String method, String[] parameterTypes, Object[] args) throws GenericException {
        if (method.equals("sayHello")) {
            System.out.print("executing sayHello.");
            throw new RuntimeException("sayHello: throws exception");
        } else if (method.equals("sayHelloAsync")) {
            System.out.print("executing sayHelloAsync.");
            return CompletableFuture.completedFuture("sayHelloAsync: hello " + args[0]);
        } else {
            try {
                return defaultOperation(method, parameterTypes, args);
            } catch (Exception e) {
                throw new GenericException(e);
            }
        }
    }

    private Object defaultOperation(String method, String[] parameterTypes, Object[] args) throws Exception {
        throw new UnsupportedOperationException("method does not exist.");
    }
}