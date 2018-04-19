package com.zhouhe.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvokeHandler implements InvocationHandler{

	private Object target;
	
	public MyInvokeHandler(Object target) {
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("123");
		Object result = method.invoke(target, args);
		System.out.println("456");
		return result;
	}

}
