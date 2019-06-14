package com.atguigu.java2;

import com.atguigu.java1.Person;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 获取当前运行时类的属性结构
 */
public class FieldTest {


    @Test
    public void test1() {
        Class clazz = Person.class;

//          获取属性结构getFields():只能获取自身和父类中public的属性
//        public int com.atguigu.java1.Person.id
//        public double com.atguigu.java1.Creature.weight
        Field[] fields = clazz.getFields();
        for (Field f : fields) {
            System.out.println(f);
        }


//        getDeclaredFields():获取当前运行时类的所有属性（不包括父类）
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(field);
        }


    }


    /**
     * 权限修饰符，数据类型 变量名
     * 都是静态的，非静态的要在创建对象时
     */
    @Test
    public void test2() {
        Class clazz = Person.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f : declaredFields) {
            //1.权限修饰符
            int modifiers = f.getModifiers();
            System.out.print(Modifier.toString(modifiers) + "\t");

            //2.数据类型
            Class<?> type = f.getType();
            System.out.print(type.getName() + "\t");

            //3.变量名
            String fName = f.getName();
            System.out.print(fName);
            System.out.println();

        }

    }
}
