package test5;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的方式三：实现callable接口
 * 如何理解实现callable接口创建多线程的方式比实现runnable接口创建多线程方式强大
 * call（）可有返回值
 * call（）可以抛出异常，被外面操作捕获
 * callable支持泛型
 *
 * @author java_fan
 * @create 2019-05-14 11:19
 */
//1.创建一个实现callable的实现类
class NumThread implements Callable{
    //2.实现call方法，将此线程需要执行的操作声明在call（）方法中
    @Override
    public Object call() throws Exception {
        int sum =0 ;
        for (int i = 1; i <= 100; i++) {
            if(i %2 ==0){
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }

}
public class ThreadNew {
    public static void main(String[] args) {
        //3.创建callable接口实现类的对象
        NumThread numThread = new NumThread();
        //4.将此callable实现类的对象作为参数传递到FutureTask构造器中，创建FutrueTask的对象
        FutureTask futureTask = new FutureTask(numThread);
        //5.将TutrueTask的对象作为参数传递到Thread类的构造器，创建Thread对象，并调用start（）方法
        new Thread(futureTask).start(); //如果下面没写没有返回sum


        try {
            //【6.get获取call方法的返回值，不需要怎么不用写】
            Object sum = futureTask.get();
            System.out.println(sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
