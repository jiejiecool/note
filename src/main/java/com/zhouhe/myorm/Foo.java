package com.zhouhe.myorm;

import java.lang.reflect.Proxy;

public interface Foo {
    Object bar(Object obj) throws BazException;

    String say();
}
