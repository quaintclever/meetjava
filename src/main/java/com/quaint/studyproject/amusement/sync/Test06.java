package com.quaint.studyproject.amusement.sync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: 对比公平锁 和非公平锁
 * @author: qi cong
 * @Date: Created in 2019/10/29 9:21
 */
public class Test06 {

    public Lock lock = new ReentrantLock(true);

    void fun(){
        int i = 0;
        while (i<100){
            lock.lock();
            System.out.println(Thread.currentThread().getName());
            i++;
            lock.unlock();
        }
    }

    public static void main(String[] args) {

        Test06 test06 = new Test06();

        Thread t1 = new Thread(test06::fun);
        Thread t2 = new Thread(test06::fun);
        t1.start();
        t2.start();

    }
    
}
