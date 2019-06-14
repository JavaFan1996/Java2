package com.atguigu.java;

import org.junit.Test;

import java.util.*;

/**
 * @author java_fan
 * @create 2019-05-21 10:40
 */
public class TreeMapTest {

    //向TreeMap中添加key-value，要求key是同一个类创建的对象
    //按照KEy排序

    @Test
    public void test1(){
        TreeMap map = new TreeMap();
        Person p1 = new Person("Tom", 23);
        Person p2 = new Person("Jerry", 32);
        Person p3 = new Person("Jack", 20);
        Person p4 = new Person("Rose", 18);
        map.put(p1, 98);
        map.put(p2, 89);
        map.put(p3, 76);
        map.put(p4, 18);

        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println(entry.getKey()+"---------->"+entry.getValue());


        }


    }

    //定制排序
    @Test
    public void test2(){
        TreeMap map = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
               if(o1 instanceof Person && o2 instanceof Person){
                   Person p1 = (Person) o1;
                   Person p2 = (Person) o2;
                   return Integer.compare(p1.getAge(), p2.getAge());
               }else
               {
                   throw new RuntimeException("输入的类型不匹配");
               }
            }
        });
        Person p1 = new Person("Tom", 23);
        Person p2 = new Person("Jerry", 32);
        Person p3 = new Person("Jack", 20);
        Person p4 = new Person("Rose", 18);
        map.put(p1, 98);
        map.put(p2, 89);
        map.put(p3, 76);
        map.put(p4, 18);

        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println(entry.getKey()+"---------->"+entry.getValue());


        }
    }
}
