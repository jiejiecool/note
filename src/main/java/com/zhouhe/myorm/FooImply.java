package com.zhouhe.myorm;

public class FooImply implements Foo{
    @Override
    public Object bar(Object obj) throws BazException {
        return obj.toString();
    }

    @Override
    public String say() {
        return "123";
    }
}
