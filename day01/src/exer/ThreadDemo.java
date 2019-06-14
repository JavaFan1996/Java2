package exer;

/**
 * @author java_fan
 * @description 创建两个分线程，一个遍历一百以内的偶数 一个遍历一百以内的基数
 * @create 2019-05-11 16:31
 */
public class ThreadDemo {
    public static void main(String[] args) {
//        MyThread1 myThread1 = new MyThread1();
//        MyThread2 myThread2 = new MyThread2();
//        myThread1.start();
//        myThread2.start();

        //创建thread类的匿名子类的方式
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 == 0){
                        System.out.println(Thread.currentThread().getName()+" "+ i);
                    }
                } ;
            }
        }.start();

    }
}

class MyThread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {

                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        }
    }
}

class MyThread2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        }
    }
}
