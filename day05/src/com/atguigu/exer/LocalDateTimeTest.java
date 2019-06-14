package com.atguigu.exer;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;

/**
 * @author java_fan
 * @create 2019-05-18 22:48
 */
public class LocalDateTimeTest {
    public static void main(String[] args) throws ParseException {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.withDayOfMonth(2));
        System.out.println(localDateTime.plusDays(2));
        System.out.println(LocalDateTime.of(2020, 10, 6, 13, 23, 43));


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh-mm-ss");
        String format = formatter.format(localDateTime);
        System.out.println(format);

        TemporalAccessor parse = formatter.parse("2019-05-18 11-00-33");
        System.out.println(parse);

        System.out.println("--------------------------");
        Calendar instance = Calendar.getInstance();
        int i = instance.get(Calendar.DAY_OF_MONTH);
        Date time = instance.getTime();
        System.out.println(time);

        java.sql.Date date = new java.sql.Date(time.getTime());
        System.out.println(date);

        System.out.println("*******************************");

        Date date1 = new Date();
        System.out.println(date1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(sdf.format(date1));
        System.out.println(sdf.parse("2019-05-18 11:11:09"));

    }
}
