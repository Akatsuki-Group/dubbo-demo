
    package io.grpc.examples.routeguide;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.config.ReferenceConfigBase;

import java.util.concurrent.TimeUnit;

import static org.apache.dubbo.common.constants.CommonConstants.DEFAULT_TIMEOUT;
import static org.apache.dubbo.common.constants.CommonConstants.TIMEOUT_KEY;

import static io.grpc.examples.routeguide.RouteGuideGrpc.getServiceDescriptor;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

@javax.annotation.Generated(
value = "by DubboGrpc generator",
comments = "Source: route_guide.proto")
public final class DubboRouteGuideGrpc {
private DubboRouteGuideGrpc() {}

public static class DubboRouteGuideStub implements IRouteGuide {

protected URL url;
protected ReferenceConfigBase<?> referenceConfig;

protected RouteGuideGrpc.RouteGuideBlockingStub blockingStub;
protected RouteGuideGrpc.RouteGuideFutureStub futureStub;
protected RouteGuideGrpc.RouteGuideStub stub;

public DubboRouteGuideStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions, URL url, ReferenceConfigBase<?> referenceConfig) {
this.url = url;
this.referenceConfig = referenceConfig;

blockingStub = RouteGuideGrpc.newBlockingStub(channel).build(channel, callOptions);
futureStub = RouteGuideGrpc.newFutureStub(channel).build(channel, callOptions);
stub = RouteGuideGrpc.newStub(channel).build(channel, callOptions);
}

        /**
         * <pre>
         *  A simple RPC.
         * 
         *  Obtains the feature at a given position.
         * 
         *  A feature with an empty name is returned if there&#39;s no feature at the given
         *  position.
         * </pre>
         */
    public Feature getFeature(Point request) {
    return blockingStub
    .withDeadlineAfter(url.getParameter(TIMEOUT_KEY, DEFAULT_TIMEOUT), TimeUnit.MILLISECONDS)
    .getFeature(request);
    }

    public com.google.common.util.concurrent.ListenableFuture<Feature> getFeatureAsync(Point request) {
    return futureStub
    .withDeadlineAfter(url.getParameter(TIMEOUT_KEY, DEFAULT_TIMEOUT), TimeUnit.MILLISECONDS)
    .getFeature(request);
    }

    public void getFeature(Point request, io.grpc.stub.StreamObserver<Feature> responseObserver){
    stub
    .withDeadlineAfter(url.getParameter(TIMEOUT_KEY, DEFAULT_TIMEOUT), TimeUnit.MILLISECONDS)
    .getFeature(request, responseObserver);
    }

        /**
         * <pre>
         *  A server-to-client streaming RPC.
         * 
         *  Obtains the Features available within the given Rectangle.  Results are
         *  streamed rather than returned at once (e.g. in a response message with a
         *  repeated field), as the rectangle may cover a large area and contain a
         *  huge number of features.
         * </pre>
         */
    public java.util.Iterator<Feature> listFeatures(Rectangle request) {
    return blockingStub
    .withDeadlineAfter(url.getParameter(TIMEOUT_KEY, DEFAULT_TIMEOUT), TimeUnit.MILLISECONDS)
    .listFeatures(request);
    }

    public void listFeatures(Rectangle request, io.grpc.stub.StreamObserver<Feature> responseObserver) {
    stub
    .withDeadlineAfter(url.getParameter(TIMEOUT_KEY, DEFAULT_TIMEOUT), TimeUnit.MILLISECONDS)
    .listFeatures(request, responseObserver);
    }

        /**
         * <pre>
         *  A client-to-server streaming RPC.
         * 
         *  Accepts a stream of Points on a route being traversed, returning a
         *  RouteSummary when traversal is completed.
         * </pre>
         */
    public io.grpc.stub.StreamObserver<Point> recordRoute(io.grpc.stub.StreamObserver<RouteSummary> responseObserver) {
    return stub
    .withDeadlineAfter(url.getParameter(TIMEOUT_KEY, DEFAULT_TIMEOUT), TimeUnit.MILLISECONDS)
    .recordRoute(responseObserver);
    }
        /**
         * <pre>
         *  A Bidirectional streaming RPC.
         * 
         *  Accepts a stream of RouteNotes sent while a route is being traversed,
         *  while receiving other RouteNotes (e.g. from other users).
         * </pre>
         */
    public io.grpc.stub.StreamObserver<RouteNote> routeChat(io.grpc.stub.StreamObserver<RouteNote> responseObserver) {
    return stub
    .withDeadlineAfter(url.getParameter(TIMEOUT_KEY, DEFAULT_TIMEOUT), TimeUnit.MILLISECONDS)
    .routeChat(responseObserver);
    }
}

