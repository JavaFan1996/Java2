package com.atguigu.java1;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 例子二：发送文件给服务器端
 *
 * @author java_fan
 * @create 2019-05-24 13:30
 */
public class TCPTest2 {
    @Test
    public void client() throws IOException {
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),9090);
        OutputStream os = socket.getOutputStream();
        File file = new File("10.jpg");
        FileInputStream fis = new FileInputStream(file);

        byte[] buffer = new byte[20];
        int len;
        while ((len = fis.read(buffer))!=-1){
            os.write(buffer,0,len);
        }



        fis.close();
        os.close();
        socket.close();


    }

    @Test
    public void server() throws IOException {
        ServerSocket ss = new ServerSocket(9090);
        Socket socket = ss.accept();
        InputStream is = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream(new File("tcp.jpg"));
        byte[] buffer = new byte[20];
        int len;
        while ((len = is.read(buffer))!= -1){
            fos.write(buffer, 0, len);


        }
        System.out.println("接受成功，存放在："+new File("tcp.jpg").getAbsoluteFile());



        fos.close();
        is.close();
        socket.close();
        ss.close();


    }
}
