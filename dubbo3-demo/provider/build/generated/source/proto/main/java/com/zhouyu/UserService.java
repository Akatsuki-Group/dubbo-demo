package com.zhouyu;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicBoolean;

public interface UserService {

    static final String JAVA_SERVICE_NAME = "com.zhouyu.UserService";
    static final String SERVICE_NAME = "api.UserService";

    // FIXME, initialize Dubbo3 stub when interface loaded, thinking of new ways doing this.
    static final boolean inited = UserServiceDubbo.init();

    com.zhouyu.User getUser(com.zhouyu.UserRequest request);

    default CompletableFuture<com.zhouyu.User> getUserAsync(com.zhouyu.UserRequest request){
        return CompletableFuture.supplyAsync(() -> getUser(request));
    }




}
