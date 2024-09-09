package com.study.xyl._22_NIO.group_chat_demo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

public class Server {
    //定义属性
    private Selector selector;

    private ServerSocketChannel ssChannel;

    private static final int PORT = 9999;

    public Server() {
        try {
            //创建选择器
            selector = Selector.open();
            //获取通道
            ssChannel = ServerSocketChannel.open();
            //切换为非阻塞模式
            ssChannel.configureBlocking(false);
            //绑定连接的端口
            ssChannel.bind(new InetSocketAddress(PORT));
            //将通道都注册到选择器上去，并且开始指定监听接收事件
            ssChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //创建服务端对象
        Server server = new Server();
        //开始监听客户端的各种消息事件：连接， 群聊消息， 离线消息
        server.listen();
    }

    public void listen() {
        try {
            while (selector.select() > 0) {
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey sk = iterator.next();
                    if (sk.isAcceptable()) {
                        //客户端接入请求
                        //获取当前客户端通道
                        SocketChannel sChannel = ssChannel.accept();
                        //注册成非阻塞模式
                        sChannel.configureBlocking(false);
                        //注册给选择器，监听读数据的事件
                        sChannel.register(selector, SelectionKey.OP_READ);
                    } else if (sk.isReadable()) {
                        //处理这个客户端的消息，接受它，然后实现转发逻辑
                        readClientData(sk);
                    }
                    iterator.remove();//处理完毕后，需要移除当前事件
                }
            }
        } catch (Exception ignored) {
        }
    }

    private void readClientData(SelectionKey sk){
        SocketChannel sChannel = null;
        try {
            //直接得到当前客户端通道
            sChannel = (SocketChannel) sk.channel();
            //创建缓存区对象，开始接收客户端通道的数据
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int count = sChannel.read(buffer);
            if (count > 0) {
                buffer.flip();
                //提取读取到的信息
                String msg = new String(buffer.array(), 0, buffer.remaining());
                System.out.println("接收到了客户端的消息：" + msg);
                //把这个消息推送给全部的客户端接受
                sendMsgToAllClient(msg, sChannel);
            }

        } catch (Exception e) {
            try {
                assert sChannel != null;
                System.out.println("有人离线了：" + sChannel.getRemoteAddress());
                //当前客户端离线
                sk.cancel();//取消注册
                sChannel.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    //把当前客户端的消息推送给当前全部在线注册的channel
    private void sendMsgToAllClient(String msg, SocketChannel sChannel) throws IOException{
        System.out.println("服务端开始转发这个消息，当前处理的线程：" + Thread.currentThread().getName());
        for (SelectionKey key : selector.keys()) {
            Channel channel = key.channel();
            //不要把消息发给自己
            if (channel instanceof SocketChannel && channel != sChannel) {
                ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
                ((SocketChannel)channel).write(buffer);
            }
        }
    }
}
