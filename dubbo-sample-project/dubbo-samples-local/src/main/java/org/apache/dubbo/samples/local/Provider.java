package org.apache.dubbo.samples.local;

import org.apache.dubbo.samples.local.api.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author tian
 */
public class Provider {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/spring-dubbo.xml"});
        context.start();
        DemoService demoService = context.getBean("demoService", DemoService.class);
        String hello = demoService.sayHello("world");
        System.out.println(hello);
        System.in.read(); // 按任意键退出
    }
}
