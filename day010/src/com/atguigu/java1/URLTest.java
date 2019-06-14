package com.atguigu.java1;

import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * URL的网络编程
 * URL统一资源定位符
 * 格式：
 * http://localhost:8080/examples/hello.txt？username=Tom
 * 协议    主机名   端口号  资源地址            参数列表
 * @author java_fan
 * @create 2019-05-27 11:38
 */
public class URLTest {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://localhost:8080/examples/10.jpg");
            System.out.println(url.getProtocol());
            System.out.println(url.getHost());
            System.out.println(url.getPath());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } finally {
        }

    }
}
