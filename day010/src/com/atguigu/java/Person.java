package com.atguigu.java;

import java.io.Serializable;

/**
 *
 * Person 需要满足：
 * 需要要实现Serializable(表示接口)
 *需要当前类提供全局常量long serialVersionUID
 * 除了当前类Person类需要实现Serializable接口之外，还必须保证其内部属性
 * 也必须是可序列化的
 * 默认基本数据类型
 * @author java_fan
 * @create 2019-05-24 12:02
 */
public class Person implements Serializable {
    public static final long serialVersionUID = 428946513215L;
    private int age;
    private String name;

    public Person() {
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
