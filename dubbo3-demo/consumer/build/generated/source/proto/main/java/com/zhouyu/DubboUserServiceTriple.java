    package com.zhouyu;

import org.apache.dubbo.common.stream.StreamObserver;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.PathResolver;
import org.apache.dubbo.rpc.RpcException;
import org.apache.dubbo.rpc.ServerService;
import org.apache.dubbo.rpc.TriRpcStatus;
import org.apache.dubbo.rpc.model.MethodDescriptor;
import org.apache.dubbo.rpc.model.ServiceDescriptor;
import org.apache.dubbo.rpc.model.StubMethodDescriptor;
import org.apache.dubbo.rpc.model.StubServiceDescriptor;
import org.apache.dubbo.rpc.stub.BiStreamMethodHandler;
import org.apache.dubbo.rpc.stub.ServerStreamMethodHandler;
import org.apache.dubbo.rpc.stub.StubInvocationUtil;
import org.apache.dubbo.rpc.stub.StubInvoker;
import org.apache.dubbo.rpc.stub.StubMethodHandler;
import org.apache.dubbo.rpc.stub.StubSuppliers;
import org.apache.dubbo.rpc.stub.UnaryStubMethodHandler;

import com.google.protobuf.Message;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.concurrent.CompletableFuture;

public final class DubboUserServiceTriple {

    public static final String SERVICE_NAME = UserService.SERVICE_NAME;

    private static final StubServiceDescriptor serviceDescriptor = new StubServiceDescriptor(SERVICE_NAME,UserService.class);

    static {
        StubSuppliers.addSupplier(SERVICE_NAME, i -> newStub((Invoker<UserService>) i));
        StubSuppliers.addSupplier(UserService.JAVA_SERVICE_NAME, i -> newStub((Invoker<UserService>) i));
        StubSuppliers.addDescriptor(SERVICE_NAME, serviceDescriptor);
        StubSuppliers.addDescriptor(UserService.JAVA_SERVICE_NAME, serviceDescriptor);
    }

    public static UserService newStub(Invoker<UserService> invoker) {
        return new UserServiceStub(invoker);
    }

    private static final StubMethodDescriptor getUserMethod = new StubMethodDescriptor("GetUser",
    com.zhouyu.UserRequest.class, com.zhouyu.User.class, serviceDescriptor, MethodDescriptor.RpcType.UNARY,
    obj -> ((Message) obj).toByteArray(), obj -> ((Message) obj).toByteArray(), com.zhouyu.UserRequest::parseFrom,
    com.zhouyu.User::parseFrom);




    public static class UserServiceStub implements UserService{
        private final Invoker<UserService> invoker;

        public UserServiceStub(Invoker<UserService> invoker) {
            this.invoker = invoker;
        }

        @Override
        public com.zhouyu.User getUser(com.zhouyu.UserRequest request){
            return StubInvocationUtil.unaryCall(invoker, getUserMethod, request);
        }

        @Override
        public void getUser(com.zhouyu.UserRequest request, StreamObserver<com.zhouyu.User> responseObserver){
            StubInvocationUtil.unaryCall(invoker, getUserMethod , request, responseObserver);
        }



    }

    public static abstract class UserServiceImplBase implements UserService, ServerService<UserService> {

        @Override
        public final Invoker<UserService> getInvoker(URL url) {
            PathResolver pathResolver = url.getOrDefaultFrameworkModel()
            .getExtensionLoader(PathResolver.class)
            .getDefaultExtension();
            Map<String,StubMethodHandler<?, ?>> handlers = new HashMap<>();

            pathResolver.addNativeStub( "/" + SERVICE_NAME + "/GetUser" );

            BiConsumer<com.zhouyu.UserRequest, StreamObserver<com.zhouyu.User>> getUserFunc = this::getUser;
            handlers.put(getUserMethod.getMethodName(), new UnaryStubMethodHandler<>(getUserFunc));




            return new StubInvoker<>(this, url, UserService.class, handlers);
        }


        @Override
        public com.zhouyu.User getUser(com.zhouyu.UserRequest request){
            throw unimplementedMethodException(getUserMethod);
        }





        @Override
        public final ServiceDescriptor getServiceDescriptor() {
            return serviceDescriptor;
        }
        private RpcException unimplementedMethodException(StubMethodDescriptor methodDescriptor) {
            return TriRpcStatus.UNIMPLEMENTED.withDescription(String.format("Method %s is unimplemented",
                "/" + serviceDescriptor.getInterfaceName() + "/" + methodDescriptor.getMethodName())).asException();
        }
    }

}
