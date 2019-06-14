package exer;

import com.sun.org.apache.regexp.internal.RE;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author java_fan
 * @description 有两个储户分别向同一个账户存3000元，每次存1000，存了三次
 * @create 2019-05-13 16:43
 */
public class AccountTest {
    public static void main(String[] args) {
        Account acct = new Account(0);
        Customer c1 = new Customer(acct);
        Customer c2 = new Customer(acct);

        c1.setName("甲");
        c2.setName("乙");

        c1.start();
        c2.start();


    }
}

class Account {
    private double balance;
  ReentrantLock lock = new ReentrantLock();

    public Account(double balance) {
        this.balance = balance;
    }

    //存钱
    public void deposit(double amt) {


        try {
            lock.lock();
            if (amt > 0) {
                balance += amt;

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "存钱成功，余额为：" + balance);
            }

        } finally {
            lock.unlock();
        }
    }
}

class Customer extends Thread {
    private Account account;


    public Customer(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            account.deposit(1000);

        }
    }
}