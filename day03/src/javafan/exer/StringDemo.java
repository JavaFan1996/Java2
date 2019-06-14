package javafan.exer;

/**
 * 反转指定位置
 *
 * @author java_fan
 * @create 2019-05-16 12:51
 */
public class StringDemo {
    static String s1 = "abcdefg";

    public static void main(String[] args) {

        System.out.println(reverse(s1, 0, 4));


    }

    public static String reverse(String str, int startIndex, int endIndex) {

        char[] arr = str.toCharArray();
        for (int x = startIndex, y = endIndex; x < y; x++, y--) {
            char temp = arr[x];
            arr[x] = arr[y];
            arr[y] = temp;
        }
        return new String(arr);

    }
}