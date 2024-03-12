package com.study.xyl._21_BIO.demo4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.Buffer;

public class ServerRunnableTarget implements Runnable{
    private Socket socket;

    public ServerRunnableTarget (Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            InputStream inputStream = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String msg;
            while ((msg=bufferedReader.readLine()) != null) {
                System.out.println("服务段收到：" + msg);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
