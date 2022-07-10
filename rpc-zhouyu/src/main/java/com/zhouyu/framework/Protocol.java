package com.zhouyu.framework;

public interface Protocol {

    void export(URL url);
    Invoker refer(URL url);
}
