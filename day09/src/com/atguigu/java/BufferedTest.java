package com.atguigu.java;

import org.junit.Test;

import java.io.*;

/**
 *
 * 处理流之一：作用在节点流上
 *
 * 1.缓冲流：
 * BufferedInputStream
 * BufferedOutputStream
 * BUfferedReader
 * BufferedWriter
 *
 * 2.作用：提高流的读取、写入速度
 * 内部提供了一个缓冲区
 *
 * 3.处理流套接在已有的流
 *
 *
 * @author java_fan
 * @create 2019-05-23 11:15
 */
public class BufferedTest {


    @Test
    public void BufferedStreamTest(){
//        FileInputStream fis = null;
//        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            File srcFile = new File("10.jpg");
            File destFile = new File("12.jpg");

            //2.1造节点流
            FileInputStream    fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);

            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);


            byte[] buffer = new byte[10];
            int len;
            while((len = bis.read(buffer)) != -1){
                bos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            //4.资源关闭
            //要求：先关闭外层的流
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }if(bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
//        //说明：在关闭外层的时候会自动关闭内层
//        fos.close();
//        fis.close();
        }


    }

public void copyFileWithBUffered(String srcPath,String destPath){

    BufferedInputStream bis = null;
    BufferedOutputStream bos = null;
    try {
        File srcFile = new File(srcPath);
        File destFile = new File(destPath);

        //2.1造节点流
        FileInputStream  fis = new FileInputStream(srcFile);
        FileOutputStream fos = new FileOutputStream(destFile);

        bis = new BufferedInputStream(fis);
        bos = new BufferedOutputStream(fos);


        byte[] buffer = new byte[1024];
        int len;
        while((len = bis.read(buffer)) != -1){
            bos.write(buffer,0,len);
        }
    } catch (IOException e) {
        e.printStackTrace();

    } finally {
        //4.资源关闭
        //要求：先关闭外层的流
        if (bos != null) {
            try {
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }if(bis != null) {
            try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//        //说明：在关闭外层的时候会自动关闭内层
//        fos.close();
//        fis.close();
    }

}


@Test
    public void testWithBUffered(){
    long start = System.currentTimeMillis();
    String srcPath = "E:\\视频\\视频一.avi";
    String destPath = "E:\\视频\\视频二.avi";

    copyFileWithBUffered(srcPath,destPath);
    long end = System.currentTimeMillis();
    System.out.println("复制时间："+(end-start));


}

}