public static DubboRouteGuideStub getDubboStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions, URL url, ReferenceConfigBase<?> referenceConfig) {
return new DubboRouteGuideStub(channel, callOptions, url, referenceConfig);
}

public interface IRouteGuide {
        /**
         * <pre>
         *  A simple RPC.
         * 
         *  Obtains the feature at a given position.
         * 
         *  A feature with an empty name is returned if there&#39;s no feature at the given
         *  position.
         * </pre>
         */
    default public Feature getFeature(Point request) {
    throw new UnsupportedOperationException("No need to override this method, extend XxxImplBase and override all methods it allows.");
    }

        /**
         * <pre>
         *  A simple RPC.
         * 
         *  Obtains the feature at a given position.
         * 
         *  A feature with an empty name is returned if there&#39;s no feature at the given
         *  position.
         * </pre>
         */
    default public com.google.common.util.concurrent.ListenableFuture<Feature> getFeatureAsync(Point request) {
    throw new UnsupportedOperationException("No need to override this method, extend XxxImplBase and override all methods it allows.");
    }

        /**
         * <pre>
         *  A simple RPC.
         * 
         *  Obtains the feature at a given position.
         * 
         *  A feature with an empty name is returned if there&#39;s no feature at the given
         *  position.
         * </pre>
         */
    public void getFeature(Point request, io.grpc.stub.StreamObserver<Feature> responseObserver);

        /**
         * <pre>
         *  A server-to-client streaming RPC.
         * 
         *  Obtains the Features available within the given Rectangle.  Results are
         *  streamed rather than returned at once (e.g. in a response message with a
         *  repeated field), as the rectangle may cover a large area and contain a
         *  huge number of features.
         * </pre>
         */
    default public java.util.Iterator<Feature> listFeatures(Rectangle request) {
    throw new UnsupportedOperationException("No need to override this method, extend XxxImplBase and override all methods it allows.");
    }

        /**
         * <pre>
         *  A server-to-client streaming RPC.
         * 
         *  Obtains the Features available within the given Rectangle.  Results are
         *  streamed rather than returned at once (e.g. in a response message with a
         *  repeated field), as the rectangle may cover a large area and contain a
         *  huge number of features.
         * </pre>
         */
    public void listFeatures(Rectangle request, io.grpc.stub.StreamObserver<Feature> responseObserver);

        /**
         * <pre>
         *  A client-to-server streaming RPC.
         * 
         *  Accepts a stream of Points on a route being traversed, returning a
         *  RouteSummary when traversal is completed.
         * </pre>
         */
    public io.grpc.stub.StreamObserver<Point> recordRoute(io.grpc.stub.StreamObserver<RouteSummary> responseObserver);

        /**
         * <pre>
         *  A Bidirectional streaming RPC.
         * 
         *  Accepts a stream of RouteNotes sent while a route is being traversed,
         *  while receiving other RouteNotes (e.g. from other users).
         * </pre>
         */
    public io.grpc.stub.StreamObserver<RouteNote> routeChat(io.grpc.stub.StreamObserver<RouteNote> responseObserver);

}

    /**
     * <pre>
     *  Interface exported by the server.
     * </pre>
     */
public static abstract class RouteGuideImplBase implements io.grpc.BindableService, IRouteGuide {

private IRouteGuide proxiedImpl;

public final void setProxiedImpl(IRouteGuide proxiedImpl) {
this.proxiedImpl = proxiedImpl;
}

        /**
         * <pre>
         *  A simple RPC.
         * 
         *  Obtains the feature at a given position.
         * 
         *  A feature with an empty name is returned if there&#39;s no feature at the given
         *  position.
         * </pre>
         */
    @Override
    public final Feature getFeature(Point request) {
    throw new UnsupportedOperationException("No need to override this method, extend XxxImplBase and override all methods it allows.");
    }

        /**
         * <pre>
         *  A simple RPC.
         * 
         *  Obtains the feature at a given position.
         * 
         *  A feature with an empty name is returned if there&#39;s no feature at the given
         *  position.
         * </pre>
         */
    @Override
    public final com.google.common.util.concurrent.ListenableFuture<Feature> getFeatureAsync(Point request) {
    throw new UnsupportedOperationException("No need to override this method, extend XxxImplBase and override all methods it allows.");
    }

