package com.atguigu.java2;

import com.atguigu.java1.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;

/**
 * 获取运行时类的接口
 */
public class InterfaceTest {

    @Test
    public void test1(){
        Class clazz = Person.class;
        Class[] interfaces = clazz.getInterfaces();
        for (Class i:interfaces){
            System.out.println(i);
        }
        System.out.println("*********************");

        Class[] superinterfaces = clazz.getSuperclass().getInterfaces();
        for (Class s :superinterfaces){
            System.out.println(s);
        }


//        获取运行时类所在的包

        Package pack = clazz.getPackage();
        System.out.println(pack);

//        获取运行时类的注解

        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation a :annotations){

            System.out.println(a );
        }

    }

}
