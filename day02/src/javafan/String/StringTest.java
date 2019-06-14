package javafan.String;

import org.junit.Test;

/**
 * @author java_fan
 * @create 2019-05-15 17:34
 */
public class StringTest {
    /*
    String的实例化方式

    方式一：字面量
    方式二：通过new 构造器

   面试题： String s = new String("abc");创建了几个对象
   两个：一个是堆空间中new结构，一个是char[]对应常量池中的数据“abc”

   intern方法：让变量在常量池中声明
   String  s = new String("tom");
   s.intern();//tom就变成在常量池中
     */
    @Test
    public void test2(){
        //放在方法区里的字符串常量池
        String s1 = "javaEE";
        String s2 = "javaEE";

        //放在堆空间
        String s3 = new String("javaEE");
        String s4 = new String("javaEE");


        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s4);
        System.out.println(s3 == s4);
        Person p1 = new Person("Tom",12);
        Person p2 = new Person("Tom",12);


        System.out.println(p1.name.equals(p2.name));
        System.out.println(p1.name == p2.name);  //对象中的属性都在堆空间 然后tom这个字符串还是在字符串常量池中，所以相等




    }


    /*
     *String :字符串，使用一=对“”表示
     * 1. String声明为final的，不可被继承
     * 2. 实现了Serializable接口，表示字符串是支持序列化的
     * 3. 实现comparable接口：表示String可以比较大小
     * 4. String在内部定义了final char[] value用于存储字符串数据
     * 5.String：代表不可变的字符序列。简称：不可变性
     *     当重新赋值时，会在字符串常量池中重新造
     *     当进行连接操作时，也是重新造，不能直接赋值
     *     证明String是不可变的，只要对字符进行任何修改都需要重新创造字符串
     *     常量与常量的拼接是在字符串常量池中，也不由相同的字符串存在
     *     只要有一个是变量，那么拼接以后就只能在堆空间之中
     *
     * 6. 通过字面量给一个字符串赋值，此时的字符串值声明在字符串常量池中。
     * 7. 字符串常量池中不会存储相同的字符串
     *
     */
    @Test
    public void test1(){

        String s1 = "abc";   //字面量
        String s2 = "abc";
        System.out.println(s1 == s2);//比较s1和s2的地址值
        s1 = "hello";
        System.out.println(s1);//hello
        System.out.println(s2);//abc
        String s4 = "abc";
        String s5 = s4.replace('a','m');
        System.out.println(s4); // abc
        System.out.println(s5); // mbc   证明String是不可变的，只要对字符进行任何修改都需要重新创造字符串
    }
}
