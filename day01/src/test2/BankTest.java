package test2;

/**
 * @author java_fan
 * @description 使用同步机制将单例模式中的懒汉式改写为线程安全的
 * @create 2019-05-13 15:40
 */
public class BankTest {
    public static void main(String[] args) {
    }
}

class Bank {

    private Bank() {

    }

    private static Bank instance = null;

    // public synchronized static Bank getInstance() { //同步代码的方法来解决线程安全
    public static Bank getInstance() {
//        //方式一：效率差
//        synchronized (Bank.class) {
//            if (instance == null) {
//                instance = new Bank();
//            }
//            return instance;
//        }
        //效率更高
        if(instance == null){
            synchronized (Bank.class){
                if(instance == null){
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}