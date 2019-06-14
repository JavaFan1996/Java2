package test1;

import java.sql.SQLOutput;

/**
 * @author java_fan
 * @description
 * 1.创建一个实现了runnable接口的类
 * 2.实现类去实现runnable中的抽象方法
 * 3.创建实现类的对象
 * 4.将此对象作为参数传递到Thread类的构造器中，创建thread对象
 * 5.调用start（）
 *
 *
 * 比较创建线程的两种方式：
 * 开发中，优先选择实现runnable接口的方式
 * 1.没有了类的单继承性的局限性
 * 2.实现的方式更适合来处理对个线程共享数据的情况
 *
 * @create 2019-05-12 08:47
 */
public class ThreadTest1 {
    public static void main(String[] args) {
        MThread mThread = new MThread();
        Thread t1 = new Thread(mThread);
        t1.start();

        Thread t2 = new Thread(mThread);
        t2.start();

    }
}
class  MThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i  % 2 == 0){
                System.out.println(Thread.currentThread().getName()+" "+i);
            }

        }
    }
}
