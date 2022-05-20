package org.apache.dubbo.samples.loadbalance.action;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.samples.loadbalance.api.DemoService;
import org.springframework.stereotype.Component;

/**
 * @author tian
 */
@Component
public class LoadBalanceService {

    @DubboReference(version = "default", loadbalance = "random")
    private DemoService random;

    @DubboReference(version = "default", loadbalance = "roundrobin")
    private DemoService roundrobin;

    @DubboReference(version = "default", loadbalance = "leastactive")
    private DemoService leastactive;

    @DubboReference(version = "default", loadbalance = "consistenthash")
    private DemoService consistenthash;


    public String random(String name) {
        for (int i = 0; i < 100; i++) {
            random.sayHello(name);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return name;
    }


    public String roundrobin(String name) {
        for (int i = 0; i < 100; i++) {
            roundrobin.sayHello(name);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return name;
    }

    public String leastactive(String name) {
        for (int i = 0; i < 100; i++) {
            leastactive.sayHello(name);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return name;
    }

    public String consistenthash(String name) {
        for (int i = 0; i < 100; i++) {
            consistenthash.sayHello(i % 5 + name);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return name;
    }

}
