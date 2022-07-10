package com.zhouyu;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.Iterator;

public class HelloClient {

    public static void main(String[] args) throws IOException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8008).usePlaintext().build();

        // 非阻塞调用
        UserServiceGrpc.UserServiceStub userServiceStub = UserServiceGrpc.newStub(channel);
        // 阻塞调用
        UserServiceGrpc.UserServiceBlockingStub userServiceBlockingStub = UserServiceGrpc.newBlockingStub(channel);

        // 非阻塞，利用StreamObserver来处理响应结果
        userServiceStub.getUser(UserRequest.newBuilder().build(), new ResponseStreamObserver());
        // 阻塞调用
        User user = userServiceBlockingStub.getUser(UserRequest.newBuilder().build());
        System.out.println(user);

        // 非阻塞，利用StreamObserver来处理响应结果
        userServiceStub.serverGetUser(UserRequest.newBuilder().build(), new ResponseStreamObserver());
        // 阻塞，等待响应结果发送结束
        Iterator<User> userIterator = userServiceBlockingStub.serverGetUser(UserRequest.newBuilder().build());
        while (userIterator.hasNext()) {
            System.out.println(userIterator.next());
        }

        // 非阻塞双端流
        StreamObserver<UserRequest> userRequestStreamObserver = userServiceStub.biGetUser(new ResponseStreamObserver());
        userRequestStreamObserver.onNext(UserRequest.newBuilder().setUid("111").build());
        userRequestStreamObserver.onCompleted();
        // 没有对应的阻塞方式
    }

    static class ResponseStreamObserver implements StreamObserver<User>{

        @Override
        public void onNext(User user) {
            System.out.println("接收响应结果"+user);
        }

        @Override
        public void onError(Throwable throwable) {
            System.out.println("出错了"+throwable);
        }

        @Override
        public void onCompleted() {
            System.out.println("响应结束");
        }
    }
}
