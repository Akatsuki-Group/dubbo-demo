package com.zhouyu.provider;

import com.zhouyu.framework.Protocol;
import com.zhouyu.framework.ProtocolFactory;
import com.zhouyu.framework.URL;
import com.zhouyu.provider.api.HelloService;
import com.zhouyu.provider.impl.HelloServiceImpl;
import com.zhouyu.framework.register.LocalRegister;
import com.zhouyu.framework.register.RemoteMapRegister;

public class Provider {

    private static boolean isRun = true;

    public static void main(String[] args) {

        String protocolName = System.getProperty("protocol");

        URL url = new URL(protocolName, "localhost", 8080, HelloService.class.getName(), HelloServiceImpl.class);

        Protocol protocol = ProtocolFactory.getProtocol(protocolName);
        protocol.export(url);

    }
}
