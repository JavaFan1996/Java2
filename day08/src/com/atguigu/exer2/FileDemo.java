package com.atguigu.exer2;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author shkstart
 * @create 2019 下午 4:56
 */
public class FileDemo {

    @Test
    public void test1() throws IOException {
        File file = new File("D:\\io\\io1\\hello.txt");
        boolean mkdirs = file.mkdirs();
        //创建一个与file同目录下的另外一个文件，文件名为：haha.txt
        File file1 = new File(file.getParent(), "haha.txt");
        boolean newFile = file1.createNewFile();
        if(newFile){
            System.out.println("ko");

        }
    }
}
