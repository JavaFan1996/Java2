package com.atguigu.java1;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author java_fan
 * @create 2019-05-24 13:01
 */
public class InetAddressTest {

    public static void main(String[] args) {
        try {
            InetAddress inet1 = InetAddress.getByName("192.168.10.14");
            System.out.println(inet1);


            InetAddress localhost = InetAddress.getByName("localhost");
            System.out.println(localhost);
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(localHost);


            InetAddress inet2 = InetAddress.getByName("www.baidu.com");
            System.out.println(inet2);



        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
