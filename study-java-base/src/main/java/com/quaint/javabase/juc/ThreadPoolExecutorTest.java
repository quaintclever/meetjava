package com.quaint.javabase.juc;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author quaint
 * 04 April 2020
 * @since 1.26
 */
public class ThreadPoolExecutorTest {

    public static void main(String[] args) throws Exception {


        Lock lock = new ReentrantLock();


        ThreadFactory namedThreadFactory = Executors.defaultThreadFactory();
        ExecutorService singleThreadPool = new ThreadPoolExecutor(2, 2,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

        singleThreadPool.execute(()-> {
            System.out.println(Thread.currentThread().getName()+ "  -->  thread1 尝试获取锁");
            lock.lock();
            System.out.println(Thread.currentThread().getName()+ "  -->  lock1");
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
            System.out.println(Thread.currentThread().getName()+"  -->  unlock1");
        });

        singleThreadPool.execute(()-> {
            System.out.println(Thread.currentThread().getName()+ "  -->  thread2 尝试获取锁");
            lock.lock();
            System.out.println(Thread.currentThread().getName()+ "  -->  lock2");
            lock.unlock();
            System.out.println(Thread.currentThread().getName()+"  -->  unlock2");
        });



        singleThreadPool.shutdown();

    }

}
