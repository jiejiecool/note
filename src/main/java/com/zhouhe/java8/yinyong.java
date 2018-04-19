package com.zhouhe.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import org.junit.Before;
import org.junit.Test;

/**
 * java8相关
 * lambda类似于匿名内部类，把处理过程当做参数
 * java8中比较常用的几个functionalinterface有：consumer(没有返回值),predicate(返回boolean),Function<T,R>(接收一个类型返回一个类型)
 * @author jiejiecool
 *
 */
public class yinyong {
	List<String> student = new ArrayList<>();
	
	@Before
	public void setList() {
		student = Arrays.asList("zhoujie","hehongjuan");
	}
	/**
	 * 测试consumer
	 */
	//@Test
	public void test1() {
		Consumer<String> consumer = System.out::println;
		student.forEach(consumer);
		
	}
	
	/**
	 * 测试predicate
	 * name = zhoujie 则count++
	 */
	//@Test
	public void test2() {
		
		
		int count = filterName(student, (name) -> name.equals("zhoujie"));
		System.out.println(count);
		
	}
	private int filterName(List<String> student2, Predicate<String> predicate) {
		int count = 0;
		for (String student : student2) {
			if (predicate.test(student)) {
				count ++;
			}
		}
		return count;
	}
	
	/**
	 * 测试function,使用名字生成student.class
	 */
	@Test
	public void test3() {
		List<Student> list = genStudent(student, (name)->new Student(name));
		list.forEach((student)->System.out.println(student.getName()));
	}
	
	
	private List<Student> genStudent(List<String> student2, Function<String, Student> function) {
		List<Student> students = new ArrayList<Student>();
		for (String name : student2) {
			students.add(function.apply(name));
	}
		return students;
	}
	
}
