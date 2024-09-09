package com.study.xyl._22_NIO.channel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//本地文件读数据
public class Demo2 {
    public static void main(String[] args) {
        try (FileInputStream fileInputStream = new FileInputStream("demo1.txt");
             FileChannel fileChannel = fileInputStream.getChannel();) {
            ByteBuffer allocate = ByteBuffer.allocate(1024);
            fileChannel.read(allocate);
            allocate.flip();
            System.out.println(new String(allocate.array(),0, allocate.remaining()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
