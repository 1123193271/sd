package com.study.xyl._21_BIO.demo3;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        try(Socket socket = new Socket("127.0.0.1", 9999)) {
            OutputStream os = socket.getOutputStream();
            PrintStream ps = new PrintStream(os);
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("请输入");
                String s = scanner.nextLine();
                ps.println(s);
                ps.flush();
            }
        }
    }
}