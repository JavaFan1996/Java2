package com.atguigu.java1;

@MyAnnotation(value = "hi")
public class Person extends Creature<String> implements Comparable<String>, Myinterface {


    private String name;
    int age;
    public int id;


    public Person(){}
@MyAnnotation(value = "abc")
    private Person(String name) {
        this.name = name;
    }

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
@MyAnnotation
    private String show(String Nation) {
        System.out.println("我的国籍是" + Nation);
        return Nation;
    }


    public String diplay(String interests){

        return interests;

    }


    @Override
    public int compareTo(String o) {
        return 0;
    }

    @Override
    public void info() {
        System.out.println("我是一个人");
    }


    private static void showDesc(){
        System.out.println("王为民我爱你");

    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
