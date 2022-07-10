    package com.zhouyu;

import org.apache.dubbo.common.stream.StreamObserver;
import com.google.protobuf.Message;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.concurrent.CompletableFuture;

public interface UserService {

    static final String JAVA_SERVICE_NAME = "com.zhouyu.UserService";
    static final String SERVICE_NAME = "com.zhouyu.UserService";

    com.zhouyu.User getUser(com.zhouyu.UserRequest request);

    default CompletableFuture<com.zhouyu.User> getUserAsync(com.zhouyu.UserRequest request){
        return CompletableFuture.completedFuture(getUser(request));
    }

    /**
    * This server stream type unary method is <b>only</b> used for generated stub to support async unary method.
    * It will not be called if you are NOT using Dubbo3 generated triple stub and <b>DO NOT</b> implement this method.
    */
    default void getUser(com.zhouyu.UserRequest request, StreamObserver<com.zhouyu.User> responseObserver){
        getUserAsync(request).whenComplete((r, t) -> {
            if (t != null) {
                responseObserver.onError(t);
            } else {
                responseObserver.onNext(r);
                responseObserver.onCompleted();
            }
        });
    }






}
