package com.marionsong;

import com.marionsong.CGLIBdynamicproxy.CGLIBExample;
import com.marionsong.jdkdynamicproxy.JdkProxyExample;
import com.marionsong.real.HelloWorld;
import com.marionsong.real.HelloWorld1;
import com.marionsong.real.HelloWorldImpl;
import org.junit.Test;

public class test {
    @Test
    public void testJdk(){
        JdkProxyExample jdk=new JdkProxyExample();
        HelloWorld proxy=(HelloWorld)jdk.bind(new HelloWorldImpl());
        proxy.sayHelloWorld();
    }

    @Test
    public void testCGlib(){
        CGLIBExample cglibExample=new CGLIBExample();
        HelloWorld1 obj=(HelloWorld1)cglibExample.getProxy(HelloWorld1.class);
        obj.sayHelloWorld("Tom");
    }
}
