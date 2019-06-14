package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 *
 * 向实现类中添加数据obj时，要求obj所在类要重写equals方法
 * @author java_fan
 * @create 2019-05-19 11:05
 */
public class CollectionTest1 {

    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("jer", 18));


        //1.contains(object obj) 判断是否包含obj
        //在判断是会调用obj所在类的equals方法。自定义的类就要重写equals方法

        boolean contains = coll.contains(123);
        System.out.println(contains);
        System.out.println(coll.contains(new String("Tom")));  //true 调用的equals（）
        System.out.println(coll.contains(new Person("jer",18))); //false 重写equals就可以true

        //containsAll(Collection coll1) 判断coll1是否都在
        Collection coll1 = Arrays.asList(123, 456);
        System.out.println(coll.containsAll(coll1));  //true

    }


    @Test
    public void test2(){
        //2.remove(object ibj) 从当前集合中删除obj元素
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("jer", 18));

        boolean remove = coll.remove(123);
        System.out.println(remove);
        System.out.println(coll);
        coll.remove(new Person("jer", 18));
        System.out.println(coll);




        //3.removeAll(Collection coll1)  移除coll1中的所有元素
        Collection coll1 = Arrays.asList(123, 456);
        coll.removeAll(coll1);
        System.out.println(coll);



    }

    @Test
    public void test3(){

        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("jer", 18));

        Collection coll1 = Arrays.asList(123, 456,789);

        //4.retainAll( Collection coll1);  获取交集，并修改给this 保留一样的 删除不一样的
        boolean b = coll.retainAll(coll1);
        System.out.println(b);
        System.out.println(coll);

        //5.equals（object obj） 判断当前集合和形参是否一致

        Collection coll2 = new ArrayList();
        coll2.add(123);
        coll2.add(456);
        coll2.add(new String("Tom"));
        coll2.add(false);
        coll2.add(new Person("jer", 18));

        System.out.println(coll.equals(coll2));
    }


    @Test
    public void test4(){
        //6.hascode() 返回当前对象的哈希值
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("jer", 18));

        System.out.println(coll.hashCode());


        //7.集合----> 数组
        Object[] objects = coll.toArray();
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);

        }

        //8.数组转为集合asList()
        List<String> list = Arrays.asList(new String[]{"AA", "BB"});
        System.out.println(list);



        //9.
    }
}
