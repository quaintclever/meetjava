package com.quaint.javabase.juc.base;

/**
 * @author quaint
 * @since 11 April 2020
 */
public class ThreadBaseTest4 {

    static int a,b,c,d,e,f,g,h;


    public static void main(String[] args) throws Exception{

        for (int i = 0; i < 10_0000; i++) {

            Thread t1 = new ThreadA();
            Thread t2 = new ThreadB();

            t1.start();
            t2.start();
            t1.join();
            t2.join();

            //清空数据，便于测试
            a = 0;
            b = 0;
            c = 0;
            d = 0;
            e = 0;
            f = 0;
            g = 0;
            h = 0;
        }

    }

    static class ThreadA extends Thread {
        @Override
        public void run() {
            a = 1;
            b = 1;
            c = 1;
            d = 1;
            e = 1;
            f = 1;
            g = 1;
            h = 1;
        }
    }

    static class ThreadB extends Thread {
        @Override
        public void run() {
            if (b == 1 && a == 0) {
                System.out.println("指令重排序测试成功 --> b=1");
            }
            if (c == 1 && (a == 0 || b == 0)) {
                System.out.println("指令重排序测试成功 --> c=1");
            }
            if (d == 1 && (a == 0 || b == 0 || c == 0)) {
                System.out.println("指令重排序测试成功 --> d=1");
            }
            if (e == 1 && (a == 0 || b == 0 || c == 0 || d == 0)) {
                System.out.println("指令重排序测试成功 --> e=1");
            }
            if (f == 1 && (a == 0 || b == 0 || c == 0 || d == 0 || e == 0)) {
                System.out.println("指令重排序测试成功 --> f=1");
            }
            if (g == 1 && (a == 0 || b == 0 || c == 0 || d == 0 || e == 0 || f == 0)) {
                System.out.println("指令重排序测试成功 --> g=1");
            }
            if (h == 1 && (a == 0 || b == 0 || c == 0 || d == 0 || e == 0 || f == 0 || g == 0)) {
                System.out.println("指令重排序测试成功 --> h=1");
            }
        }
    }

}
