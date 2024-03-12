package com.study.xyl._21_BIO.demo6;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Client {
    public static void main(String[] args) throws IOException {
        try (InputStream i = Files.newInputStream(Paths.get("bio、nio、aio.pdf"));
             Socket socket = new Socket("127.0.0.1", 8888)) {
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeUTF(".pdf");
            byte[] bytes = new byte[1024];
            int len;
            while ((len = i.read(bytes))  > 0) {
                dataOutputStream.write(bytes, 0,len);
            }
            dataOutputStream.flush();
            socket.shutdownOutput();

        }

    }
}
