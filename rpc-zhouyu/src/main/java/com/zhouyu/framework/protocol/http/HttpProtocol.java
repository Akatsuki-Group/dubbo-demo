package com.zhouyu.framework.protocol.http;

import com.zhouyu.framework.Invocation;
import com.zhouyu.framework.Invoker;
import com.zhouyu.framework.Protocol;
import com.zhouyu.framework.URL;
import com.zhouyu.framework.register.LocalRegister;
import com.zhouyu.framework.register.RemoteMapRegister;

public class HttpProtocol implements Protocol {

    @Override
    public void export(URL url) {
        // 本地注册
        LocalRegister.regist(url.getInterfaceName(), url.getImplClass());
        // 注册中心注册
        RemoteMapRegister.regist(url.getInterfaceName(), url);
        // 启动Tomcat
        new HttpServer().start(url.getHostname(), url.getPort());
    }

    @Override
    public Invoker refer(URL url) {
        return new HttpInvoker(url);
    }

}
