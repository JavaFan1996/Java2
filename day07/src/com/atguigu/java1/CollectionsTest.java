package com.atguigu.java1;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

/**
 * collections 是一个操作map和list的工具类
 *
 * @author java_fan
 * @create 2019-05-21 11:07
 */
public class CollectionsTest {
    @Test
    public void test1() {

        ArrayList list = new ArrayList();
        list.add(123);
        list.add(43);
        list.add(56);
        list.add(56);

        System.out.println(list);
//        Collections.reverse(list); 反转
//        Collections.shuffle(list);//随机
//        Collections.sort(list);
//        Collections.sort(list, new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                return 0;
//            }
//        });
//        Collections.swap(list,0,2);交换
        System.out.println(list);
        int frequency = Collections.frequency(list, 56);
        System.out.println(frequency);
    }

    @Test
    public void test2() {


        List list = new ArrayList();
        list.add(123);
        list.add(43);
        list.add(56);
        list.add(56);


        List dest = Arrays.asList(new Object[list.size()]);
//copy() 后面的赋值给前面的
        Collections.copy(dest,list);
        System.out.println(dest);

//返回的list1是线程安全的
        List list1 = Collections.synchronizedList(list);

    }
}
