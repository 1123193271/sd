package com.study.xyl._21_BIO.demo8;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

public class Server {
    private static ByteBuffer buf;

    public static void main(String[] args) throws IOException {
        System.out.println("---服务端启动---");
        //1.获取通道
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        //2.切换为非阻塞模式
        ssChannel.configureBlocking(false);
        //3.绑定连接的端口
        ssChannel.bind(new InetSocketAddress(9999));
        //4.获取选择器
        Selector selector = Selector.open();
        //5.将通道都注册到选择器上，并且开始监听接收事件
        ssChannel.register(selector, SelectionKey.OP_ACCEPT);
        //6.使用Selector选择器轮询已经就绪好的事件
        while(selector.select() > 0) {
            System.out.println("开始一轮轮询事件处理~~~");
            //7.获取选择器中的所有注册的通道中已经就绪好的事件
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            //8.开始遍历这些准备好的事件
            while (iterator.hasNext()) {
                SelectionKey sk = iterator.next();
                //9.判断这个事件具体是什么事件
                if (sk.isAcceptable()) {
                    //10.直接获取当前接入的客户端通道
                    SocketChannel sChannel = ssChannel.accept();
                    //11.将客户端通道也设置为非阻塞式的
                    sChannel.configureBlocking(false);
                    //12.将客户端通道也注册到选择器Selector上
                    sChannel.register(selector, SelectionKey.OP_READ);
                } else if (sk.isReadable()) {
                    //13.获取当前选择器上的“读就绪事件”
                    SocketChannel channel = (SocketChannel) sk.channel();
                    //14.开始读数据
                    ByteBuffer buf = ByteBuffer.allocate(1024);
                    int len = 0;
                    while ((len = channel.read(buf)) > 0) {
                        buf.flip();
                        System.out.println(new String(buf.array(), 0, len));
                        buf.clear();//“清除”之前的数据
                    }
                }
                //处理完毕当前事件后， 需要移除当前事件， 否则会重复处理
                iterator.remove();
            }
        }
    }
}
