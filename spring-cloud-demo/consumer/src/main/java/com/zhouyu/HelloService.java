package com.zhouyu;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("spring-cloud-provider-application")
//@FeignClient("dubbo-provider-application")
//@FeignClient(name = "dubbo-provider-application", url = "localhost:20881")
public interface HelloService {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello();
}
