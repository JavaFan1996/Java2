package test3;

/**
 * @author java_fan
 * @description  极有可能出现死锁
 *
 * 1.死锁的理解：不同的线程分别占用对方需要的同步资源不放弃，就形成死锁
 * 2.说明
 *   2.1 出现死锁后，不会出现异常，也不会出现提示，程序无法结束
 *   2.2
 * @create 2019-05-13 16:03
 */
public class ThreadTest {
    public static void main(String[] args) {
        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();


        new Thread(){
            public void run(){
                synchronized (s1){
                    s1.append("a");
                    s2.append("1");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }synchronized (s2){
                    s1.append("b");
                    s2.append("2");
                    System.out.println(s1);
                    System.out.println(s2);
                }
            }

        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (s2){
                    s1.append("c");
                    s2.append("3");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                synchronized (s1){
                    s1.append("d");
                    s2.append("4");

                    System.out.println(s1);
                    System.out.println(s2);
                }
            }
        }).start();
    }
}
