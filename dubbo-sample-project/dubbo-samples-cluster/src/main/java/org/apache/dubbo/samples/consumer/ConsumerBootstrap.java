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

package org.apache.dubbo.samples.consumer;


import org.apache.dubbo.samples.action.ClusterService;
import org.apache.dubbo.samples.config.ConsumerConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConsumerBootstrap {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConsumerConfiguration.class);
        context.start();
        final ClusterService clusterService = (ClusterService) context.getBean("clusterService");

        System.out.println("Failover Cluster : " + clusterService.failover("Failover"));
        System.out.println("Failfast Cluster : " + clusterService.failfast("Failfast"));
        System.out.println("Failsafe Cluster : " + clusterService.failsafe("Failsafe"));
        System.out.println("Failback Cluster : " + clusterService.failback("failback"));
        System.out.println("Forking  Cluster : " + clusterService.failback("Forking"));
        System.out.println("Broadcast Cluster : " + clusterService.failback("Broadcast"));
    }


}
