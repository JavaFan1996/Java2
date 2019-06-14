package com.atguigu.java1;


import org.junit.Test;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 自定义注解：
 * 参照 @SuppressWarnings
 * 1.声明：@interface XXX {}
 * 2.内部成员，通常使用value来表示
 * 3.可以指定成员的默认值，使用default定义
 * 4.没有成员，则表示该 注解是一个标记
 *
 * 如果有成员，则在使用注解时，需要指定成员的值
 *
 * 5.jdk 提供的四种元注解
 * 5.1修饰现有的注解的  --->元注解
 * Retention：知名修饰的annotation的生命周期(SOURCE/CLASS/RUNTIME)
 *            只有声明为runtime的注解才能通过反射获取  @Retention(RetentionPolicy.RUNTIME)
 *
 * Target:@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE}) 能用于修饰那些元素
 * ********出现频率低********
 * Documented：表示所修饰的注解在被javadoc解析时，被保留下来
 *
 * Inherited：所修饰的注解具有继承性
 *
 * 5.通过反射获取注解信息------到反射内容看
 *
 *
 * 6.jdk8.0中注解的新特性
 * 6.1  可重复注解
 *
 *
 * 6.2  类型注解
 *
 *
 *
 * @author java_fan
 * @create 2019-05-18 18:22
 */
public class AnnotationTest {
    public static void main(String[] args) {
       @SuppressWarnings("unuesd")
        int num = 10;
        @SuppressWarnings({"unused","rawtypes"})
        ArrayList list = new ArrayList();

    }
}

@MyAnnocation(value = "hello")
class Person {
    private String name;
    private int age;

    public Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void walk() {
        System.out.println("走路");
    }

    public void eat() {
        System.out.println("人吃饭");
    }
}

interface Info {
    void show();
}

class Student extends Person implements Info {
    @Override
    public void walk() {
        super.walk();
    }

    @Override
    public void eat() {
        super.eat();
    }

    @Override
    public void show() {

    }

    @Test
    public void testGetAnnotation(){
        Class aClass = Student.class;
        Annotation[] annotation = aClass.getAnnotations();
        System.out.println(Arrays.toString(annotation));

    }

}