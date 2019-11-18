package com.quaint.studyproject.demoTest.sync;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @Description:
 * @author: quaint
 * @Date: Created in 2019/11/7 19:29
 */
public class Test08 {

    static Queue<String> queue = new ConcurrentLinkedQueue<>();

    static {
        for (int i = 0; i < 1000; i++) {
            queue.add("队列位置 "+i);
        }
    }

    public static void main(String[] args) {


        long start = System.currentTimeMillis();
        Thread [] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(()->{
                while (true) {
                    String s = queue.poll();
                    if (s == null) break;
                    else System.out.println(s);
                }
            });
            threads[i].start();
        }
        try {
            for (Thread t: threads) {
                t.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();

        System.out.println("一共使用了"+(start-end)+"毫秒");

    }

}
