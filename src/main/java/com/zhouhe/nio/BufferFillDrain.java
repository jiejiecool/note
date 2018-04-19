package com.zhouhe.nio;

import java.nio.CharBuffer;

public class BufferFillDrain {
	public static void main(String[] argv) throws Exception {
		CharBuffer buffer = CharBuffer.allocate(100);

		while (fillBuffer(buffer)) {
			buffer.flip();
			drainBuffer(buffer);
			buffer.clear();
		}
	}

	/**
	 * 写出整个buffer
	 * @param buffer
	 */
	private static void drainBuffer(CharBuffer buffer) {
		while (buffer.hasRemaining()) {
			System.out.print(buffer.get());
		}

		System.out.println("");
	}
	
	/**
	 * 判断是否能继续填充buffer，如果可以则填充string中的单个字符进buffer
	 * @param buffer
	 * @return
	 */
	private static boolean fillBuffer(CharBuffer buffer) {
		if (index >= strings.length) {
			return (false);
		}

		String string = strings[index++];

		for (int i = 0; i < string.length(); i++) {
			buffer.put(string.charAt(i));
		}

		return (true);
	}

	private static int index = 0;

	private static String[] strings = { "A random string value", "The product of an infinite number of monkeys",
			"Hey hey we're the Monkees", "Opening act for the Monkees: Jimi Hendrix", "'Scuse me while I kiss this fly", // Sorry
			"Help Me!  Help Me!", };
}


