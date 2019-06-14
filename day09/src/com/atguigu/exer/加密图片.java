package com.atguigu.exer;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author java_fan
 * @create 2019-05-23 14:24
 */
public class 加密图片 {


    //图片的加密
    @Test
    public void test1(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(new File("10.jpg"));
            fos = new FileOutputStream("加密测试");


            byte[] buffer = new byte[20];
            int len;
            while ((len = fis.read(buffer))!=-1){
                for (int i = 0; i <len;i++){
                    buffer[i] = (byte) (buffer[i] ^ 5);
                }
                fos.write(buffer);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis!= null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }if(fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    //图片的解密
    @Test
    public void test2(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(new File("加密测试"));
            fos = new FileOutputStream("图片解密.jpg");


            byte[] buffer = new byte[20];
            int len;
            while ((len = fis.read(buffer))!=-1){
                for (int i = 0; i <len;i++){
                    buffer[i] = (byte) (buffer[i] ^ 5);
                }
                fos.write(buffer);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis!= null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }if(fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

}
