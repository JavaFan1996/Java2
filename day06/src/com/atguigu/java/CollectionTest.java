package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

/**
 * 一、集合框架的概述：
 * 1.集合，和数组都是对多个数据仅从存储操作的结构----->Java容器
 * <p>
 * 2.1 数组在存储多个数据方面的特点：
 * 一旦初始化，其长度就确定了
 * 数组一旦确定好，其元素类型也就确定了
 * <p>
 * <p>
 * 2.2缺点：
 * 2.2.1   长度不可变
 * 2.2.2   数组中提供的方法非常有限，对于增删改查不方便，同时效率不高
 * 2.2.3   数组对于元素的实际个数不明确，无法直接使用
 * 2.2.4   数组必须有序、可重复。不能无序，不可重复
 * <p>
 * <p>
 * 二：集合框架
 * <p>
 * ------------Collection接口：单列集合，用来存储一个一个的对象
 * ---------list接口  ：有序的可重复的     “动态数组 可扩充”
 * --------ArrayList LinkedList Vector
 * ---------set ：无序的不可重复的数据    “     高中的集合         ”
 * ---------HashSet LinkedSet  TreeSet
 * <p>
 * -----------Map接口 ：双列集合，一对一对的集合  key-value
 * <p>
 * <p>
 * <p>
 * 三、Collection接口中的方法的使用
 *
 * @author java_fan
 * @create 2019-05-19 10:25
 */
public class CollectionTest {

    @Test

    public void test1(){
        Collection coll = new ArrayList();
        //add(object e) 将元素添加到集合coll中
        coll.add("aa");
        coll.add("BB");
        coll.add("CC");
        coll.add(123);//自动装箱
        coll.add(new Date());


        //size() 获取添加元素的个数
        System.out.println(coll.size()); //5

        //addAll(Collection coll1) 将集合添加进来
        Collection coll1 = new ArrayList();
        coll1.add("cc");
        coll1.add(456);

        coll.addAll(coll1);
        System.out.println(coll.size());//7
        System.out.println(coll);


        //clean（）清空元素
        coll1.clear();
        //isEmpty() 判断是否有元素
        System.out.println(coll1.isEmpty()); //true






    }
}
