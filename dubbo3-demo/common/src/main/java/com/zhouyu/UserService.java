package com.zhouyu;

import org.apache.dubbo.common.stream.StreamObserver;

public interface UserService {

    public User getUser(String uid);

    StreamObserver<String> sayHelloStream(StreamObserver<String> response);

    void sayHelloServerStream(String request, StreamObserver<String> response);
}
