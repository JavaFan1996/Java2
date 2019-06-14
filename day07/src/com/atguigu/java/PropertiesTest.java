package com.atguigu.java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * @author java_fan
 * @create 2019-05-21 10:53
 */
public class PropertiesTest {
    //Properties 处理配置文件
    public static void main(String[] args) throws Exception {
        Properties pros = new Properties();
        FileInputStream fis = new FileInputStream("jdbc.properties");
        pros.load(fis);

        String name = pros.getProperty("name");
        String pass = pros.getProperty("pass");
        System.out.println(name);
        System.out.println(pass);
    }
}
