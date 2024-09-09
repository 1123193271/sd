package com.study.xyl._21_BIO.demo8;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * NIO非阻塞式网络通信入门案例
 */
public class Client {
    public static void main(String[] args) {
        //1.获取通道
        try (SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9999))) {
            //2.切换为非阻塞模式
            sChannel.configureBlocking(false);
            //3.分配指定的缓存的大小
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            //4.发送数据给服务端
            Scanner scanner = new Scanner(System.in);
            while (true){
                System.out.println("请输入");
                String msg = scanner.nextLine();
                buffer.put(("客户端：" + msg).getBytes());
                buffer.flip();
                sChannel.write(buffer);
                buffer.clear();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
