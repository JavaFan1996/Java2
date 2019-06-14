package com.atguigu.exer2;

import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.util.*;

/**
 * @author java_fan
 * @create 2019-05-21 11:31
 */
public class afterClassTest {
    public static void main(String[] args) {
        ArrayList list = new ArrayList(10);
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            System.out.println("请输入第"+(i+1)+"个整数");
            int next = scanner.nextInt();
            list.add(next);
        }
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Integer && o2 instanceof Integer){
                    Integer i1 = (Integer) o1;
                    Integer i2 = (Integer) o2;
                    return -Integer.compare(i1, i2);
                }else
                {
                    throw new RuntimeException("出错");
                }
            }
        });
        System.out.println(list);
    }


    @Test
    public void test1(){


        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add(789);
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
