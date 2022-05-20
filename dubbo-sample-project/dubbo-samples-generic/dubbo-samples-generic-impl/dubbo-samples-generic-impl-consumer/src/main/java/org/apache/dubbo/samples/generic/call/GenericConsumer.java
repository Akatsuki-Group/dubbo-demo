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

package org.apache.dubbo.samples.generic.call;


import org.apache.dubbo.samples.generic.call.action.GenericAction;
import org.apache.dubbo.samples.generic.call.api.HelloService;
import org.apache.dubbo.samples.generic.call.config.ConsumerConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;

public class GenericConsumer {
    private static HelloService helloService;

    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConsumerConfiguration.class);
        context.start();
        helloService = (HelloService) context.getBean("helloService");

        syncCall();
        futureCall();
    }

    public static void syncCall() {
        try {
            String syncCallResult = helloService.sayHello("world");
            System.out.println(syncCallResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void futureCall() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        CompletableFuture<String> future = helloService.sayHelloAsync("world");
        future.whenComplete((v, t) -> {
            System.out.println(v);
            latch.countDown();
        });
        latch.await();
    }

}
