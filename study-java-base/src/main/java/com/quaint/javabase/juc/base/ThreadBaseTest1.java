package com.quaint.javabase.juc.base;

import java.util.concurrent.locks.LockSupport;

/**
 * @author quaint
 * @date 29 March 2020
 */
public class ThreadBaseTest1 {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            // 暂时让出cpu, 进入到就绪队列
            Thread.yield();
            // 暂停当前线程
            LockSupport.park();
            System.out.println("这里是t1");
        });

        Thread t2 = new Thread(() -> {
            // 打断 t1线程
//            t1.interrupt();
            LockSupport.unpark(t1);
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("这里是t2");
        });

        t2.start();
        t1.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test");
    }
}
