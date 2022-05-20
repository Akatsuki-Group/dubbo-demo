package org.apache.dubbo.samples;

import org.apache.dubbo.samples.api.GroupService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author tian
 */
public class GroupConsumer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/group-consumer.xml");
        context.start();

        GroupService groupAService = context.getBean("groupAService", GroupService.class);
        GroupService groupBService = context.getBean("groupBService", GroupService.class);
        long start = System.currentTimeMillis();
        String resultGroupA = groupAService.sayHello("world");
        System.out.println(resultGroupA);
        System.out.println("groupA调用时间:" + (System.currentTimeMillis() - start));
        long start1 = System.currentTimeMillis();
        String resultGroupB = groupBService.sayHello("world");
        System.out.println(resultGroupB);
        System.out.println("groupB调用时间:" + (System.currentTimeMillis() - start1));
    }
}
