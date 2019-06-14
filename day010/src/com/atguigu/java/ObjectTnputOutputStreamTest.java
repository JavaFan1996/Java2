package com.atguigu.java;

import org.junit.Test;

import java.io.*;

/**
 * 对象流的使用
 * <p>
 * 1.ObjectInputStream和ObjectOutputStream
 * 2.用于存取和读取基本数据类型或者对象的处理流
 *
 * @author java_fan
 * @create 2019-05-24 11:49
 */
public class ObjectTnputOutputStreamTest {
    /*

    序列化过程：将内存中的Java对象保存到磁盘中或者通过网络传输出去
     */
    @Test

    public void testObjectOutputStream() {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("object.dat"));
            //可以是已存在的一个对象
            oos.writeObject(new String("我爱王伟明"));

            oos.flush();

            oos.writeObject(new Person(18,"wangweiming"));
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    /*
    反序列化过程
     */
    @Test
    public void ObjectInputStream(){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("object.dat"));
            Object obj = ois.readObject();
            String str = (String) obj;
            System.out.println(str);
            Person p = (Person) ois.readObject();
            System.out.println(p);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(ois !=null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }




    }


}
