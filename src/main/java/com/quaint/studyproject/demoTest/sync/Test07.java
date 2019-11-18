package com.quaint.studyproject.demoTest.sync;

import java.util.Vector;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @author: quaint
 * @Date: Created in 2019/11/7 19:20
 */
public class Test07 {

    public static Vector<String> list = new Vector<>();

    static {
        for (int i = 0; i < 1000; i++) {
            list.add("1");
        }
    }


    public static void main(String[] args) {

        Lock lock = new ReentrantLock();

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                while (true){
                    lock.lock();
                    if (list.size()>0){
                        list.remove(0);
                        System.out.println(list.size());
                        lock.unlock();
                    }
                    else {
                        lock.unlock();
                        break;
                    }

                }
            }).start();
        }


    }

}
