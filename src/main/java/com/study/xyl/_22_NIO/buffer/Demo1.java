package com.study.xyl._22_NIO.buffer;


import java.io.BufferedReader;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class Demo1 {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
        System.out.println("+++++++++++++++++");
        //像缓冲区添加数据
        String name = "Superman";
        buffer.put(name.getBytes());
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
        System.out.println("____________________");
        //flip方法为缓存区的界线设置为当前位置，并将当前位置设置为0，可读模式
        buffer.flip();
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
        System.out.println("”“”“”“”“”“”“”“”“”“”“”“");
        //数据的读取
        byte b = buffer.get();
        char ch = (char) b;
        System.out.println(ch);
        System.out.println(buffer.position());
        byte[] bytes = new byte[4];
        buffer.get(bytes);
        System.out.println(new String(bytes));
        buffer.mark();
        char b1 = (char) buffer.get();
        System.out.println(b1);
        //回到标记位置
        buffer.reset();
        byte[] bytes1 = new byte[3];
        buffer.get(bytes1);
        System.out.println(new String(bytes1));
    }
}
