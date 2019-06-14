package com.atguigu.java2;

import com.atguigu.java1.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 获取构造器的结构
 */
public class OtherTest {

    @Test
    public void Test1() {
        Class clazz = Person.class;


//        获取当前运行时类和其父类的public 构造器
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor c : constructors) {
            System.out.println(c);
        }
        System.out.println();

//       获取当前运行时类的所有构造器
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor c : declaredConstructors) {


            System.out.println(c);
        }

    }
    /*
    获取运行时类的父类
     */
    @Test
    public void test2() {


        Class clazz = Person.class;

        Class superclass = clazz.getSuperclass();
        System.out.println(superclass);
    }

    /*
    获取带泛型的父类
     */


    @Test
    public void test3(){
        Class clazz = Person.class;
        Type genericSuperclass = clazz.getGenericSuperclass();
        System.out.println(genericSuperclass);


    }
    /*
    获取父类额泛型
     */
    @Test
    public void test4() {

        Class clazz = Person.class;
        Type genericSuperclass = clazz.getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        //获取泛型参数
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        for (Type a :actualTypeArguments){
            System.out.println(a.getTypeName());
        }

    }
}