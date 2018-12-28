package com.zhouhe.myorm;

import org.junit.Test;

import java.lang.reflect.Method;

public class TestDynamicProxy {
    @Test
    public void test1() {
        Object o = DebugProxy.newInstance(new FooImply());
         o.getClass();
        System.out.println(o instanceof Foo);

        System.out.println(new FooImply() instanceof  Foo);
        Foo foo = (Foo) o;
        foo.bar(new String("123"));
        foo.say();
        System.out.println("-------------------------------------");
        foo.toString();
    }

    @Test
    public void test2() {
        //Method[] methods = Foo.class.getMethods();
        Method[] methods = Foo.class.getDeclaredMethods();
        String[] methodNames = new String[methods.length];
        //获取 要代理的方法名称
        for (int i = 0; i < methodNames.length; i++) {
            methodNames[i] = methods[i].getName();
        }


    }
}
