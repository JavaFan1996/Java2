package com.atguigu.java;

import java.util.Arrays;

/**
 * 使用enum关键字来定义枚举类
 * 说明：使用enum定义的枚举类extends java.lang.Enum
 *
 * @author java_fan
 * @create 2019-05-18 17:32
 */
public class SeasonTest1 {
    public static void main(String[] args) {
        Season1 sunmmer = Season1.SUNMMER;

        System.out.println(sunmmer); //SUNMMER

        Season1[] values = Season1.values();
        System.out.println(Arrays.toString(values));//[SPRING, SUNMMER, AUTUMN, WINTER]

        //valueOf（String objName） 根据提供的objName：返回枚举类中对象名是objNanme的对象
        //如果没有找到objName的枚举类对象
        Season1 winter = Season1.valueOf("WINTER");
//        Season1 winter = Season1.valueOf("WINTER1");
        System.out.println(winter);
        winter.show();
    }


}


interface Info{
    void show();

}
//使用enum关键字定义枚举类
enum Season1 implements Info{
    //1.提供当前枚举类的多个对象 public static final

    SPRING("春天", "开花"){
        @Override
        public void show() {
            System.out.println("小燕子");
        }
    },
    SUNMMER("夏天", "很热"){  @Override
    public void show() {
        System.out.println("冰西瓜");
    }},
    AUTUMN("秋天", "凉快"){  @Override
    public void show() {
        System.out.println("秋天不回来");
    }},
    WINTER("冬天", "下雪"){  @Override
    public void show() {
        System.out.println("大约在冬季");
    }};
    //1.声明Seanson对象的属性

    private final String seasonName;
    private final String seasonDesc;

    //2.私有化类的构造器
    private Season1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;

    }


    //4.1获取枚举类的属性

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

//  4.1提供toString()
//    @Override
//    public String toString() {
//        return "Season{" +
//                "seasonName='" + seasonName + '\'' +
//                ", seasonDesc='" + seasonDesc + '\'' +
//                '}';
//    }


    @Override
    public void show() {
        System.out.println("这是一个季节");
    }
}