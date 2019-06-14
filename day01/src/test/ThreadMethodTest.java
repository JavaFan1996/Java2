package test;

/**
 * @author java_fan
 * @description 测试thread类中常用方法
 *
 * @create 2019-05-11 16:43
 *
 *
 * 1.start（）： 1.启动当前线程；2.调用当前线程的run（）方法
 * 2.run（）：通常需要重写thread类中的此方法；将创建线程要执行的操作声明在此方法里
 * 3.currentThread() 静态方法：返回当前代码的线程
 * 4.yield() 释放当前cpu的执行权
 * 5.join() 在线程A中调用线程B的join（）方法，此时线程A就进入阻塞状态，直到线程B完全执行后，线程A才结束阻塞状态
 * 6.sleep（long millitime）让当前线程睡眠指定的millitime毫秒数。在指定时间内是阻塞状态
 * 7.isAlive 判断是否还存活
 *
 * 线程的优先级：
 * 1.MAX_PROORITTY : 10
 * 2.MINI_PROORITTY ：1
 * 3.NORM_PROORITTY:5
 *
 * getprooritty();
 * setprooritty();
 */
class HelloThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i <100 ; i++) {
            if(i % 2 == 0){
                try {
                    sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() +" "+getPriority()+ " "+ i);
            }
            if(i % 20 == 0){
                yield();
            }

        }
    }
    public HelloThread(String name){
        super(name);

    }
}
public class ThreadMethodTest {
    public static void main(String[] args) {
        HelloThread h1 = new HelloThread("Thread_one");
//        h1.setName("线程一");
        h1.setPriority(10);
        h1.start();


        //给主线程命名
        Thread.currentThread().setName("主线程");
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() +" "+Thread.currentThread().getPriority()+ " "+ i);
            }
            if (i == 20){
                try {
                    h1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(h1.isAlive());
    }
}
