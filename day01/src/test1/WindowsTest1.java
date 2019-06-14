package test1;



/**
 * @author java_fan
 * @description 实现runnable接口的方式
 * 1.卖票过程中出现了错票和重票-->出现了线程的安全问题
 * 2.原因：当某个线程操作车票的过程中，操作尚未完成时，另外线程进来了
 * 3.如何解决：当一个线程A在操作共享数据时，其他线程不能参与进来，直到线程A操作完共享数据
 * 释放使用权，即使线程A出现了阻塞，也不能被改变
 * 4.在Java中通过同步机制来解决线程的安全问题
 * <p>
 * 方式一：同步代码块
 * synchronized(同步监视器){需要被同步的代码}
 * <p>
 * 说明：操作共享数据的代码即为需要被同步的代码  -->不能包含代码多了
 * <p>
 * 同步监视器：锁  任何类的对象都可以充当
 * 要求：多个线程公用同一把锁（只能创建一个实现runnable类的对象，这样才能保障只能有一个锁）
 * 补充：在使用实现runnable接口的方式的过程中，可以考虑使用this充当同步监视器
 *
 * 方式二：同步方法
 *    如果操作共享数据的代码完整的声明在一个方法中，我们不妨将此方法声明同步的
 *    注意：1.同步方法任然涉及到同步监视器，只是不需要我们显式的说明
 *         2.非静态的是this ，静态的同步方法是当前类本身
 *
 *
 * 5.同步的方式，解决了线程的安全问题；
 *             操作同步代码时，只能有一个线程参与，其他线程等待，相当于单线程的过程，效率低
 *
 * @create 2019-05-12 09:00
 */
public class WindowsTest1 {
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

class Window1 implements Runnable {
    private int ticket = 100; //只new了一个对象 所有票只有100张
   // Object object = new Object();

    @Override
    public void run() {
        while (true)
            synchronized (this) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ": 卖票，票号为" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
    }
}
