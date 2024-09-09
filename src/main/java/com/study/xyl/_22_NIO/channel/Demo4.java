package com.study.xyl._22_NIO.channel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//分散读取和聚集写入
public class Demo4 {
    public static void main(String[] args) {
        try (FileInputStream fileInputStream = new FileInputStream("demo1.txt");
             FileChannel fileInputStreamChannel = fileInputStream.getChannel();
             FileOutputStream fileOutputStream = new FileOutputStream("demo3.txt");
             FileChannel fileOutputStreamChannel = fileOutputStream.getChannel()
        ) {
            ByteBuffer buffer1 = ByteBuffer.allocate(1024);
            ByteBuffer buffer2 = ByteBuffer.allocate(101);
            ByteBuffer[] byteBuffers = {buffer2,buffer1};
            fileInputStreamChannel.read(byteBuffers);
            for (ByteBuffer byteBuffer : byteBuffers) {
                byteBuffer.flip();
                System.out.println(new String(byteBuffer.array(), 0, byteBuffer.remaining()));
            }
            fileOutputStreamChannel.write(byteBuffers);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
