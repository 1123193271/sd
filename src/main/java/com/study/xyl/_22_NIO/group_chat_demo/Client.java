package com.study.xyl._22_NIO.group_chat_demo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

public class Client {
    //定义客户端相关的属性
    private final Selector selector;

    private static final int PORT = 9999;

    private final SocketChannel socketChannel;

    //初始化客户端消息
    public Client() {
        try {
           //创建选择器
            selector = Selector.open();
            //连接服务器
            socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", PORT));
            //设置非阻塞模式
            socketChannel.configureBlocking(false);
            socketChannel.register(selector, SelectionKey.OP_READ);
            System.out.println("当前客户端准备完成");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        //定义一个线程，专门负责监听服务端发送过来的读消息事件
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    client.readInfo();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        //发消息
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            System.out.println("--------------");
            String s = scanner.nextLine();
            client.sendToServer(s);
        }
    }

    private void sendToServer(String s) {
        try {
            socketChannel.write(ByteBuffer.wrap(("客户端Client:" + s).getBytes()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void readInfo() throws IOException {
        while (selector.select() > 0) {
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                if (key.isReadable()) {
                    SocketChannel channel = (SocketChannel) key.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    channel.read(buffer);
                    System.out.println(new String(buffer.array()).trim());
                    System.out.println("-dsd---------------------------");
                }
                iterator.remove();
            }
        }
    }

}
