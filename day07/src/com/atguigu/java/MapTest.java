package com.atguigu.java;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 一、map实现类的概述
 * |---------Map接口：双列数据，用于存储key-value对的数据，类似于“函数” y = f(x)
 *     |-------------HashMap: 作为主要实现类 线程不安全的 效率高 存储null的key和value
 *          --------------LinkedHashMap：保证遍历map元素时，可以按照添加的顺序实现遍历
 *                                       原因：在原有的hashMap底层结构基础上，添加了双向指针
 *    |--------------TreeMap：有序的 自然排序和定制排序
 *                            底层使用红黑树
 *    |-------------Hashtable:作为古老的实现类 线程不同步
 *          |---------Properties 常用来处理配置文件 key和value都是String类型
 *
 *
 * HashMap的底层：数组+链表（jdk7）
 *               数组+链表+红黑树（jdk8.0）
 *
 *
 * 面试题：
 * 1.HashMap的底层实现原理
 * 2.currentHashMap与HashMap
 *
 *
 *
 * 二、key-value结构：
 *
 *
 *
 *
 * @author java_fan
 * @create 2019-05-20 13:40
 */
public class MapTest {

    @Test
    public void test1(){
        Map map = new HashMap();
        map.put(2,123);
        map.put(2, 12);
        System.out.println(map);



    }


    @Test
    public void test2(){
        Map map = new LinkedHashMap(); // 有双向指针的数组存储数据
        map.put(123, 1996);
        map.put(123, 196);
        map.put(123, 96);
        map.put(123, 6);
        System.out.println(map);
    }
}
