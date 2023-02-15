package com.quaint.javabase.juc.base;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 练习 cas 锁的使用
 */
public class CasTest {
    public static Integer lockVal = 0;

//    public static CasTest casTest;
//
//    static {
//        casTest = new CasTest();
//    }

    public static void main(String[] args) throws InterruptedException {

        MyThread mt = new MyThread();
        Thread t1 = new Thread(mt);
        Thread t2 = new Thread(mt);
        Thread t3 = new Thread(mt);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
        System.out.println("end...");
    }

    public static class MyThread implements Runnable {
        @Override
        public void run() {
            Unsafe unsafe = getUnsafe();
            long off;
            try {
                off = unsafe.objectFieldOffset(Integer.class.getDeclaredField("value"));
//                System.out.println("off = " + off);
            } catch (NoSuchFieldException e) {
                throw new RuntimeException(e);
            }
            while (!unsafe.compareAndSwapInt(lockVal, off, lockVal, lockVal + 1)) {
                System.out.println(Thread.currentThread().getName() + " not get lock! lockVal: " + lockVal);
            }
            System.out.println(Thread.currentThread().getName() + " get lock! lockVal: " + lockVal);
        }
    }

    public static Unsafe getUnsafe() {
        Class<Unsafe> unsafeClass = Unsafe.class;
        try {
            Field theUnsafe = unsafeClass.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            return (Unsafe) theUnsafe.get(null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

}

