package com.atguigu.java;

import org.junit.Test;

import java.io.*;

/**
 * @author java_fan
 * @create 2019-05-23 9:59
 */

/**
 * 测试FileInputStream和FileOutputStream的使用
 *
 *
 * 结论：
 * 1.对于文本文件（.txt/java/c/cpp）可以用字符流
 * 2.对非文本文件（jpg/mp3/m94.....）用字节流
 *
 */
public class FileInputOutputStreamTest {
    @Test
    public void testInputStream() throws IOException {
        File file = new File("hello.txt");


        FileInputStream fi = new FileInputStream(file);

        byte[] b = new byte[5];
        int len;
        while ((len = fi.read(b)) != -1) {
            String str = new String(b, 0, len);
            System.out.print(str);
        }

        fi.close();
    }


    @Test
    public void testCopyJpg()  {
        FileInputStream fi = null;
        FileOutputStream fo = null;
        try {
            File file1 = new File("10.jpg");
            File file2 = new File("11.jpg");


            fi = new FileInputStream(file1);
            fo = new FileOutputStream(file2);

            byte[] bytes = new byte[5];
            int len;
            while ((len = fi.read(bytes)) != -1) {
                fo.write(bytes, 0, len);


            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {if(fi != null) {
                fi.close();
            }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {if(fo !=null) {
                fo.close();
            }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }



    @Test
    public void test1(){
        String srcString = "E:\\视频\\视频一.avi";
        String decsPath = "E:\\视频\\视频3.avi";
        long start = System.currentTimeMillis();
        copyFile(srcString,decsPath);
        long end = System.currentTimeMillis();
        System.out.println(end - start);


    }
    public void copyFile(String srcPath,String destPath){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);

            //
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            //复制的过程
            byte[] buffer = new byte[1024];
            int len;
            while((len = fis.read(buffer)) != -1){
                fos.write(buffer,0,len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fos != null){
                //
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }


    }

}
