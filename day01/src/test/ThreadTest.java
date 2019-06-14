package test;

/**
 * @author java_fan
 * @description
 * @create 2019-05-11 16:06
 */

/**
 * 多线程的创建，方式一：继承于thread类
 * 1.创建一个继承与thread类的子类
 * 2.重写Thread类的run（）；-->将此线程执行的操作声明在run（）中
 * 3.创建子类的对象
 * 4.通过对象调用star（）；
 */

//例子：遍历100以内的偶数
//1.创建一个继承与thread类的子类
class MyThread extends Thread {
    //2.重写Thread类的run（）；-->将此线程执行的操作声明在run（）中
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName()+" "+i);
            }
        }
    }
}


public class ThreadTest {
    public static void main(String[] args) {
        //3.创建子类的对象
        MyThread t1 = new MyThread();
        //4.通过对象调用star（）：1.启动当前线程 2.调用当前线程的run（）
        //上面的新线程执行
        t1.start();
        //问题一：不能通过直接调用run方法来启动线程
//        t1.run();

        //问题二：再启动一个线程，遍历一百以内的线程,不可以还让start（）的线程去执行 ，会报非法状态异常
//        t1.start();
        MyThread t2 = new MyThread();
        t2.start();

//如下操作任然是在main线程中执行
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i + "***********");
            }
        }
    }
}
