package com.zhouyu.service;

import com.zhouyu.User;
import com.zhouyu.UserRequest;
import com.zhouyu.UserService;
import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

//    @DubboReference(protocol = "tri", url = "tri://localhost:8008", proxy = CommonConstants.NATIVE_STUB)
//    private UserService userService;

    @DubboReference(url = "rest://localhost:7070", protocol = "rest")
//    @DubboReference(providedBy = "spring-cloud-provider-application", protocol = "rest")
    private HelloService helloService;

    public String createOrder() {
        return helloService.hello();
    }
}