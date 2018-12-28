package com.zhouhe.myorm;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DebugProxy implements InvocationHandler {

    private Object obj;

    public DebugProxy(Object obj) {
        this.obj = obj;
    }

    public static Object newInstance(Object obj){
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                                        obj.getClass().getInterfaces(),
                                        new DebugProxy(obj));
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        System.out.println("开始代理...........");
        try {
            result = method.invoke(obj, args);
            System.out.println(result);
        }catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("结束代理...........");
        }
        return result;
    }
}
