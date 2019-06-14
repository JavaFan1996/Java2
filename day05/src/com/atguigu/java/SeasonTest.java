package com.atguigu.java;

import javax.xml.transform.sax.SAXTransformerFactory;

/**
 * 一、枚举类的使用
 * <p>
 * 1.枚举类的理解：类的对象只有有限个，确定的。我们称此类为枚举类
 * 2.当定义一组常量，使用枚举类
 * 3.枚举类只有一个对象，就是单例模式
 * <p>
 * <p>
 * 二、如何定义枚举类
 * <p>
 * 方式一：jdk5.0之前，自定义枚举类
 * 方式二：使用enum关键字定义枚举类
 *
 *
 *
 * 三：Enum类中的常用方法:（见SeasonTest1）
 * values()
 * toString() 默认输出常量名称
 * valuesOf()
 *
 * 四、使用enum定义的枚举类实现接口
 * 4.1 实现接口，在enum类中实现抽象方法
 * 4.2 可以让枚举类的每一个对象分别实现接口中的抽象方法
 *
 * @author java_fan
 * @create 2019-05-18 17:14
 */
public class SeasonTest {
    public static void main(String[] args) {
        Season spring = Season.SPRING;
        System.out.println(spring);
    }


}

//定义枚举类
class Season {
    //1.声明Seanson对象的属性

    private final String seasonName;
    private final String seasonDesc;

    //2.私有化类的构造器
    private Season(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;

    }

    //3.提供当前枚举类的多个对象 public static final

    public static final Season SPRING = new Season("春天", "开花");
    public static final Season SUNMMER = new Season("夏天", "很热");
    public static final Season AUTUMN = new Season("秋天", "凉快");
    public static final Season WINTER = new Season("冬天", "下雪");

    //4.1获取枚举类的属性

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }
    //4.1提供toString()


    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}