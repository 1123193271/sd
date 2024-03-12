package com.study.xyl._21_BIO.demo4;

import com.study.xyl._21_BIO.demo3.ServerThreadReader;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        System.out.println("服务端启动");
        HandlerSocketServerPool handlerSocketServerPool = new HandlerSocketServerPool(3, 10);
        try(ServerSocket serverSocket = new ServerSocket(9999)) {
            while (true) {
                Socket socket = serverSocket.accept();
                ServerThreadReader serverThreadReader = new ServerThreadReader(socket);
                handlerSocketServerPool.execute(serverThreadReader);
            }
        } catch (IOException e ) {
            e.printStackTrace();
        }

    }
}
