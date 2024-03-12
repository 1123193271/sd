package com.study.xyl._21_BIO.demo3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        System.out.println("服务端启动");
        try(ServerSocket serverSocket = new ServerSocket(9999)) {
            while (true) {
                Socket socket = serverSocket.accept();
                new ServerThreadReader(socket).start();
            }
        } catch (IOException e ) {
            e.printStackTrace();
        }

    }
}
