package com.study.xyl._21_BIO.demo6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.UUID;

public class ServerReadThread implements Runnable{
    private Socket socket;

    public ServerReadThread(Socket socket) {
        this.socket = socket;
    }


    @Override
    public void run() {
        try {
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            String suffix = dis.readUTF();
            System.out.println("服务端已经接收到文件类型：" + suffix);
            FileOutputStream fileOutputStream = new FileOutputStream("data\\" + UUID.randomUUID().toString() + suffix);
            byte[] bytes = new byte[1024];
            int len;
            while ((len = dis.read(bytes)) > 0) {
                fileOutputStream.write(bytes, 0 ,len);
            }
            fileOutputStream.close();
            System.out.println("服务段接受文件保存成功");
        }catch (IOException e) {
            e.printStackTrace();
        }


    }
}

