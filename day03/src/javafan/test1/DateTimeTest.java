package javafan.test1;

import jdk.management.resource.ResourceType;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * jdk 8之前的日期时间的API测试
 * <p>
 * 1.system类中的currentTimeMillis()
 * 2.java.util.Date和java.sql.date
 * 3.simpleDateFormat
 * 4.Calender
 *
 * @author java_fan
 * @create 2019-05-17 13:25
 */
public class DateTimeTest {
    /*
    simpleDateFormat的使用：simpleDateFormat对日期date类的格式化和解析

    1.两个操作：
    1.1 格式化  日期 ---> z字符串
    1.2 解析    字符串 ---->日期

    2.simpleDateFormat的实例化
     */
    @Test
    public void testSimleDateFormat() throws ParseException {

        //实例化一
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        //格式化:日期---->字符串

        Date date = new Date();
        System.out.println(date);

        String format = simpleDateFormat.format(date);
        System.out.println(format);


        //解析:字符串--->日期
        String str = "19-5-17 下午1:37";
        Date parse = simpleDateFormat.parse(str);
        System.out.println(parse);

        //********************************
        //实例化二：调用带参的构造器
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //格式化
        String format1 = sdf.format(date);
        System.out.println(format1);


        //解析:要求字符串必须符合构造器中形参的结构，否则会抛异常
        Date parse1 = sdf.parse("2019-01-11 01:43:00");
        System.out.println(parse1);

    }
    /*
    练习一：字符串“2020-09-08”转换为Java.sql.Date
     */
    @Test
    public void testExer() throws ParseException {
        String birth = "2020-09-08";
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf1.parse(birth);
        System.out.println(date);
        java.sql.Date birthDate = new java.sql.Date(date.getTime());
        System.out.println(birthDate);


        if(birthDate instanceof java.sql.Date){
            System.out.println("ok");
        }
    }

    /*
    练习二：“三天打鱼，两天晒网” 1990-01-01开始，xxxx-xx-xx在干嘛？

    主要目的：求总天数？

     */
@Test
    public void testExer1(){
    String time1 = "1990-01-01";
    Scanner scanner = new Scanner(System.in);
    String s = scanner.next();
    System.out.println(s);
}

}
