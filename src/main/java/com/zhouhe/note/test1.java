package com.zhouhe.note;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.UUID;

public class test1 {
	public static void main(String[] args) {
		Person person = new Person();
		Class clazz = person.getClass();
		person.setAge(20);
		person.setName("zhoujie");
		
//		Field[] fields = clazz.getDeclaredFields();
//		Arrays.asList(fields).forEach((
//				field) -> System.out.println(field.getName())
//				);
		
		Method[] methods = clazz.getDeclaredMethods();
		Arrays.asList(methods).forEach((method) -> {
				method.setAccessible(true);
				Parameter[] parameter = method.getParameters();
				Arrays.asList(parameter).forEach((p) -> {
					System.out.println(p.getName());
					System.out.println(p.getType());
				});
		});
	}
	
	static public class Person {
		private String name;
		private int age;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}

		private String getString() {
			return this.getName()+this.getAge();
		}

	}
}
