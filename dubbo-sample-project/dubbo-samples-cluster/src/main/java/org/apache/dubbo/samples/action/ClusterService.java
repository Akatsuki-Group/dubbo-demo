package org.apache.dubbo.samples.action;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.samples.api.HelloService;
import org.springframework.stereotype.Component;

/**
 * @author tian
 */
@Component
public class ClusterService {
    @DubboReference(version = "cluster", timeout = 2500, cluster = "failover", retries = 3)
    private HelloService failover;

    @DubboReference(version = "cluster", timeout = 2500, cluster = "failfast")
    private HelloService failfast;

    @DubboReference(version = "cluster", timeout = 2500, cluster = "failsafe")
    private HelloService failsafe;

    @DubboReference(version = "cluster", timeout = 2500, cluster = "failback")
    private HelloService failback;

    @DubboReference(version = "cluster", timeout = 2500, cluster = "forking")
    private HelloService forking;

    @DubboReference(version = "cluster", timeout = 2500, cluster = "broadcast")
    private HelloService broadcast;


    public String failover(String str) {
        String result = failover.sayHello(str);
        return result;
    }

    public String failfast(String str) {
        String result = failfast.sayHello("str");
        return result;
    }

    public String failsafe(String str) {
        String result = failsafe.sayHello(str);
        return result;
    }

    public String failback(String str) {
        String result = failback.sayHello("str");
        return result;
    }

    public String forking(String str) {
        String result = forking.sayHello(str);
        return result;
    }


    public String broadcast(String str) {
        String result = broadcast.sayHello(str);
        return result;
    }

}
