package com.zhouyu.framework.protocol.dubbo;

import com.zhouyu.framework.Invocation;
import com.zhouyu.framework.Invoker;
import com.zhouyu.framework.Protocol;
import com.zhouyu.framework.URL;
import com.zhouyu.framework.protocol.http.HttpServer;
import com.zhouyu.framework.register.LocalRegister;
import com.zhouyu.framework.register.RemoteMapRegister;
import com.zhouyu.provider.api.HelloService;
import com.zhouyu.provider.impl.HelloServiceImpl;

public class DubboProtocol implements Protocol {

    @Override
    public void export(URL url) {
        LocalRegister.regist(url.getInterfaceName(), url.getImplClass());
        RemoteMapRegister.regist(url.getInterfaceName(), url);
        new NettyServer().start(url.getHostname(), url.getPort());
    }

    @Override
    public Invoker refer(URL url) {
        return new DubboInvoker(url);
    }

}
