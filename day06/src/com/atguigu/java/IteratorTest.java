package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

/**
 * 集合元素的遍历的操作，使用迭代器接口Iterator接口
 *
 * @author java_fan
 * @create 2019-05-19 11:47
 */
public class IteratorTest {

    @Test
    public void test() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("jer", 18));
        System.out.println(coll);

        Iterator iterator = coll.iterator();
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
        //报异常 NoSuchElementException
//        System.out.println(iterator.next());

        //方式二
        for (int i = 1; i < coll.size(); i++) {
            System.out.println(iterator.next());
        }

        //方式三：推介

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }
    @Test
    public void test2(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("jer", 18));

        Iterator iterator = coll.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    @Test
    public void test3(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("jer", 18));
        System.out.println(coll);

        //删除集合中“Tom”
        Iterator iterator = coll.iterator();
        while(iterator.hasNext()){
            Object obj = iterator.next();
            if("Tom".equals(obj)){
                iterator.remove();
            }
        }
        Iterator iterator1 = coll.iterator();
        while(iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
        System.out.println(coll);

    }
}
