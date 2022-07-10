package com.zhouyu.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/")
@Produces
public interface HelloService {

    @GET
    @Path("hello")
    String hello();
}
