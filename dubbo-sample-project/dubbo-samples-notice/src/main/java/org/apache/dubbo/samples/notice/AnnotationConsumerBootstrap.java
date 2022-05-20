/*
 *
 *   Licensed to the Apache Software Foundation (ASF) under one or more
 *   contributor license agreements.  See the NOTICE file distributed with
 *   this work for additional information regarding copyright ownership.
 *   The ASF licenses this file to You under the Apache License, Version 2.0
 *   (the "License"); you may not use this file except in compliance with
 *   the License.  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */

package org.apache.dubbo.samples.notice;


import org.apache.dubbo.samples.notice.action.AnnotationAction;
import org.apache.dubbo.samples.notice.api.HelloService;
import org.apache.dubbo.samples.notice.api.Notify;
import org.apache.dubbo.samples.notice.config.ConsumerConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationConsumerBootstrap {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConsumerConfiguration.class);
        context.start();
        Notify bean = (Notify) context.getBean("demoCallback");
        final AnnotationAction annotationAction = (AnnotationAction) context.getBean("action");
        System.out.println("goodbye : " + annotationAction.doSayHello("world"));




//        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring/async-consumer.xml");
//                context.start();
//        final HelloService annotationAction = (HelloService) context.getBean("demoService");
//        System.out.println("hello : " + annotationAction.sayHello("world"));
    }


}
