package com.marionsong;

import com.marionsong.jdkdynamicproxy.JdkProxyExample;
import com.marionsong.real.HelloWorld;
import com.marionsong.real.HelloWorldImpl;

public class testJdkProxy {
    public static void main(String[] args) {
        JdkProxyExample jdk=new JdkProxyExample();
        HelloWorld proxy=(HelloWorld)jdk.bind(new HelloWorldImpl());
        proxy.sayHelloWorld();
    }
}
