package org.apache.dubbo.samples.impl;

import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.samples.api.GreetingService;
import org.apache.dubbo.samples.constant.AnnotationConstants;

@Service(version = AnnotationConstants.VERSION)
public class AnnotationGreetingServiceImpl implements GreetingService {

    @Override
    public String greeting(String name) {
        System.out.println("provider received invoke of greeting: " + name);
        sleepWhile();
        return "Annotation, greeting " + name;
    }

    @Override
    public String replyGreeting(String name) {
        System.out.println("provider received invoke of replyGreeting: " + name);
        sleepWhile();
        return "Annotation, fine " + name;
    }

    private void sleepWhile() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}