package com.atguigu.java1;

import com.atguigu.java.Person;
import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;

/**
 * 二：集合框架
 * * <p>
 * * ------------Collection接口：单列集合，用来存储一个一个的对象
 * * ---------list接口  ：有序的可重复的     “动态数组 可扩充”
 * ----ArrayList ： 作为List主要实现类  线程不安全的，执行效率高 底层使用Object[]存储
 * ---LinkedList ： 对于频繁的插入与删除使用；底层使用的是双向链表的结构，便于插入与删除
 * ---Vector  ：作为List的古老实现类  线程安全的  效率低下 基本不用
 * <p>
 * -----------set接口 无序的、不可重复的数据
 * ------HashSet实现类 ：主要实现类；线程不安全的；可以存储null值 根据哈希值来存放
 * ------LinkedHashSet实现类：是HashSet的子类 ；在数据的增加了指针，遍历数据时可以按照你指定的顺序来的，
 * <p>
 * ------TreeSet:使用二叉树存储 ；要求必须是同一个类的对象，可以按照对象的某些属性来排序
 * <p>
 * <p>
 * 三者之间的异同
 * 相同点:都实现List接口 存储的数据特点相同
 *
 * @author java_fan
 * @create 2019-05-19 14:38
 */
public class SetTest {
    /*
 一  Set：存储的数据无序和不可重复


    HashSet为例：     “都没有重新写的方法”
    1.无序性：不等于随机性，存储的数据在底层数组中并非按照数组的索引的顺序添加，而是按照数据的哈希值来存放


    2.不可重复性：保证添加的元素按照equals（）判断时，不能返回true：

二、添加元素的过程，以HashSet为例：
       向HashSet添加元素a,首先调用元素所在类的hashcode（）方法，计算其的哈希值，通过某种算法计算出元素在hashSet底层数组中的存放
       位置，位置上若没有元素直接添加成功，若有判断a.equals(b)是否为true，若不为true挂在后面（链表），true则添加失败



      HashSet   数组+链表
     */

    @Test
    public void test() {


        HashSet hashSet = new HashSet();
        hashSet.add(123);
        hashSet.add(456);
        hashSet.add("AA");
        hashSet.add("CC");
        hashSet.add(new Person("Tom", 12)); //重写了hascode（）方法
        hashSet.add(456);
        hashSet.add(129);
        hashSet.add(new Person("Tom", 12));
        Iterator iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


    }








}
