package com.study.xyl._21_BIO.demo7;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * 客户端上传文件给服务端保存
 */
public class Client {
    public static void main(String[] args) {
        try(InputStream is = Files.newInputStream(Paths.get("D:\\BOOK\\SpringCloud第3季2024.html"))) {
            //1. 请求与服务端的socket连接
            Socket socket = new Socket("127.0.0.1", 8888);
            //2. 把字节输出流包装成一个数据输出流（DataOutputStream可以分段数据发送）
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            //3. 先发送上传文件的后缀给服务器
            dos.writeUTF(".html");
            //4. 把文件数据发送给服务端进行接收
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) > 0) {
                dos.write(buffer, 0 ,len);
            }
            dos.flush();
            //通知服务端，客户端的数据已经发送完毕
            socket.shutdownOutput();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
