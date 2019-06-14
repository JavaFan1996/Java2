package javafan.exer2;

import javax.sound.midi.Soundbank;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author java_fan
 * @create 2019-05-17 14:59
 */
public class FishTest {
    public static void main(String[] args) throws ParseException {
        String time = "1990-01-01";
        Scanner scan = new Scanner(System.in);
        String s1 = scan.next();
        System.out.println(s1);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = sdf.parse(s1);
        Date date = sdf.parse(time);
//        System.out.println(date1.getTime()-date.getTime());
        int L = (int)(date1.getTime() - date.getTime())+1;

        int s = L % 5;
                switch (s){
                    case 0:
                        System.out.println("晒网");
                        break;
                    case 1:
                        System.out.println("打鱼");
                        break;
                    case 2:
                        System.out.println("打鱼");
                        break;
                    case 3:
                        System.out.println("打鱼");
                        break;
                    case 4:
                        System.out.println("晒网");
                        break;
                     default:
                         break;
                }

    }
}
