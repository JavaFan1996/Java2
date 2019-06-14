package com.atguigu.java1;

import org.junit.Test;
import sun.util.resources.hr.CalendarData_hr;

import java.io.*;
import java.util.Arrays;

/**
 * 处理流之二：转换流的使用
 *
 * 1.转换流
 *
 *    InputStreamReader  将字节的输入流转化为字符的输入流
 *    OutputStreamWriter 将一个字符的输出流转化为字节的输出流
 *
 *
 * 2.提供字节流与字符流之间的转换
 *
 *
 * 3.字符集：utf-8 gbk utf-32
 *
 *
 * @author java_fan
 * @create 2019-05-23 14:42
 */
public class InputStreamReaderTest {


    @Test
    public  void teat1() throws IOException {
        FileInputStream fis = new FileInputStream("dbcp.txt");
        InputStreamReader isr = new InputStreamReader(fis,"utf-8");

        char[] cbuf = new char[20];
        int len;
        while((len = isr.read(cbuf))!= -1){
            String str = new String(cbuf, 0, len);
            System.out.println(str);

        }


    }

    /**
     * 综合使用 InputStreamReader  将字节的输入流转化为字符的输入流
     *  *      OutputStreamWriter 将一个字符的输出流转化为字节的输出流
     */
    @Test
    public void test2() throws IOException {
        File file1 = new File("dbcp.txt");
        File file2 = new File("dbcp_.txt");

        FileInputStream fis = new FileInputStream(file1);
        FileOutputStream fos = new FileOutputStream(file2);


        InputStreamReader isr = new InputStreamReader(fis, "utf-8");
        OutputStreamWriter osw = new OutputStreamWriter(fos,"gbk");


        char[] cbuf = new char[20];
        int len;
        while ((len = isr.read(cbuf)) != -1){
            osw.write(cbuf,0,len);
        }

        isr.close();
        osw.close();

    }

    @Test
    public void test4() throws IOException {

        FileReader fis = new FileReader("dbcp.txt");
        char[] cbuf = new char[1024];
        int len;
        while ((len = fis.read(cbuf))!= -1){
            String str = new String(cbuf, 0, len);
            System.out.println(str);
        }
    }
    @Test
    public void test1(){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(new File("10.jpg")));
            bos = new BufferedOutputStream(new FileOutputStream(new File("15.jpg")));

            byte[] buffer = new byte[1024];
            int len;
            while((len = bis.read(buffer)) !=-1){
                bos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bos != null) {
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
        }

    }

    @Test
    public void test5(){
        InputStreamReader isr = null;
        try {
            FileInputStream fis = new FileInputStream("hello.txt");
            isr = new InputStreamReader(fis, "utf-8");

            char[] cbuf = new char[1024];
            int len;
            while ((len = isr.read(cbuf))!= -1){
                String str = new String(cbuf, 0, len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(isr !=null) {
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }



}
