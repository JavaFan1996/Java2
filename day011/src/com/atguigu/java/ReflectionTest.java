package com.atguigu.java;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author java_fan
 * @create 2019-05-27 12:31
 */
public class ReflectionTest {

    //反射之前对于Person类的操作

    @Test
    public void teat1() {
        //1.实例化
        Person p1 = new Person("Tom", 18);
        //2.通过对象调用其内部的属性和方法
        p1.age = 10;
        System.out.println(p1);

        p1.show();
        //在Person类的外部不可以通过Person类的对象调用其内部私有的结构
        //比如：一个参数私有的构造器和name属性、showNatio()

    }

    /**
     *
     */
    @Test
    public void test2() throws Exception {
        Class clazz = Person.class;
        //通过反射，创建Person类的对象
        Constructor cons = clazz.getConstructor(String.class, int.class);

        Object obj = cons.newInstance("Tom", 12);
        //Person{age=12, name='Tom'} obj是一个Person
        System.out.println(obj.toString());
        Person p = (Person) obj;

        //2.通过反射对象指定的方法和属性

        Field age = clazz.getDeclaredField("age");
        age.set(p, 10);
        System.out.println(p);
        //3.调用方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p);
        System.out.println("********************************");

        //调用私有构造器
        Constructor cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p1 = (Person) cons1.newInstance("jerry");
        System.out.println(p1);


        //调用私有的属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1, "HanMeiMei");
        System.out.println(p1.toString());


        //调用私有方法
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(p1, "中国");
        System.out.println(nation);


    }
    /*
    关于Java.lang.Class类的理解
    1.类的加载过程
    程序经过java.exe命令以后，会生成一个或者多个字节码文件，然后使用java.exe对某个字节码文件进行解释运行，
    相当于将某个字节码文件加载到内存中，这个就是称为类的加载，加载到内存中的类，我们就称为运行时类，此运行
    时类，就作为Class的一个实例
    


  Class对应的就是一个运行是的类


     */

    //获取Class的实例方式(前三种方式需要掌握)
    @Test
    public void test3() throws ClassNotFoundException {
        //1.调用运行时类的属性
        Class clazz1 = Person.class;
        System.out.println(clazz1);

        //2.通过运行时类的对象,调用getClass()
        Person p1 = new Person();
        Class clazz2 = p1.getClass();
        System.out.println(clazz2);

        //3.调用Class的静态方法：forName(Stirng classPAth)
        Class clazz3 = Class.forName("com.atguigu.java.Person");

        System.out.println(clazz3);

        System.out.println(clazz1 == clazz2);


        System.out.println("************************");

        //使用类的加载器，classloader


        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class<?> clazz4 = classLoader.loadClass("com.atguigu.java.Person");
        System.out.println(clazz4);


    }





}
