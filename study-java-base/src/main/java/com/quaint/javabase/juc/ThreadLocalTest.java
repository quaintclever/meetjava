package com.quaint.javabase.juc;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author quaint
 * @since 06 April 2020
 */
public class ThreadLocalTest {


    public static void main(String[] args) {

        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("quaint");
        new Thread(()->{
            threadLocal.set("thread one");
            System.out.println("thread1:"+threadLocal.get());
        }).start();
        new Thread(()->{
            threadLocal.set("thread two");
            System.out.println("thread2:"+threadLocal.get());
        }).start();

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1,2,
                1L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(1),
                Thread::new,new ThreadPoolExecutor.CallerRunsPolicy());
        poolExecutor.allowCoreThreadTimeOut(true);

        poolExecutor.execute(()->{
            threadLocal.set("thread service1");
            System.out.println("executor1:"+threadLocal.get());
        });

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        poolExecutor.execute(()->{
            System.out.println("executor2:"+threadLocal.get());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        poolExecutor.execute(()->{
            System.out.println("executor3:"+threadLocal.get());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        poolExecutor.execute(()->{
            System.out.println("executor4:"+threadLocal.get());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        poolExecutor.execute(()->{
            System.out.println("executor5:"+threadLocal.get());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        poolExecutor.execute(()->{
            System.out.println("executor6:"+threadLocal.get());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        poolExecutor.shutdown();
        System.out.println("main:"+threadLocal.get());

    }


}
