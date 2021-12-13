package com.zhouhe.chap1;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

@Slf4j
public class TestByteBuffer {

    //读取文件中的内容，支持超过数组长度，循环往数组里写数据
    @Test
    public void testRWFile() {
        try (RandomAccessFile file = new RandomAccessFile("test.txt", "rw")) {
            FileChannel channel = file.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(10);
            log.info("byteBuffer.info, position:{}, limit:{}, capacity:{}", byteBuffer.position(), byteBuffer.limit(), byteBuffer.position());

            int i = -1;
            while ((i = channel.read(byteBuffer)) != -1) {
                byteBuffer.flip();
                while (byteBuffer.hasRemaining()) {
                    System.out.print((char) byteBuffer.get());
                }
                System.out.println("");
                byteBuffer.clear();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
