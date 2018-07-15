package com.marionsong.jdkdynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyExample implements InvocationHandler {
    //真实对象
    private Object target = null;

    /**
     * 建立代理对象和真实对象之间的关系，返回代理对象
     * @param target
     * @return 代理对象
     */
    public Object bind(Object target){
        this.target=target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("进入代理逻辑方法");
        System.out.println("在调度真实对象之前的服务");
        Object obj=method.invoke(target,args);
        System.out.println("在调度真实对象之后的服务");
        return obj;
    }
}
