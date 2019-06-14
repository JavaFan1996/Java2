package com.atguigu.exer1;

/**
 * @author java_fan
 * @create 2019-05-20 13:03
 */
public class MyDate  implements Comparable{
    private int year;
    private int month;
    private int day;

    public MyDate(){



    }
    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof MyDate){
            MyDate m = (MyDate) o;
            int minusYear = this.getYear() - m.getYear();
            if(minusYear != 0){
                return minusYear;
            }
            int minusMonth = this.getMonth() - m.getMonth();
            if(minusMonth != 0 ){
                return minusMonth;
            }
            return this.getDay() - m.getDay();



        }else
        {
            throw new RuntimeException("数据类型不匹配");
        }
        }
    }

