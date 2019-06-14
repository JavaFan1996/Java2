package test3;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author java_fan
 * @description 1.解决线程安全问题方式三：Lock锁  JDK5.0新增
 * @create 2019-05-13 16:26
 * <p>
 * synchronized 与lock的异同
 * 相同点：都解决线程安全问题
 * 不同点：syn方法在执行完相应的同步代码后，自动释放同步监视器，lock需要手动启动同步（lock（））
 *       同时结束同步也需要手动实现（unlock（））
 * 使用：先用lock 和 同步代码块
 *
 *
 * 面试：如何解决线程安全问题？有几种
 * syn 和lock两种
 *
 */
class Window implements Runnable {
    private int ticket = 100;
    //1.实例化ReetrantLock
    private ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run() {
        while (true) {
            try {
                //lock.lock调用lock方法
                lock.lock();
                if (ticket > 0) {
                    try {


                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "售票，票号：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            } finally {
                //解锁 释放操作权
                lock.unlock();
            }
        }
    }
}

public class LockTest {
    public static void main(String[] args) {
        Window w = new Window();


        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);


        t1.start();
        t2.start();
        t3.start();
    }
}
