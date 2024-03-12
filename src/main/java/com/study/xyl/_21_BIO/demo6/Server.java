package com.study.xyl._21_BIO.demo6;

import com.study.xyl._21_BIO.demo3.ServerThreadReader;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            while (true) {
                Socket accept = serverSocket.accept();
                new ServerReadThread(accept).run();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
