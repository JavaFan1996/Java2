package com.atguigu.java;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author java_fan
 * @create 2019-05-24 12:46
 */
public class FileUtilesTest {

    public static void main(String[] args) {
        try {
            FileUtils.copyFile(new File("day010\\10.jpg"),new File("day010\\11.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
