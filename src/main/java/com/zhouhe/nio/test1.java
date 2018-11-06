package com.zhouhe.nio;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;


public class test1 {
	@Test
	public void test() throws IOException {
		File file = new File("D:\\zhoujie.txt");
		FileWriter fw = new FileWriter(file);
		fw.write("1234");
		fw.close();
	}
}
