package com.zhouyu.service;

import com.zhouyu.User;
import com.zhouyu.UserRequest;
import com.zhouyu.UserService;
import org.apache.dubbo.common.stream.StreamObserver;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.beans.factory.annotation.Value;

import java.util.concurrent.TimeUnit;

//@DubboService
public class UserServiceImpl implements UserService {

    public User getUser(UserRequest userRequest) {
        User user = User.newBuilder().setUid(userRequest.getUid()).setUsername("zhouyu").build();
        return user;
    }

}
