package com.study.xyl._22_NIO.buffer;

import java.nio.ByteBuffer;

public class Demo2 {
    public static void main(String[] args) {
        ByteBuffer buffer1 = ByteBuffer.allocate(1024);
        ByteBuffer buffer2 = ByteBuffer.allocateDirect(1024);
        System.out.println(buffer1.isDirect());
        System.out.println(buffer2.isDirect());
    }
}
