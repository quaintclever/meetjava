package com.quaint.studyproject.amusement.sync;

/**
 * @Description: 获取对象锁 改变之后，不能继续保持锁
 * @author: qi cong
 * @Date: Created in 2019/10/25 16:22
 */
public class Test01{

    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();
        ThreadTest threadTest = new ThreadTest(o);
        o = new Object();
        ThreadTest threadTest2 = new ThreadTest(o);
        threadTest.start();
        threadTest2.start();

    }

    static class ThreadTest extends Thread{

        Object o;
        public ThreadTest(Object o) {
            this.o = o;
        }
        @Override
        public void run() {
            synchronized (o){
                System.out.println("线程锁定开始");
                try {
                    Thread.sleep(3*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程锁定结束");
            }
        }
    }

}
