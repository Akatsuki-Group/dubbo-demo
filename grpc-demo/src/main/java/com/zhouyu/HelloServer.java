package com.zhouyu;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.logging.Logger;

public class HelloServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(8008).addService(new UserService()).build();
        server.start();
        server.awaitTermination();
    }

    private static class UserService extends UserServiceGrpc.UserServiceImplBase {

        @Override
        public void getUser(UserRequest request, StreamObserver<User> responseObserver) {
            responseObserver.onNext(User.newBuilder().setUid("1111").build());
            responseObserver.onCompleted();
        }

        @Override
        public void serverGetUser(UserRequest request, StreamObserver<User> responseObserver) {
            responseObserver.onNext(User.newBuilder().setUid("1111").build());
            responseObserver.onCompleted();
        }

        @Override
        public StreamObserver<UserRequest> clientGetUser(StreamObserver<User> responseObserver) {
            return new StreamObserver<UserRequest>() {
                @Override
                public void onNext(UserRequest userRequest) {
                    System.out.println("处理"+userRequest.getUid());
                    responseObserver.onNext(User.newBuilder().setUid("1111").build());
                }

                @Override
                public void onError(Throwable throwable) {
                    System.out.println("出错了"+throwable);
                }

                @Override
                public void onCompleted() {
                    System.out.println("数据接收完毕");
                    responseObserver.onNext(User.newBuilder().setUid("2222").build());
                    responseObserver.onCompleted();
                }
            };
        }

        @Override
        public StreamObserver<UserRequest> biGetUser(StreamObserver<User> responseObserver) {
            return clientGetUser(responseObserver);
        }
    }

}
