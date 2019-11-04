package com.quaint.studyproject.amusement.sync;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @author: qi cong
 * @Date: Created in 2019/10/28 9:44
 */
public class Test05{

    public Lock lock = new ReentrantLock();

    public void fun(){

        lock.lock();
        System.out.println("start!");
        try {
            TimeUnit.SECONDS.sleep(3);
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("end!");
            lock.unlock();
        }
    }


    public static void main(String[] args) {

        Test05 test05 = new Test05();
        try {
            new Thread(test05::fun).start();
            new Thread(test05::fun).start();
            new Thread(test05::fun).start();
            new Thread(test05::fun).start();
            new Thread(test05::fun).start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
