package com.quaint.algorithm.year2021.january;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Foo {

    Lock lock = new ReentrantLock();
    Condition c1 = lock.newCondition();
    Condition c2 = lock.newCondition();
    volatile int count = 0;

    public Foo() {
        
    }

    public static void main(String[] args) throws Exception{
        Foo foo = new Foo();
        foo.first(new Thread(()->{
            System.out.print("1");
        }));
        foo.second(new Thread(()->{
            System.out.print("2");
        }));
        foo.third(new Thread(()->{
            System.out.print("3");
        }));
        System.out.println("\nend...");
    }


    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        count ++;
        c1.signal();
        c2.signal();
        lock.unlock();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        if (count == 0){
            c1.await();
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        count ++;
        c2.signal();
        lock.unlock();
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        if (count < 2) {
            c2.await();
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        lock.unlock();
    }
}