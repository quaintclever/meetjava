package com.quaint.studyproject.amusement.sync;

/**
 * @Description: 同步方法 和不同步方法 是否可以同时进行
 * @author: qi cong
 * @Date: Created in 2019/10/25 19:11
 */
public class Test04 {

    public static synchronized void m1(){
        System.out.println("m1 start!");

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("m1 end!");

    }

    public static void m2(){
        System.out.println("m2 exec!");
    }

    public static void main(String[] args) {


        new Thread(Test04::m1).start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(Test04::m2).start();

        /**
         * 结果，可以同时执行
         * m1 start!
         * m2 exec!
         * m1 end!
         */

    }


}
