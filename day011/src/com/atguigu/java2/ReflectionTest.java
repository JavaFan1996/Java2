package com.atguigu.java2;

import com.atguigu.java1.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 调用运行时类指定的结构：属性，方法，构造器
 *
 *
 */
public class ReflectionTest {

    /*
    获取的时public 的，不方便使用
     */
    @Test
    public  void test1() throws Exception {
        Class clazz = Person.class;
//        创建运行时类的对象
        Person p = (Person) clazz.newInstance();
        Field id = clazz.getField("id");
        /*
        设置当前属性的值
         */
        id.set(p, 1001);
        int Pid = (int) id.get(p);
        System.out.println(Pid);

    }

    /*
    如何惭怍运行时类中指定名的属性
     */
    @Test
    public void test2() throws Exception {
        Class clazz = Person.class;
        //创建运行时类的对象
        Person p = (Person) clazz.newInstance();
        //clazz.getDeclaredField("name") ：获取运行时类中指定变量名的属性
        Field name = clazz.getDeclaredField("name");
        //2.保证当前属性时可以访问的
        name.setAccessible(true);
        name.set(p, "Tom");
        System.out.println(name.get(p));

    }
    /*
    如何操作运行时类中指定变量名的方法
     */
    @Test
    public void test3()  throws Exception{
        Class clazz = Person.class;
        //创建运行时类的对象
        Person p = (Person) clazz.newInstance();

        Method show = clazz.getDeclaredMethod("show", String.class);
        show.setAccessible(true);
        String Nation = (String) show.invoke(p, "中国");

        System.out.println("*******如何调用静态方法********");
        Method showDesc = clazz.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
        Object returnVal = showDesc.invoke(clazz);
        //null
        System.out.println(returnVal);


    }
    /*
    如何调用运行时类中指定的构造器
     */
    @Test
    public void test4() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = Person.class;
        Constructor constructor = clazz.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);
        Person per = (Person) constructor.newInstance("Tom");
        System.out.println(per);


        System.out.println("*********************");
        Person p = (Person) clazz.newInstance();
        System.out.println(p);


    }

}
