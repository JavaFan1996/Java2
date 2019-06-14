package javafan.String;

import com.sun.xml.internal.bind.v2.runtime.RuntimeUtil;
import org.junit.Test;

/**
 * 涉及到String类与其他结构之间的转换
 *
 * @author java_fan
 * @create 2019-05-15 20:17
 */
public class StringTest1 {
    /*
    String 与char[] 之间的转换

     */
    @Test
    public void test2() {
        String s1 = "abc";
        char[] chars = s1.toCharArray();


        char[] arr = new char[]{'h', 'a'};
        String s3 = new String(arr);
        System.out.println(s3);


        String str = "abc123";
        char[] arr1 = str.toCharArray();
        for (int i = 1; i < 4; i++) {
            for (int j = 4;j> i;j--){
                char temple = arr1[i];
                arr1[i] = arr1[j];
                arr1[j] =  temple;

            }
        }

        for (int i = 0; i <arr1.length ; i++) {
            System.out.print(arr1[i]);
        }

    }


    /*String 与基本数据类型、包装类之间的转换
      将基本数据类型和包装类转换为String
    */
    @Test
    public void test() {
        String s1 = "123";
        int num = Integer.parseInt(s1);


        String s2 = String.valueOf(num);
        String s3 = num + "";
        System.out.println(s2 == s3);

    }
}
