package com.atguigu.java;

import org.junit.Test;

import java.io.*;

/**
 * @author java_fan
 * @create 2019-05-22 17:47
 */
public class ReaderAndWriteTest {

    /**
     * 将day09下的hello。txt文件内容读入程序中，并输出 一定要执行关闭文件
     * 异常处理：try-catch
     * 读入文件一定要存在，否则就会报FileNotFoundException
     */
    @Test
    public void testFileRead() {
        //1.实例化file类的对象，指明操作的文件
        FileReader fr = null;
        try {
            File file = new File("hello.txt");
            //2.提供具体的流
            fr = new FileReader(file);
            //3.数据的读入
            //方式一
//        int data = fr.read();
//        while (data != -1){
//            System.out.print((char) data);
//            data = fr.read();
//        }
            //方式二
            int data;
            while ((data = fr.read()) != -1) {
                System.out.println((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            //4.流的关闭
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    /**
     * Reader()操作升级：使用read()的重载方法
     */
    @Test
    public void testFileReader1() throws IOException {
        //1.File类的实例化
        FileReader fr = null;
        try {
            File file = new File("hello.txt");
            //2.FileReader流的实例化
            fr = new FileReader(file);
            //3.读入的操作
            //fr.read(cbuf) 返回每次读入cubf数组中的字符个数。如果达到文件末尾，返回-1
            char[] cbuf = new char[5];
            int len;
            while ((len = fr.read(cbuf)) != -1) {
                //每次读进去几个，遍历几个，所以只能遍历len个
                for (int i = 0; i < len; i++) {
                    System.out.print(cbuf[i]);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源的关闭
            if (fr != null) {
                fr.close();
            }
        }


    }

    /*
    将内存中的数据写入文件中，
    说明：1.输出操作文件可以不存在，如果不存在可以自动生成
         2.如果文件存在，替代原有文件  FileWriter fw = new FileWriter(file,false);
           2.1 若是false直接覆盖
           2.2若是true则在文件中添加写入

     */
    @Test
    public void FileWrite() throws IOException {
        //提供FIle类的对象，即指出要操作的文件
        File file = new File("hello1.txt");
        //2.提供FileWrite的对象，用于写出的流
        FileWriter fw = new FileWriter(file, false);


        //3.写出操作
        fw.write("I,hava a dream\n");
        fw.write("you need to hava a dream!");

        fw.close();


    }



    /*
    不能使用字符流来处理图片等数据，只适用于字符操作
     */

    @Test
    public void testFileReaderFileWriter() {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            File file1 = new File("hello.txt");
            File file2 = new File("hello2.txt");

            fr = new FileReader(file1);
            fw = new FileWriter(file2);


            //读入和写出操作
            char[] cbuf = new char[5];
            int len;
            while ((len = fr.read(cbuf)) != -1) {
                //每次写出len个字符
                fw.write(cbuf, 0, len);


            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流资源
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }




}
