package com.study.xyl._22_NIO.channel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;

//TransferFrom和TransferTo
public class Demo5 {
    public static void main(String[] args) {
        try (FileInputStream fileInputStream = new FileInputStream("demo1.txt");
             FileChannel fileInputStreamChannel = fileInputStream.getChannel();
             FileOutputStream fileOutputStream = new FileOutputStream("demo3.txt");
             FileChannel fileOutputStreamChannel = fileOutputStream.getChannel()
        ) {
//            fileOutputStreamChannel.transferFrom(fileInputStreamChannel, fileInputStreamChannel.position(), fileInputStreamChannel.size());
            fileInputStreamChannel.transferTo(fileInputStreamChannel.position(), fileInputStreamChannel.size(), fileOutputStreamChannel);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
