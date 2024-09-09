package com.study.xyl._22_NIO.channel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
//本地文件写数据 但是这里写数据会覆盖原来的数据
public class Demo1 {
    public static void main(String[] args) throws FileNotFoundException {
        try (FileOutputStream fileOutputStream = new FileOutputStream("demo1.txt");
             FileChannel channel = fileOutputStream.getChannel();
        ) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            buffer.put("hello batman".getBytes());
            buffer.flip();
            channel.write(buffer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
