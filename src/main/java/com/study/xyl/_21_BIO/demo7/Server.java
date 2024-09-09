package com.study.xyl._21_BIO.demo7;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端开发，实现接受客户端的任意类型的文件，并保存到服务端磁盘
 */
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            while (true) {
                Socket socket = serverSocket.accept();
                //交给一个独立的线程来处理与这个客户端的文件通信需求
                new ServerReadThread(socket).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
