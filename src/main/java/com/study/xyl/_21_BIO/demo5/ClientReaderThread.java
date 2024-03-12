package com.study.xyl._21_BIO.demo5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientReaderThread extends Thread{

    private Socket socket;

    public ClientReaderThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (InputStream inputStream = socket.getInputStream()) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String msg;
            while ((msg=bufferedReader.readLine()) != null) {
                System.out.println("client receive message: " + msg);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
