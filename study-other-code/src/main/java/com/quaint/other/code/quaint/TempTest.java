package com.quaint.other.code.quaint;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author quaint
 * @date 23 March 2020
 * @since 1.38
 */
public class TempTest {

    public static void main(String[] args) throws Exception{
        final AtomicLong threadCount = new AtomicLong(0);
        ExecutorService executorService = new ThreadPoolExecutor(4, 4, 3L,
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, TempTest.class.getSimpleName() + "-" + threadCount.getAndIncrement());
            }
        });

        Future<Boolean> submit = executorService.submit(() -> {
            TimeUnit.SECONDS.sleep(1);
            return true;
        });

        System.out.println("=======start");
        System.out.println(submit.get());
        System.out.println("=======end");


    }

}
