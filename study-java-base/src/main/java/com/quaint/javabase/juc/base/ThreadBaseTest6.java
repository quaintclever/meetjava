package com.quaint.javabase.juc.base;

import java.util.concurrent.TimeUnit;

/**
 * @author quaint
 * @since 2023/3/15 14:39
 */
public class ThreadBaseTest6 {

    public static void main(String[] args) throws InterruptedException {
        Thread d = new Thread(() -> {
            int i = 1;
            while (true) {
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                    System.out.println("第 " + i + " 次睡眠了100ms");
                    i++;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        d.setDaemon(true);
        d.start();

        TimeUnit.SECONDS.sleep(10);
        System.out.println("main end");
    }

}
