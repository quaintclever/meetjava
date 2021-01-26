package com.quaint.javabase.juc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 * desc:
 * </p>
 *
 * @author quaint
 * @since 23 January 2021
 */
@SuppressWarnings("all")
public class LockTest {

    private Map<String, String> cache = new HashMap<>();
    private Set<String> loading = new HashSet<>();
    private Lock lock = new ReentrantLock();
    private Condition same = lock.newCondition();


    public static void main(String[] args) {
        LockTest lt = new LockTest();
        AtomicInteger count = new AtomicInteger(1000);
        for (int i = 0; i < 30; i++) {
            if (i % 10 == 0) {
                count.addAndGet(1);
            }
            new Thread(()->{
                try {
                    lt.select("code:" + count.get());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            },"Thread"+i).start();
        }
    }

    public String select(String code) throws Exception{

        if (cache.containsKey(code)) {
            System.out.println(cache.get(code) + "从cache获取...");
            return cache.get(code);
        }

        // 查询 set 加锁
        lock.lock();
        try {
            while (loading.contains(code)) {
                same.await();
            }
            if (cache.containsKey(code)) {
                System.out.println(cache.get(code) + "从cache获取...");
                return cache.get(code);
            }

            System.out.println("查询db开始...");
            loading.add(code);

        } finally {
            lock.unlock();
        }

        TimeUnit.SECONDS.sleep(1);

        lock.lock();
        try {
            cache.put(code, "["+code+"]");
            System.out.println(cache.get(code) + "查询结束...");
            loading.remove(code);
            same.signalAll();
        } finally {
            lock.unlock();
        }

        return code;
    }

}
