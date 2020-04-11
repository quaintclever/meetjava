package com.quaint.javabase.java8;

import sun.misc.Contended;

/**
 * @author quaint
 * @since 11 April 2020
 */
public class ContendedTest {

//    @Contended
//    private static volatile long[] arr = new long[2];

    /**
     * 1.7 采用的是 long 数组, 每8个 为一个缓存行, 不会产生冲突
     * 需要加 JVM 参数  -XX:-RestrictContended
     */
    @Contended
    volatile long long1;

    @Contended
    volatile long long2;


    public static void main(String[] args) throws Exception{

        ContendedTest ct = new ContendedTest();
        long start = System.currentTimeMillis();
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 1_0000_0000L; i++) {
                ct.long1 = i;
            }
        });
        Thread t2 = new Thread(()->{
            for (int i = 0; i < 1_0000_0000L; i++) {
                ct.long2 = i;
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

}
