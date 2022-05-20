package org.apache.dubbo.samples.simplified.annotation.action;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.samples.simplified.annotation.api.AnnotationService;
import org.springframework.stereotype.Component;

@Component("annotationAction")
public class AnnotationAction {

    @DubboReference(version = "1.1.8", group = "d-test", owner = "vvvanno", retries = 4, actives = 6, timeout = 4500)
    private AnnotationService annotationService;

    public String doSayHello(String name) {
        return annotationService.sayHello(name);
    }
}