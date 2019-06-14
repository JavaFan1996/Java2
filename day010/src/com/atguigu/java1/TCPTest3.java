package com.atguigu.java1;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author java_fan
 * @create 2019-05-26 15:17
 */
public class TCPTest3 {
    @Test
    public void client() throws IOException {
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),9999);
        OutputStream os = socket.getOutputStream();
        File file = new File("10.jpg");
        FileInputStream fis = new FileInputStream(file);

        byte[] buffer = new byte[20];
        int len;
        while ((len = fis.read(buffer))!=-1){
            os.write(buffer,0,len);
        }
        //关闭数据的输出，图片已经发送完成
        socket.shutdownOutput();


        InputStream is = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer1 = new byte[5];
        int len1;
        while ((len1=is.read(buffer1))!=-1){
            baos.write(buffer1,0,len1);

        }
        System.out.println(baos.toString());


        fis.close();
        os.close();
        socket.close();
        baos.close();
        is.close();


    }

    @Test
    public void server() throws IOException {
        ServerSocket ss = new ServerSocket(9999);
        Socket socket = ss.accept();
        InputStream is = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream(new File("tcp3.jpg"));
        byte[] buffer = new byte[20];
        int len;
        while ((len = is.read(buffer))!= -1){
            fos.write(buffer, 0, len);


        }
        System.out.println("接受成功，存放在："+new File("tcp.jpg").getAbsoluteFile());

        OutputStream os = socket.getOutputStream();
        os.write("你好，照片接受成功".getBytes());

        fos.close();
        is.close();
        socket.close();
        ss.close();
        os.close();


    }
}
