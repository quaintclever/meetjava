package com.quaint.javabase.juc.base;

/**
 * @author quaint
 * @date 29 March 2020
 * @since 1.26
 */
public class ThreadBaseTest2 {

    public static int count = 0;

    // test  不能锁 null --> java.lang.NullPointerException
//    public static Object o = null;

    public static Object o = new Object();

    public static void test(){
        synchronized (o){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
            System.out.println(count);
        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            new Thread(ThreadBaseTest2::test).start();
        }

    }

}
