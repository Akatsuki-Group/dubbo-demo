package com.zhouyu.framework.protocol.http;

import com.zhouyu.framework.Invocation;
import com.zhouyu.framework.Invoker;
import com.zhouyu.framework.URL;

public class HttpInvoker implements Invoker {

    private URL url;

    public HttpInvoker(URL url) {
        this.url = url;
    }

    @Override
    public String invoke(Invocation invocation) {
        HttpClient httpClient = new HttpClient();
        return httpClient.send(url.getHostname(), url.getPort(), invocation);
    }
}