        /**
         * <pre>
         *  A server-to-client streaming RPC.
         * 
         *  Obtains the Features available within the given Rectangle.  Results are
         *  streamed rather than returned at once (e.g. in a response message with a
         *  repeated field), as the rectangle may cover a large area and contain a
         *  huge number of features.
         * </pre>
         */
    @Override
    public final java.util.Iterator<Feature> listFeatures(Rectangle request) {
    throw new UnsupportedOperationException("No need to override this method, extend XxxImplBase and override all methods it allows.");
    }

        public void getFeature(Point request,
                               io.grpc.stub.StreamObserver<Feature> responseObserver) {
        asyncUnimplementedUnaryCall(RouteGuideGrpc.getGetFeatureMethod(), responseObserver);
        }
        public void listFeatures(Rectangle request,
                                 io.grpc.stub.StreamObserver<Feature> responseObserver) {
        asyncUnimplementedUnaryCall(RouteGuideGrpc.getListFeaturesMethod(), responseObserver);
        }
        public io.grpc.stub.StreamObserver<Point> recordRoute(
        io.grpc.stub.StreamObserver<RouteSummary> responseObserver) {
        return asyncUnimplementedStreamingCall(RouteGuideGrpc.getRecordRouteMethod(), responseObserver);
        }
        public io.grpc.stub.StreamObserver<RouteNote> routeChat(
        io.grpc.stub.StreamObserver<RouteNote> responseObserver) {
        return asyncUnimplementedStreamingCall(RouteGuideGrpc.getRouteChatMethod(), responseObserver);
        }

@Override public final io.grpc.ServerServiceDefinition bindService() {
return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
    .addMethod(
    RouteGuideGrpc.getGetFeatureMethod(),
    asyncUnaryCall(
    new MethodHandlers<
    Point,
    Feature>(
    proxiedImpl, METHODID_GET_FEATURE)))
    .addMethod(
    RouteGuideGrpc.getListFeaturesMethod(),
    asyncServerStreamingCall(
    new MethodHandlers<
    Rectangle,
    Feature>(
    proxiedImpl, METHODID_LIST_FEATURES)))
    .addMethod(
    RouteGuideGrpc.getRecordRouteMethod(),
    asyncClientStreamingCall(
    new MethodHandlers<
    Point,
    RouteSummary>(
    proxiedImpl, METHODID_RECORD_ROUTE)))
    .addMethod(
    RouteGuideGrpc.getRouteChatMethod(),
    asyncBidiStreamingCall(
    new MethodHandlers<
    RouteNote,
    RouteNote>(
    proxiedImpl, METHODID_ROUTE_CHAT)))
.build();
}
}
    private static final int METHODID_GET_FEATURE = 0;
    private static final int METHODID_LIST_FEATURES = 1;
    private static final int METHODID_RECORD_ROUTE = 2;
    private static final int METHODID_ROUTE_CHAT = 3;

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
private final IRouteGuide serviceImpl;
private final int methodId;

MethodHandlers(IRouteGuide serviceImpl, int methodId) {
this.serviceImpl = serviceImpl;
this.methodId = methodId;
}

@Override
@SuppressWarnings("unchecked")
public void invoke(Req request, io.grpc.stub.StreamObserver
<Resp> responseObserver) {
    switch (methodId) {
            case METHODID_GET_FEATURE:
            serviceImpl.getFeature((Point) request,
            (io.grpc.stub.StreamObserver<Feature>) responseObserver);
            break;
            case METHODID_LIST_FEATURES:
            serviceImpl.listFeatures((Rectangle) request,
            (io.grpc.stub.StreamObserver<Feature>) responseObserver);
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
                    case METHODID_RECORD_ROUTE:
                    return (io.grpc.stub.StreamObserver
                <Req>) serviceImpl.recordRoute(
                    (io.grpc.stub.StreamObserver<RouteSummary>) responseObserver);
                    case METHODID_ROUTE_CHAT:
                    return (io.grpc.stub.StreamObserver
                <Req>) serviceImpl.routeChat(
                    (io.grpc.stub.StreamObserver<RouteNote>) responseObserver);
            default:
            throw new AssertionError();
            }
            }
            }

            }
