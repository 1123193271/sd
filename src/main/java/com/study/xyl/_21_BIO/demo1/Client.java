package com.study.xyl._21_BIO.demo1;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        try(Socket socket = new Socket("127.0.0.1", 9999)) {
            OutputStream os = socket.getOutputStream();
            PrintStream ps = new PrintStream(os);
            ps.println("Hello world! Server");
            ps.flush();
        }
    }
}
