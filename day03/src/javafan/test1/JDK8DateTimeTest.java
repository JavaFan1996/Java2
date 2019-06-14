package javafan.test1;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * JDK8之后引用了新的api，  "java.time"
 *
 * @author java_fan
 * @create 2019-05-18 10:54
 */
public class JDK8DateTimeTest {
    @Test
    public void testDate() {
        Date date = new Date(2020, 8, 8);
        System.out.println(date); //Wed Sep 08 00:00:00 CST 3920  偏移了 因为从1990年开始的b
    }


    /*
    LocalDate\LocalTime\LocalDateTime
    想要实例化则可以now()或者of()  都是静态方法 可以直接调用
     */

    @Test
    public void test1() {
        //now() 获取当前日期、时间、日期加时间
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        //of() :设置指定的日期加时间 没有偏移量

        LocalDateTime localDateTime1 = localDateTime.of(2020, 10, 10, 15, 10, 54);
        System.out.println(localDateTime1);


        //get()Xxx
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfYear());
        System.out.println(localDateTime.getMinute());
        System.out.println(localDateTime.getMonthValue());  //真的5月


        //with（） 设置时间的相关属性
        //返回值是localdatetime，不可变性，返回的是修改的，但是原先的不变
        LocalDateTime localDateTime2 = localDateTime.withDayOfMonth(22);
        System.out.println(localDateTime);
        System.out.println(localDateTime2);

        LocalDateTime localDateTime3 = localDateTime.withHour(4);
        System.out.println(localDateTime);
        System.out.println(localDateTime3);

        //plus()   添加，加几周，天，年
        LocalDateTime localDateTime4 = localDateTime.plusDays(1);
        System.out.println(localDateTime);
        System.out.println(localDateTime4);


        //minus()

        LocalDateTime localDateTime5 = localDateTime.minusDays(5);
        System.out.println(localDateTime);
        System.out.println(localDateTime5);


    }
    /*
    instant的使用
     */


    @Test
    public void test2() {
        //now() 获取本初子午线对应的标准时间
        Instant instant = Instant.now();
        System.out.println(instant);  //2019-05-18T04:59:16.863Z 时区的问题


        //根据时区获取时间的偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);


        //toEpochMilli() 获取从1970年1月1日开始的毫秒数
        System.out.println(instant.toEpochMilli());

        //通过给定的毫秒数，获取Instant的实例
        Instant instant1 = Instant.ofEpochMilli(155555555552156L);
        System.out.println(instant1);


    }
    /*
    DateTimeFormatter:格式化或者解析日期、时间
     */


    @Test
    public void test3() {
        //方式一：预定义的标准格式
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //格式化  日期--->字符串
        LocalDateTime localDateTime = LocalDateTime.now();
        String str1 = formatter.format(localDateTime);
        System.out.println(localDateTime);
        System.out.println(str1);


        //解析

        TemporalAccessor parse = formatter.parse("2019-05-18T13:11:39.575");
        System.out.println(parse);

        //方式二： ofLocalizedDateTime()

        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        //格式化
        String str2 = formatter1.format(localDateTime);
        System.out.println(str2);//19-5-18 下午1:16(short) 2019年5月18日 下午01时16分28秒(long)


        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);//full是格式好多格式，自己选

        //格式化
        LocalDate localDate = LocalDate.now();
        String str3 = formatter2.format(localDate);
        System.out.println(str3); //2019年5月18日 星期六(Full)


        TemporalAccessor parse1 = formatter2.parse("2019年5月18日 星期六");
        System.out.println(parse1);




        /*
        重点：ofPattern("YYYY-MM-dd hh:mm:ss")
         */

        System.out.println("**********************重点*************************");
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");

        //格式化
        String str4 = formatter3.format(LocalDateTime.now());
        System.out.println(str4);


        //解析
        TemporalAccessor parse2 = formatter3.parse("2019-05-18 01:24:29");
        System.out.println(parse2);


    }


}
