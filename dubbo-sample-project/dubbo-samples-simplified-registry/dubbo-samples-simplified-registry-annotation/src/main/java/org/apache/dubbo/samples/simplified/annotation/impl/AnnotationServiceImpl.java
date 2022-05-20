package org.apache.dubbo.samples.simplified.annotation.impl;

import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.samples.simplified.annotation.api.AnnotationService;

@DubboService(version = "1.1.8", group = "d-test", executes = 4500, retries = 7, owner = "victanno", timeout = 5300)
public class AnnotationServiceImpl implements AnnotationService {
    @Override
    public String sayHello(String name) {
        System.out.println("async provider received: " + name);
        return "annotation: hello, " + name;
    }

}