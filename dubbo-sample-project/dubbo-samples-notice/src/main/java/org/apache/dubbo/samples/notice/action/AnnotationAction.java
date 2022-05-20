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

package org.apache.dubbo.samples.notice.action;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.Method;
import org.apache.dubbo.samples.notice.api.HelloService;
import org.apache.dubbo.samples.notice.api.Notify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component("action")
public class AnnotationAction {

    @Bean
    public Notify demoCallback() {
        return new NotifyImpl();
    }


    /**
     * 使用注解的方式存在bug
     */
    @DubboReference(interfaceClass = HelloService.class, version = "hello"
/*            , methods = {
            @Method(
                    name = "sayHello",
                    onreturn = "demoCallback.onreturn",
                    onthrow = "demoCallback.onthrow")
    }*/
    )
    private HelloService helloService;

    public String doSayHello(String name) {
        try {
            return helloService.sayHello(name);
        } catch (Exception e) {
            e.printStackTrace();
            return "Throw Exception";
        }
    }

    public String doSayGoodbye(String name) {
        try {
            return helloService.sayGoodbye(name);
        } catch (Exception e) {
            e.printStackTrace();
            return "Throw Exception";
        }

    }
}
