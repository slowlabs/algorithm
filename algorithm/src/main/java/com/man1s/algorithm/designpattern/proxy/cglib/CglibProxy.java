package com.man1s.algorithm.designpattern.proxy.cglib;


import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy {



    public static void main(String[] args) throws Exception{
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "E:\\class\\cglib");
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(TestBean.class);
        enhancer.setCallback(new TestBeanInteceptor());
        Object o = enhancer.create();
        TestBean.class.cast(o).bean("时间管理");
        while (true){
            Thread.sleep(100);
        }
    }
}

class TestBean{

    public void bean(String name){
        System.out.println("我是自己的"+name);
    }

}

class TestBeanInteceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib proxy invoke pre");
        Object o1 = methodProxy.invokeSuper(o, objects);
        System.out.println("cglib proxy invoke after");
        return o1;
    }
}
