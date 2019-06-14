package com.atguigu.java;

import com.sun.org.apache.xpath.internal.operations.String;
import com.sun.xml.internal.bind.v2.model.core.BuiltinLeafInfo;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.util.RandomAccess;

/**
 * @author java_fan
 * @create 2019-05-26 13:46
 */
public class RandomAccessFileTest {
    @Test
    public void test1()  {
        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            raf1 = new RandomAccessFile(new File("10.jpg"), "r");
            raf2 = new RandomAccessFile(new File("12.jpg"), "rw");

            byte[] buffer = new byte[1024];
            int len;
            while ((len = raf1.read(buffer)) != -1) {

                raf2.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(raf2!=null) {
                try {
                    raf2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(raf1!=null) {
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }
    /**
    文件已经存在，从开头位置进行覆盖
     */
    @Test
    public void test2(){
        RandomAccessFile raf1 = null;
        try {
            raf1 = new RandomAccessFile(new File("hello.txt"), "rw");
            raf1.seek(new File("hello.txt").length());//将指针调整至3的位置
            raf1.write("ok".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(raf1!=null) {
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }
    /**
     * 使用randomAccessFile实现插入的效果
     */

    @Test
    public void test3() throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile(new File("hello.txt"), "rw");
        raf1.seek(3);
        StringBuilder builder = new StringBuilder((int) new File("hello.txt").length());
        byte[] buffer = new byte[20];
        int len;

        while ((len = raf1.read(buffer))!= -1){
//            builder.append(new String(buffer,0,len));


        }


    }


}


