package test1;

/**
 * @author java_fan
 * @description 使用同步方法来解决通过继承来创建线程方法中的线程安全问题
 * @create 2019-05-13 10:24
 */
public class WindowsTest4 {
    public static void main(String[] args) {
        Windows2 w1 = new Windows2();
        Windows2 w2 = new Windows2();
        Windows2 w3 = new Windows2();

        w1.setName("窗口一");
        w2.setName("窗口二");
        w3.setName("窗口三");

        w1.start();
        w2.start();
        w3.start();
    }
}

class Windows4 extends Thread {
    /**
     * static 保证了只用一个锁 公用一个对象
     */
    private static int dicket = 100;
    //  private static Object object = new Object();


    @Override
    public  void run() {
        while (true) {
            // synchronized (Windows2.class){
            show();
        }
    }
//static 保证了公用同一个锁
    public static synchronized void show() {//同步监视器 window4.class
        if (dicket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ": 卖票，票号为" + dicket);
            dicket--;
        }
    }
}
//}
