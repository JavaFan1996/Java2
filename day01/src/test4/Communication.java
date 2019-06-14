package test4;

/**
 * @author java_fan
 * @description 线程通信的例子
 * wait（) 一旦执行此方法，当前进程就进入阻塞状态，并释放同步监视器
 * notify() 一旦执行此方法，就会唤醒一个被wait的线程，如果有多个wait线程，根据优先级
 * notifyAll() 唤醒所有wait进程
 *
 *
 * 说明：
 * 1.wait（） notify（）  notifyAll（） 只能出现在同步代码块和同步方法中  **lock** 都不可以
 * 2.这三个方法的调用者必须是同步代码块或者同步方法中的同步监视器
 *   否则会出现异常
 * 3.三个方法定义在object类中 因为是同步监视器来调用 ，而同步监视器可以是任何对象 所以只能在object
 *
 *
 * 面试题：sleep（）和wait（）的异同0=22222222222222222222222222222222222222222222222222222222222222222
 * 相同点：一旦执行此方法，都可以使得当前线程进入阻塞状态
 * 不同点：1.声明的位置不一样，Thread类中声明的sleep（）中  object中声明的wait（）
 *       2.调用的要求不同，sleep可以在r任何需要的场景下调用，wait必须在同步方法和同步代码块中
 *       3.关于是否释放同步监视器的问题：如果两个方法都是用在同步代码块和同步方法中，sleep方法不会释放锁，wait会释放锁
 *
 *
 * @create 2019-05-13 17:22
 */
public class Communication {
    public static void main(String[] args) {
        Number number = new Number();
        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);

        t1.setName("线程一");
        t2.setName("线程二");


        t1.start();
        t2.start();

    }
}

class Number implements Runnable {
    private int number = 1;

    @Override
    public void run() {

            while (true) {
                synchronized (this) {
                    //唤醒一个线程
                    notify();
                if (number <= 100) {
                    try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;
//                    Thread.yield(); 不会释放锁
                    try {
                        //使得调用如下wait()方法的线程进入阻塞状态 执行wait会释放锁
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }
}