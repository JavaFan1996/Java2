package test5;

import java.util.concurrent.*;

/**
 * 创建线程方式四：使用线程池
 *
 *
 * 创建多个线程有几种方式：四种： 继承 实现runnable 实现callable 线程池
 * @author java_fan
 * @create 2019-05-14 12:43
 */

class NumberThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println("线程一 " + i);
            }
        }
    }
}

class NumberTread1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println("线程二 " + i);
            }

        }
    }
}

class NumberThread2 implements Callable {
    @Override
    public Object call() throws Exception {
        for (int i = 0; i < 100; i++) {
            if (i % 20 == 0) {
                System.out.println("线程三 " + i);
            }
        }
        return null;
    }
}

public class ThreadPool {
    public static void main(String[] args) {
        //1.提供指定线程数量的线程池 service 是接口
        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service1 = (ThreadPoolExecutor)service;
        //设置线程池的属性
        System.out.println(service.getClass());// ThreadPoolExecutor
        service1.setCorePoolSize(15);
        service1.setMaximumPoolSize(50);
        //2.执行指定的线程的操作。需要提供实现Runnable接口或者Callable接口实现类的对象
        service1.execute(new NumberThread()); //适合使用于runnable 不用在传递进Thread构造器创建线程启动
        service1.execute(new NumberTread1());


        //对于实现callable接口实现类的操作
        //在callable创建线程中，要先创实现类的对象传递进FutureTask构造器这就是括号里面，就不用再传递进Thread类然后启动，这里就代替了
        service1.submit(new FutureTask(new NumberThread2()));
        //关闭线程池
        service1.shutdown();

    }
}
