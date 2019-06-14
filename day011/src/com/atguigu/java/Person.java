package com.atguigu.java;

/**
 * @author java_fan
 * @create 2019-05-27 12:31
 */
public class Person {
    private String name;
    public int age;

    public Person() {
        System.out.println("空参构造器");
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Person(String name) {
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
    public void show(){
        System.out.println("一个人");

    }

    private String showNation(String Nation){
        System.out.println("我的国籍是"+Nation);
        return Nation;

    }
}
