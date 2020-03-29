package com.quaint.javabase.juc.base;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Exchanger;
import java.util.concurrent.Phaser;
import java.util.concurrent.Semaphore;

/**
 * @author quaint
 * @date 29 March 2020
 * @since 1.26
 */
public class ThreadBaseTest3 {


    public static void main(String[] args) {

        Thread[] threads = new Thread[3];

        for (int i = 0; i < 3; i++) {
            threads[i] = new Thread(()->{
                for (int j = 0; j < 5; j++) {
                    System.out.print(j);
                }
                System.out.print("*");
            });
        }

        for (Thread t: threads) {
            t.start();
        }

        Map<String,String> map = new HashMap<>(16);

        // 测试 unsafe 方法 java8 已经禁用直接获取 单利对象
        // java.lang.SecurityException: Unsafe

//        Unsafe unsafe = Unsafe.getUnsafe();
//        System.out.println(unsafe);


    }

}
