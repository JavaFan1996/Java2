package javafan.String;


import org.junit.Test;

/**
 * string常用方法的使用
 *
 * @author java_fan
 * @create 2019-05-15 19:00
 */
public class StringMethodTest {
    /*
      String replace(char oldchar ,char newchar)
     */
    @Test
    public void test4() {
         String s1 = "王伟民我爱你我";
        System.out.println(s1.replace('我', '你'));//王伟民你爱你你
        System.out.println(s1); //不变

        System.out.println(s1.replace("王伟民", "范志强"));

    }


    /*
    Boolean endWith(String str) 是否已str收尾
    Boolean startWith(String str) 是否已str开头
    Boolean startWith(String str，int int) 是否已在int位置以str开头

     */
    @Test
    public void test3() {
        String s1 = "helloworld";
        System.out.println(s1.endsWith("ld"));//true

        System.out.println(s1.startsWith("he"));//true
        System.out.println(s1.startsWith("ll", 2));//true

        System.out.println(s1.contains("wo")); //true 是不是包含“wo” 区分大小写
        System.out.println(s1.indexOf("lo")); //3首次该字符出现的索引位置，没有则-1
        System.out.println(s1.indexOf("lo", 5));//从index开始找

        String s2 = "hellorworld";
        System.out.println(s2.lastIndexOf("or"));//  7 从后往前找
        System.out.println(s2.lastIndexOf("or", 6));//4


    }

    @Test
    public void test2() {
        String s1 = "HELLOWORLD";
        String s2 = "helloworld";

        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));//忽略大小写

        // int compareTo  一个一个比较 相减，若是负的则小。正则大 0相等
        String s3 = "abc";
        String s4 = new String("abe");
        System.out.println(s3.compareTo(s4)); //-2


        String s5 = "王伟明范志强";
        String s6 = s5.substring(2);
        System.out.println(s6);//明范志强 从二开始
        System.out.println(s5.substring(0, 3)); //王伟明 不包含3这个位置

    }

    @Test
    public void test1() {
        String s1 = "HelloWorld";
        System.out.println(s1.length());

        //charAt(index) 获取指定索引的字符
        System.out.println(s1.charAt(0)); // h
        //isEmpty()
        System.out.println(s1.isEmpty());//是否为空false

        String s2 = s1.toLowerCase();//变小写
        System.out.println(s1); // s1不可变
        System.out.println(s2); //改成小写以后的字符串

        String s3 = " hello world ";
        String s4 = s3.trim();//忽略前后空格
        System.out.println(s3);
        System.out.println(s4);


    }
}
