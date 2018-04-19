package com.zhouhe.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

import org.junit.Test;

public class cha1 {
	private static String strings = "A random string value" + 
	        "The product of an infinite number of monkeys"+          "Hey hey we're the Monkees"+  
	        "Opening act for the Monkees: Jimi Hendrix"+
	        "'Scuse me while I kiss this fly"+
	        "Help Me!  Help Me!";
	
	
	//@Test
	public void test1() throws InterruptedException {
		ByteBuffer buff = ByteBuffer.allocate(10);
		System.out.println(buff.limit());
		System.out.println(buff.mark());
		System.out.println(buff.position());
		System.out.println(buff.capacity());
		buff.put((byte) 'H').put((byte)'H');
		
		Thread.sleep(1000);
		System.out.println((char)buff.get(0));
		System.out.println((char)buff.get(1));
		
		byte[] arr = new byte[10];
		buff.flip();
		for (int i = 0; buff.hasRemaining(); i++) {
			System.out.println(buff.position());
			arr[i] = buff.get();
		}
		
		System.out.println((char)arr[0]);
		System.out.println((char)arr[1]);
	}
	
	/**
	 * 测试填写打印整个buffer，然后重置整个buffer
	 */
	//@Test
	public void test2() {
		CharBuffer cb = CharBuffer.allocate(100);
		fillBuffer(cb);
		printAll(cb);
		drainBuffer(cb);
	}
	
	/**
	 * 测试相同的buffer，不同的poisition对hashcode的影响
	 */
	//@Test
	public void test4(){
		ByteBuffer bb = ByteBuffer.allocate(10);
		bb.put((byte)'H').put((byte)'e');
		
		System.out.println(bb.hashCode());
		bb.flip();
		
		System.out.println(bb.hashCode());
		
	}
	
	@Test
	public void test5() {
		double a = 1.00;
		for (int x = 99; x >= 80; x--) {
			a *= x/100.00;
		}
		System.out.println(1-a);
	}
	/**
	 * 测试buffer的函数对mark的影响
	 */
	//@Test
	public void test3() {
		ByteBuffer bb = ByteBuffer.allocate(10);
		bb.position(2).mark().position(4);
		
		System.out.println(bb.position());
		System.out.println("1s");
	}
	
	/**
	 * 打印缓冲区中的全部内容
	 * 注意点：如果插入buffer后直接使用CharBuffer.remaining(),则是代表整个buffer还有多少空间可以插入
	 * 所以必须先CharBuffer.flip(),将position置位0，将limit置位刚才的最后一个值
	 * @param cb
	 */
	public void printAll(CharBuffer cb) {
		cb.flip();
		int length = cb.remaining();
		for (int i = 0; i < length; i++) {
			System.out.print(cb.get());
		}
		
		System.out.println(" ");
		System.out.println("打印结束");
	}
	
	public void fillBuffer(CharBuffer cb) {
		for (int index = 0; index < 100; index++) {
			cb.put(strings.charAt(index));
		}
		
	}
	
	public void drainBuffer(CharBuffer cb) {
		cb.clear();
	}

}
