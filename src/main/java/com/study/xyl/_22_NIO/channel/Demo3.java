package com.study.xyl._22_NIO.channel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//
public class Demo3 {
    public static void main(String[] args) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream("demo1.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("demo2.txt")) {
            FileChannel fileOutputStreamChannel = fileOutputStream.getChannel();
            FileChannel fileInputStreamChannel = fileInputStream.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1);//这里只设置一个字节
            while (true) {
                //必须先清空缓存然后再写入数据到缓存
                buffer.clear();
                int flag = fileInputStreamChannel.read(buffer);
                if (flag == -1) {
                    break;
                }
                //已经读取了数据,把缓存区的模式切换
                buffer.flip();
                fileOutputStreamChannel.write(buffer);
            }
        }
    }
}
