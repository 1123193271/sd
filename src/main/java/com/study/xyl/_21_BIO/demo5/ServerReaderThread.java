package com.study.xyl._21_BIO.demo5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ServerReaderThread extends Thread{
    private Socket socket;

    public ServerReaderThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            String msg;
            while ((msg = bufferedReader.readLine()) != null) {
                System.out.println("Server receive message :" + msg);
                sendMsgToAllClient(msg, socket);
            }
        } catch (Exception e) {
            System.out.println("有人下线啦");
            Server.allSocketOnline.remove(socket);
        }
    }

    private void sendMsgToAllClient(String msg, Socket socket) throws IOException {
        for (Socket sk : Server.allSocketOnline) {
            if (socket != sk) {
                PrintStream ps = new PrintStream(sk.getOutputStream());
                ps.println(msg);
                ps.flush();
            }
        }
    }


}
