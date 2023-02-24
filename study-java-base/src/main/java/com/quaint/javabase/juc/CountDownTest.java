package com.quaint.javabase.juc;

import java.util.concurrent.*;

public class CountDownTest {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch cdl = new CountDownLatch(3);
        ExecutorService es = new ThreadPoolExecutor(3, 3, 5, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3));

        for (int i = 0; i < 3; i++) {
            System.out.println("out: cdl count: " + cdl.getCount());
            es.execute(() -> {
                System.out.println("inner: cdl count: " + cdl.getCount());
            });
            cdl.countDown();
        }
        es.shutdown();
    }

}
