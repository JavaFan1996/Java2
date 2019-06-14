package com.atguigu.java;

import org.junit.Test;

import java.util.Random;

/**
 * @author java_fan
 * @create 2019-05-29 13:23
 */
public class NewInstanceTest {
    @Test
    public void test1() throws IllegalAccessException, InstantiationException {
        Class<Person> clazz = Person.class;
        /*
        newINstance():调用此方法，创建对应运行时类的对象，内部
        调用的还是Person的空参构造器。没有空参构造器就抛异常，空参
        构造器最小得是默认“default”

        要想此方法正常创建运行时类的对象;
        ① 运行时类必须提供空参的构造器
        ② 空参构造器权限的够，通常为public的


         */
        //空参构造器
        Person person = clazz.newInstance();


    }

    /**
     * 反射的动态性
     */
    @Test
    public void test2() throws Exception {
//        0,1,2
        int num = new Random().nextInt(3);
        String classPath = "";
        switch (num){
            case 0:
                classPath = "java.util.Date";
                break;
            case 1:
                classPath = "java.lang.Object";
                break;
            case 2:
                classPath = "com.atguigu.java.Person";
                break;
            default:

        }
        Object obj = getInstance(classPath);
        System.out.println(obj);


    }


   public Object getInstance(String classPath) throws  Exception {
       Class<?> clazz = Class.forName(classPath);
       return clazz.newInstance();


   }

}
