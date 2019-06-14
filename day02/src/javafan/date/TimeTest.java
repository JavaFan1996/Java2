package javafan.date;

import org.junit.Test;


import java.util.Date;

/**
 * @author java_fan
 * @create 2019-05-16 10:38
 */
public class TimeTest {


    /*
    java.util.Data类
        ------java.sql.Data类

    1.两个构造器的使用
    Date date1 = new Date(); //当前时间
    Date date2 = new Date(1557974805983L);

    2.两个方法的使用
        toString():显式：当前的年月日时分秒 时区
        getTime():显式时间戳
    3.java.sql.Data类  数据库中的date对象
     > 如何实例化
     > util.Date对象如何转化sql.Date对象

     */


    @Test
    public void test2() {
        //构造器一：创建当前时间的date对象
        Date date1 = new Date();
        //Thu May 16 10:45:05 CST 2019
        System.out.println(date1.toString());
        //1557974805983
        System.out.println(date1.getTime());

        //构造器二：创建指定毫秒数的date对象，sout显式年月日。。。
        Date date2 = new Date(1557974805983L);
        System.out.println(date2);

        java.sql.Date date3 = new java.sql.Date(355555555555555L);
        System.out.println(date3);

        Date date4 = new java.sql.Date(2345662145896621L);
        java.sql.Date date5 = (java.sql.Date) date4;

//
//        Date date6 = new Date();
//        java.sql.Date date7 =(java.sql.Date)date6; 不能强转
        Date date6 = new Date();
        java.sql.Date date7 =new java.sql.Date(date6.getTime());
        System.out.println(date7);

    }

    //System类中的CurrentTimeMillis
    @Test
    public void test1() {
        long time = System.currentTimeMillis();
        //返回当前时间与1970年的之间的毫秒数
        System.out.println(time);
    }
}
