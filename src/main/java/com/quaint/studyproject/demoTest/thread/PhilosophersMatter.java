package com.quaint.studyproject.demoTest.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @Description: 哲学家就餐 线程实验
 * @author: qi cong
 * @Date: Created in 2019/10/24 11:42
 */
public class PhilosophersMatter {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(5);

        Chopsticks c1 = new Chopsticks("1",true);
        Chopsticks c2 = new Chopsticks("2",true);
        Chopsticks c3 = new Chopsticks("3",true);
        Chopsticks c4 = new Chopsticks("4",true);
        Chopsticks c5 = new Chopsticks("5",true);

        Waiter waiter = new Waiter();
        waiter.setLeftCount(0);

        Philosopher p1 = new Philosopher(c1,c2, countDownLatch,waiter);
        Philosopher p2 = new Philosopher(c2,c3, countDownLatch,waiter);
        Philosopher p3 = new Philosopher(c3,c4, countDownLatch,waiter);
        Philosopher p4 = new Philosopher(c4,c5, countDownLatch,waiter);
        Philosopher p5 = new Philosopher(c5,c1, countDownLatch,waiter);

        new Thread(p1).start();
        System.out.println("p1 start");
        new Thread(p2).start();
        System.out.println("p2 start");
        new Thread(p3).start();
        System.out.println("p3 start");
        new Thread(p4).start();
        System.out.println("p4 start");
        new Thread(p5).start();
        System.out.println("p5 start");

        // 同时启动线程
        countDownLatch.countDown();


    }

}
