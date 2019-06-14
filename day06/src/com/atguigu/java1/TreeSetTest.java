package com.atguigu.java1;

import com.atguigu.java.Person;
import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author java_fan
 * @create 2019-05-20 11:15
 */
public class TreeSetTest {
    /*

    向TreeSet添加元素必须时同一个类的对象
    两种排序：自然排序和定制排序
     */
    @Test
    public void test1() {
        TreeSet set = new TreeSet();

//
//        set.add(123);
//        set.add(456);
//        set.add("AA");
//        set.add(new Person("Tom",12));

        set.add(123); // 都是int型 从小到大排列
        set.add(456);
        set.add(789);
        set.add(1);
//        Iterator iterator = set.iterator();
//        while(iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
        set.clear();

        set.add(new Person("Tom", 12));
        set.add(new Person("Tmiht", 13));
        set.add(new Person("Ak", 21));
        set.add(new Person("OK", 56));
        set.add(new Person("OK", 56));


        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

    @Test
    public void test2() {
        Comparator com = new Comparator() {

            //按照年龄从小到大排列，年龄一样不要了
            @Override
            public int compare(Object o1, Object o2) {
                  if(o1 instanceof Person && o2 instanceof Person){
                      Person p1 = (Person) o1;
                      Person p2 = (Person) o2;

                      return Integer.compare(p1.getAge(), p2.getAge());

                  }else
                  {
                      throw new RuntimeException("数据类型不匹配");
                  }
            }
        };

        TreeSet treeSet = new TreeSet(com);


        treeSet.add(new Person("Tom", 12));
        treeSet.add(new Person("Tmiht", 13));
        treeSet.add(new Person("Ak", 21));
        treeSet.add(new Person("OK", 56));
        treeSet.add(new Person("JB", 56));

        Iterator iterator = treeSet.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }
}
