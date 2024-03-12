package com.study.xyl._21_BIO.demo5;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    public static List<Socket> allSocketOnline = new ArrayList<>();

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(9999);
            while (true) {
                Socket socket = ss.accept();
                allSocketOnline.add(socket);
                new ServerReaderThread(socket).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
