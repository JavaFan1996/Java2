package javafan.String;

import org.junit.Test;

/**
 * StringBuffer 和 StringBuilder
 *
 * @author java_fan
 * @create 2019-05-16 9:40
 * <p>
 * 面试题:三者异同
 * String ：不可变的字符序列
 * StringBuffer 可变的字符序列；线程安全的，效率低
 * StringBuilder 可变的字符序列；线程不安全，但效率高
 * 都用char[]数组存储
 */
public class StringBufferBuilderTest {


    @Test
    public void test() {
        StringBuffer sb1 = new StringBuffer("abc");
        sb1.setCharAt(0, 'm');
        System.out.println(sb1);
    }

    //StringBuffer方法
   /*
   增：StringBuffer append（）
   删：delete（int start，int end）
   改：setCharAt(int n,char ch) // replace(int start,int end,String str)
   查：charAt(int n)
   插：insert（int offset,xxx）
   遍历：for()+charAt()
   反转：    reverse（）
    */
    @Test
    public void test2() {
        StringBuffer s1 = new StringBuffer("abc");
        s1.append(1);
        s1.append('1');
        System.out.println(s1);
        s1.delete(2, 4);    //左闭右开
        System.out.println(s1); // StringBuffer是可以变的
        System.out.println(s1.replace(2, 4, "c1"));
        System.out.println(s1.insert(2, false));
        System.out.println(s1.length()); //9


        StringBuffer s2 = new StringBuffer("123");
        System.out.println(s2.reverse());
        String s3 = s2.substring(0, 2);
        System.out.println(s3);


    }
}
