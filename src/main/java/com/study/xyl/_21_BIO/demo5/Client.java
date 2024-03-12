package com.study.xyl._21_BIO.demo5;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.concurrent.ThreadPoolExecutor;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", 9999)) {
            ClientReaderThread clientReaderThread = new ClientReaderThread(socket);
            clientReaderThread.start();
            OutputStream outputStream = socket.getOutputStream();
            PrintStream printStream = new PrintStream(outputStream);
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String s = scanner.nextLine();
                printStream.println(s);
                printStream.flush();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
