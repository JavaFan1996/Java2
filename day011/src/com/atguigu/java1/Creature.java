package com.atguigu.java1;

import java.io.Serializable;

public class Creature<T> implements Serializable {
    private char gender;
    public double weight;
    public static final long serialVersionUID = 428946513215L;

    private void breath(){
        System.out.println("生物呼吸");
    }

    public void eat(){
        System.out.println("生物吃东西");
    }
}
