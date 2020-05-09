package com.quaint.algorithm.year2020.april;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author quaint
 * 04 April 2020
 * @since 1.26
 */
public class QuaintStudyRecord4 {



    public static void main(String[] args) {
        // 两个线程交替输出
        testA1B2();

    }

    /**
     * 创建两个线程
     * 1. ABCD...Z
     * 2. 1234...26
     * 两个线程交替输出
     */
    private static void testA1B2(){
        Lock lock = new ReentrantLock();
        Condition conditionT1 = lock.newCondition();
        Condition conditionT2 = lock.newCondition();

        Thread t1 = new Thread(()->{
            for (int i = 0; i < 26; i++) {
                lock.lock();
                System.out.print((char)(i+65)+" ");
                conditionT2.signal();
                try {
                    if (i<25){
                        conditionT1.await();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });

        Thread t2 = new Thread(()->{
            for (int i = 1; i <= 26; i++) {
                lock.lock();
                System.out.print(i+" ");
                conditionT1.signal();
                try {
                    if (i<26){
                        conditionT2.await();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });

        t1.start();
        t2.start();
    }

}
