package com.zhouhe.proxy;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import sun.misc.ProxyGenerator;
public class App {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException, ClassNotFoundException {
//		Student st = new StudentImpl();
//		Student proxy = (Student) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
//				new Class[] { Student.class }, new MyInvokeHandler(st));
//		proxy.say();
//		
		//java动态代理对象的创建过程
		
		//1.创建自己的调用处理器(invocationhandler)
		InvocationHandler handler = new MyInvokeHandler(new StudentImpl());
		//2.通过Proxy类为interface类创建动态代理类对象，既生成class 的object
		Class clazz = Proxy.getProxyClass(Thread.currentThread().getContextClassLoader(), Student.class);
		 byte[] proxyClass = ProxyGenerator.generateProxyClass(clazz
	              .getSimpleName(), clazz.getInterfaces());
		 new FileOutputStream(new File("D:\\"+clazz.getName()+".class")).write(proxyClass);
		
		System.out.println(clazz.getSuperclass());
		Field[] fields = clazz.getDeclaredFields();
		//3.通过反射从生成的类对象中获得构造函数对象
		Constructor constructor = clazz.getConstructor(new Class[] {InvocationHandler.class});
		//4.通过构造函数对象创建动态代理类对象
		Student proxy = (Student) constructor.newInstance(new Object[] {handler});
		Arrays.asList(proxy.getClass().getDeclaredFields()).forEach(e -> {
			System.out.println(e.getGenericType() +"--"+e.getName());
		});
		
		proxy.say();
		
	}
	
	public static <T extends Student> void say(Student s) {
		if(s instanceof Runnable) {
			
		}
		
	} 
}
