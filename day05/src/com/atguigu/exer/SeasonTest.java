package com.atguigu.exer;

import javax.swing.*;
import java.net.SocketTimeoutException;

/**
 * @author java_fan
 * @create 2019-05-18 22:32
 */
public class SeasonTest {
    public static void main(String[] args) {
        Season spring = Season.SPRING;
        System.out.println(spring);
        System.out.println(spring.getSeasonDesc());
        spring.show();
    }
}
interface Info{
    void show();
}
enum Season implements Info{
    SPRING("春天","穿暖花开"){
        @Override
        public void show() {
            System.out.println("spring");
        }
    },
    SUNMMER("夏天", "夏日炎炎"){
        @Override
        public void show() {
            System.out.println("sunmmer");
        }
    },
    AUTUMN("秋天", "秋高气爽"){
        @Override
        public void show() {
            System.out.println("aountun");
        }
    },
    WINTER("冬天","白雪皑皑"){
        @Override
        public void show() {
            System.out.println("winter");
        }
    };

    private final String seasonName;
    private final String seasonDesc;


    private Season(String seasonName,String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;


    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }
}