package com.zhouyu.framework.protocol.dubbo;

import com.zhouyu.framework.Invocation;
import com.zhouyu.framework.Invoker;
import com.zhouyu.framework.URL;

public class DubboInvoker implements Invoker {

    private URL url;

    public DubboInvoker(URL url) {
        this.url = url;
    }

    @Override
    public String invoke(Invocation invocation) {
        NettyClient nettyClient = new NettyClient();
        return nettyClient.send(url.getHostname(),url.getPort(), invocation);
    }

}
