package com.man1s.algorithm.designpattern.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxy {

    public static void main(String[] args) {
        Object o = Proxy.newProxyInstance(JdkProxy.class.getClassLoader(), new Class[]{Subject.class}, new JdkProxyHandler(new RealSubject()));
        Subject.class.cast(o).bean();
    }
}

class JdkProxyHandler implements InvocationHandler{

    private  Subject subject;

    public JdkProxyHandler(Subject subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("jdkproxy invoke pre");
        Object invoke = method.invoke(subject, args);
        System.out.println("jdkproxy invoke after");
        return invoke;
    }
}

interface Subject{
    Object bean();
}

class RealSubject implements  Subject{
    @Override
    public Object bean() {
        System.out.println("这是我自己吗？"+this.getClass().getName());
        return null;
    }
}
