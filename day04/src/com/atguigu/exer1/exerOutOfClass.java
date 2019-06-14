package com.atguigu.exer1;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

/**
 * @author java_fan
 * @create 2019-05-18 15:45
 */
public class exerOutOfClass {
    //1.	将字符串”2017-08-16”转换为对应的java.sql.Date类的对象。

    @Test
    public void test1() throws ParseException {
        String str = "2018-01-18";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(str);
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        System.out.println(sqlDate);
    }

    /*
    2 自定义Person类如下，如何实现自然排序（按姓名从小到大排序），代码说明
     */
    @Test
    public void test2() {
        Person[] p = new Person[3];
        p[0] = new Person("fanzhiqiang");
        p[1] = new Person("wangweiming");
        p[2] = new Person("mimi");

        Arrays.sort(p);
        System.out.println(Arrays.toString(p));


    }

    /*
    3. 提供定制排序涉及到的接口的实现类对象，并按Person类的年龄从大到小排序
     */
    @Test
    public void test3(){
        Person[] p = new Person[3];
        p[0] = new Person("fanzhiqiang");
        p[1] = new Person("wangweiming");
        p[2] = new Person("mimi");

        Arrays.sort(p, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Person && o2 instanceof Person){
                    Person s1 = (Person) o1;
                    Person s2 = (Person) o2;

                    return -s1.name.compareTo(s2.name);
                }else
                {
                    throw new RuntimeException("数据出错");}
            }
        });
        System.out.println(Arrays.toString(p));
    }

}

class Person implements Comparable {
   public  String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Person) {
            Person n = (Person) o;
            return this.name.compareTo(n.name);
        } else {
            throw new RuntimeException("数据类型出错");
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}