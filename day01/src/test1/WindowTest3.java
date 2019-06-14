package test1;

/**
 * @author java_fan
 * @description
 * @create 2019-05-13 10:15
 */
public class WindowTest3 {
    public static void main(String[] args) {
        Window1 w = new Window1();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");

        t1.start();
        t2.start();
        t3.start();


    }
}

class Window3 implements Runnable {
    private int ticket = 100; //只new了一个对象 所有票只有100张
    // Object object = new Object();

    @Override
    public void run() {
        while (true) {
            show();
        }
    }

    public synchronized void show() {
        while (true)

            if (ticket > 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ": 卖票，票号为" + ticket);
                ticket--;
            }
    }

}
