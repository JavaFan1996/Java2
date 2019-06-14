package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 *
 * jdk5.0新增了 foreach循环，用来遍历集合
 * @author java_fan
 * @create 2019-05-19 12:28
 */
public class ForTest {

    @Test
    public void test1(){

        //第二种遍历方式
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);

        coll.add(new Person("jer", 18));

        //遍历数组
        Person[] p = new Person[4];
        p[0] = new Person("范志强", 18);
        p[1] = new Person("范志强", 19);
        p[2] = new Person("范志强", 20);
        p[3] = new Person("范志强", 21);
        for (Person person: p){
            System.out.println(person);
        }


        //for(集合中元素类型 局部变量（随便写） ：集合对象)
        //内部任然还是迭代器
        for (Object obj:coll){
            System.out.println(obj);
        }
    }


    @Test
    public void test3(){
        String[] str = new String[]{"MM", "MM", "MM"};
        for (int i = 0; i < str.length; i++) {
            str[i] = "GG";
        }
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }


        //不会改变原有的数据 只是S的值在变
        for (String s:str){
            s = "MM";
        }
        for (String s:str){
            System.out.println(s);
        }
    }

}
