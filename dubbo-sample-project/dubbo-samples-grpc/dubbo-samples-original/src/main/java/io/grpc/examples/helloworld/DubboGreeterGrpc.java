
package io.grpc.examples.helloworld;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.config.ReferenceConfigBase;

import java.util.concurrent.TimeUnit;

import static org.apache.dubbo.common.constants.CommonConstants.DEFAULT_TIMEOUT;
import static org.apache.dubbo.common.constants.CommonConstants.TIMEOUT_KEY;

import static io.grpc.examples.helloworld.GreeterGrpc.getServiceDescriptor;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

@javax.annotation.Generated(
        value = "by DubboGrpc generator",
        comments = "Source: helloworld.proto")
public final class DubboGreeterGrpc {
    private DubboGreeterGrpc() {
    }

    public static class DubboGreeterStub implements IGreeter {

        protected URL url;
        protected ReferenceConfigBase<?> referenceConfig;

        protected GreeterGrpc.GreeterBlockingStub blockingStub;
        protected GreeterGrpc.GreeterFutureStub futureStub;
        protected GreeterGrpc.GreeterStub stub;

        public DubboGreeterStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions, URL url, ReferenceConfigBase<?> referenceConfig) {
            this.url = url;
            this.referenceConfig = referenceConfig;

            blockingStub = GreeterGrpc.newBlockingStub(channel).build(channel, callOptions);
            futureStub = GreeterGrpc.newFutureStub(channel).build(channel, callOptions);
            stub = GreeterGrpc.newStub(channel).build(channel, callOptions);
        }

        /**
         * <pre>
         *  Sends a greeting
         * </pre>
         */
        public HelloReply sayHello(HelloRequest request) {
            return blockingStub
                    .withDeadlineAfter(url.getParameter(TIMEOUT_KEY, DEFAULT_TIMEOUT), TimeUnit.MILLISECONDS)
                    .sayHello(request);
        }

        public com.google.common.util.concurrent.ListenableFuture<HelloReply> sayHelloAsync(HelloRequest request) {
            return futureStub
                    .withDeadlineAfter(url.getParameter(TIMEOUT_KEY, DEFAULT_TIMEOUT), TimeUnit.MILLISECONDS)
                    .sayHello(request);
        }

        public void sayHello(HelloRequest request, io.grpc.stub.StreamObserver<HelloReply> responseObserver) {
            stub
                    .withDeadlineAfter(url.getParameter(TIMEOUT_KEY, DEFAULT_TIMEOUT), TimeUnit.MILLISECONDS)
                    .sayHello(request, responseObserver);
        }

    }

    public static DubboGreeterStub getDubboStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions, URL url, ReferenceConfigBase<?> referenceConfig) {
        return new DubboGreeterStub(channel, callOptions, url, referenceConfig);
    }

    public interface IGreeter {
        /**
         * <pre>
         *  Sends a greeting
         * </pre>
         */
        default public HelloReply sayHello(HelloRequest request) {
            throw new UnsupportedOperationException("No need to override this method, extend XxxImplBase and override all methods it allows.");
        }

        /**
         * <pre>
         *  Sends a greeting
         * </pre>
         */
        default public com.google.common.util.concurrent.ListenableFuture<HelloReply> sayHelloAsync(HelloRequest request) {
            throw new UnsupportedOperationException("No need to override this method, extend XxxImplBase and override all methods it allows.");
        }

        /**
         * <pre>
         *  Sends a greeting
         * </pre>
         */
        public void sayHello(HelloRequest request, io.grpc.stub.StreamObserver<HelloReply> responseObserver);

    }

    /**
     * <pre>
     *  The greeting service definition.
     * </pre>
     */
    public static abstract class GreeterImplBase implements io.grpc.BindableService, IGreeter {

        private IGreeter proxiedImpl;

        public final void setProxiedImpl(IGreeter proxiedImpl) {
            this.proxiedImpl = proxiedImpl;
        }

        /**
         * <pre>
         *  Sends a greeting
         * </pre>
         */
        @Override
        public final HelloReply sayHello(HelloRequest request) {
            throw new UnsupportedOperationException("No need to override this method, extend XxxImplBase and override all methods it allows.");
        }

        /**
         * <pre>
         *  Sends a greeting
         * </pre>
         */
        @Override
        public final com.google.common.util.concurrent.ListenableFuture<HelloReply> sayHelloAsync(HelloRequest request) {
            throw new UnsupportedOperationException("No need to override this method, extend XxxImplBase and override all methods it allows.");
        }

        public void sayHello(HelloRequest request,
                             io.grpc.stub.StreamObserver<HelloReply> responseObserver) {
            asyncUnimplementedUnaryCall(GreeterGrpc.getSayHelloMethod(), responseObserver);
        }

        @Override
        public final io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                    .addMethod(
                            GreeterGrpc.getSayHelloMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            HelloRequest,
                                            HelloReply>(
                                            proxiedImpl, METHODID_SAY_HELLO)))
                    .build();
        }
    }

    private static final int METHODID_SAY_HELLO = 0;

    private static final class MethodHandlers
            <Req, Resp> implements
            io.grpc.stub.ServerCalls.UnaryMethod
                    <Req, Resp>,
            io.grpc.stub.ServerCalls.ServerStreamingMethod
                    <Req, Resp>,
            io.grpc.stub.ServerCalls.ClientStreamingMethod
                    <Req, Resp>,
            io.grpc.stub.ServerCalls.BidiStreamingMethod
                    <Req, Resp> {
        private final IGreeter serviceImpl;
        private final int methodId;

        MethodHandlers(IGreeter serviceImpl, int methodId) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
        }

        @Override
        @SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver
                <Resp> responseObserver) {
            switch (methodId) {
                case METHODID_SAY_HELLO:
                    serviceImpl.sayHello((HelloRequest) request,
                            (io.grpc.stub.StreamObserver<HelloReply>) responseObserver);
                    break;
                default:
                    throw new AssertionError();
            }
        }

        @Override
        @SuppressWarnings("unchecked")
        public io.grpc.stub.StreamObserver
                <Req> invoke(io.grpc.stub.StreamObserver
                                     <Resp> responseObserver) {
            switch (methodId) {
                default:
                    throw new AssertionError();
            }
        }
    }

}
