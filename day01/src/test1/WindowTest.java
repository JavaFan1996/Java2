package test1;

/**
 * @author java_fan
 * @description 创建三个窗口买票 总票数为100
 *              存在线程安全问题，待解决
 * @create 2019-05-12 08:22
 */
public class WindowTest {
    public static void main(String[] args) {
        Window t1 = new Window();
        Window t2 = new Window();
        Window t3 = new Window();

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");


        t1.start();
        t2.start();
        t3.start();

    }
}
class Window extends Thread{
    private static int ticket = 100; //数据只有一份 不加静态每个进程都有100张


    @Override
    public void run() {
        while (true){
            if(ticket > 0){
                System.out.println(Thread.currentThread().getName()+": 卖票，票号为"+ ticket );
                ticket--;
            }else {
                break;
            }
        }
    }
}
