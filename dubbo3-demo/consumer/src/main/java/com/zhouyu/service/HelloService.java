package com.zhouyu.service;

import com.zhouyu.User;
import com.zhouyu.UserRequest;
import com.zhouyu.UserService;
import org.apache.dubbo.common.stream.StreamObserver;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.concurrent.CompletableFuture;

@Path("/")
@Consumes
public interface HelloService {

    @GET
    @Path("hello")
    String hello();
}
