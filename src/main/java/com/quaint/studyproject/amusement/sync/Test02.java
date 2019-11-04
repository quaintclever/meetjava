package com.quaint.studyproject.amusement.sync;

/**
 * @Description: 获取对象锁 改变之后，不能继续保持锁
 * @author: qi cong
 * @Date: Created in 2019/10/25 16:42
 */
public class Test02 {

    private Object o = new Object();

    public void m() {
        synchronized (o) {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " executing...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args) {
        Test02 t = new Test02();

        new Thread(t::m, "t1").start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.o = new Object();
        new Thread(t::m, "t2").start();
    }
}
