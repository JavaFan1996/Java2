package com.atguigu.java;

import org.junit.Test;

import java.io.*;

/**
 * @author java_fan
 * @create 2019-05-23 11:46
 */
public class BufferedFileReaderAndWriterTest {


    @Test
    public void test(){
        //1.造文件
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            File srcFile = new File("dbcp.txt");
            File destFile = new File("BufferedTest.txt");
            //2.造流
            //2.1造字符流
            FileReader fr = new FileReader(srcFile);
            FileWriter fw = new FileWriter(destFile);

            //2.2造缓冲流
            br = new BufferedReader(fr);
            bw = new BufferedWriter(fw);
            //读写操作
            char[] cbuf = new char[5];
            int len;
            while((len = br.read(cbuf))!=-1){
                bw.write(cbuf,0,len);


            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        //4.资源关闭
            if(bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }



    }

}
