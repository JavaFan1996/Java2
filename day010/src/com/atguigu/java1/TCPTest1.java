package com.atguigu.java1;

import com.sun.beans.editors.ByteEditor;
import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 实现TCP的网络编程
 * 例子一：客户端发送信息给服务端，服务端：接受信息，在控制台上显式
 *
 * @author java_fan
 * @create 2019-05-24 13:13
 */
public class TCPTest1 {


    /**
     * 客户端
     * 客户端发送信息给服务端
     */
    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        try {
            /**
             * 创建Socket对象，指明服务器端的IP和端口号
             */
            InetAddress inet = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inet, 9090);

            /*
               获取输出流，用于输出数据
             */
            os = socket.getOutputStream();
            /*
            写出数据
             */
            os.write("你好客户端".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * 服务端：接受信息，在控制台上显式
     */

    @Test
    public void server() {
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            /*
            1.创建ServerSocket，指明自己的端口号
             */
            ss = new ServerSocket(9090);
             //2.调用accept（），表明可以接受数据
            socket = ss.accept();

            //3.获取输入流
            is = socket.getInputStream();
//        不推荐写，有乱码可能
//        byte[] buff = new byte[1024];
//        int len;
//        while ((len = is.read(buff))!=-1){
//            String str = new String(buff, 0, len);
//            System.out.println(str);
//
//
//        }

            //读取数据
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[5];
            int len;
            while ((len = is.read(buffer)) != -1) {

                baos.write(buffer, 0, len);
            }
            System.out.println(baos.toString());
            System.out.println(socket.getInetAddress().getHostAddress());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ss != null) {
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
