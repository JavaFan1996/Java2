package com.atguigu.java1;

import com.atguigu.java.Person;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 二：集合框架
 * * <p>
 * * ------------Collection接口：单列集合，用来存储一个一个的对象
 * * ---------list接口  ：有序的可重复的     “动态数组 可扩充”
 * ----ArrayList ： 作为List主要实现类  线程不安全的，执行效率高 底层使用Object[]存储
 * ---LinkedList ： 对于频繁的插入与删除使用；底层使用的是双向链表的结构，便于插入与删除
 * ---Vector  ：作为List的古老实现类  线程安全的  效率低下 基本不用
 * <p>
 * <p>
 * 三者之间的异同
 * 相同点:都实现List接口 存储的数据特点相同
 * <p>
 * <p>
 * <p>
 * //总结：常用方法：
 * 增：add(Object obj)
 * 删:remove(int index) remove(Object obj)
 * 改：set(int index,Object obj)
 * 查：get(int index)
 * 插入；add(int index,Object obj)
 * 长度：size（）
 * 遍历：① Iterator迭代器
 * ② 增强for循环
 * ③ 普通for
 *
 * @author java_fan
 * @create 2019-05-19 12:58
 */
public class ListTest {
    //jdk7 创建了数组，然后不够再扩容1.5    类似于饿汉式
    @Test
    public void test1() {
        ArrayList list = new ArrayList(100);
        list.add(123);
        for (Object obj : list) {
            System.out.println(obj);
        }
    }
    //jdk8 先不创建 第一次才添加的时候再创建默认长度为10的数组，然后再扩容（不够的情况下）
    //类似于单例模式的懒汉式

    @Test
    public void test2() {
        LinkedList linkedList = new LinkedList();


    }

    @Test
    public void test3() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("Tom", 12));
        list.add(456);
//add()
        System.out.println(list);
        list.add(1, "BB");

        System.out.println(list);//[123, BB, 456, AA, Person{name='Tom', age=12}, 456]

        //addAll(int index,Collection else) 从index位置开始添加else中所有元素
        List list1 = Arrays.asList(1, 2, 3);
        list.addAll(list1);
        System.out.println(list.size()); //9
        boolean b = list.addAll(2, list1);
        System.out.println(list); // [123, BB, 1, 2, 3, 456, AA, Person{name='Tom', age=12}, 456, 1, 2, 3]

//get(int index)获取index元素
        System.out.println(list.get(0));


    }

    @Test
    public void test4() {

        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("Tom", 12));
        list.add(456);

//indexOf(Object obj) obj在集合中第一次出现的位置
        int i = list.indexOf(456);
        System.out.println(i);

        //lastindexof() 最后一次

        System.out.println(list.lastIndexOf(456));//4

        //remove(int index)
        Object remove = list.remove(0);//返回删除位置上的元素
        System.out.println(remove);
        System.out.println(list);


        //set(int  index,Object obj)

        list.set(0, "CC");
        System.out.println(list);


        //subList(int fromIndex,int toINdex) 左闭右开的子集合
        //本身不会改变

        List list1 = list.subList(2, 4);
        System.out.println(list1);
        System.out.println(list);


    }

    @Test
    public void test5() {

        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        //方式一
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


        //方式二:增强for循环
        for (Object obj : list) {
            System.out.println(obj);
        }

        //for()


        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
