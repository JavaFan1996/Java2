package javafan.test1;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author java_fan
 * @create 2019-05-18 10:32
 */
public class CalendarTest {


    //calendar是抽象类
    @Test
    public void test(){
        //实例化
        //创建子类GregorianCalendar对象
        //调用静态方法getInstance()

        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getClass());



        //2.常用方法
        //get()

        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days); //18
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));


        //set()

        calendar.set(Calendar.DAY_OF_MONTH,22);
         days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);


        //add() 也可以减
        calendar.add(Calendar.DAY_OF_MONTH,3);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);



        //getTime() 日历类变成date
        System.out.println(calendar.getTime());
        //变成了sql下的日期
        java.sql.Date date1 = new java.sql.Date(calendar.getTime().getTime());
        System.out.println(date1);

        //setTime() date变成日历类
        Date date = new Date();


    }
}
