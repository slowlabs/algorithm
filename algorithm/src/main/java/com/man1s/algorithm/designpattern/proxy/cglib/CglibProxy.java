package com.man1s.algorithm.designpattern.proxy.cglib;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy {



    public static void main(String[] args) throws Exception{
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(TestBean.class);
        enhancer.setCallback(new TestBeanInteceptor());
        Object o = enhancer.create();
        TestBean.class.cast(o).bean();
        while (true){
            Thread.sleep(100);
        }
    }
}

class TestBean{

    public void bean(){
        System.out.println("我是自己的"+this.getClass().getName());
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
