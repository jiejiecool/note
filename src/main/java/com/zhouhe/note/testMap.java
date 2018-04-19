package com.zhouhe.note;

import java.math.BigDecimal;
import java.util.Objects;

import org.junit.Test;

public class testMap {
	@Test
	public void test1() {
		BigDecimal b1 = new BigDecimal(4);
		BigDecimal b2 = new BigDecimal(0);
		System.out.println(b1.compareTo(b2));
	}
}
