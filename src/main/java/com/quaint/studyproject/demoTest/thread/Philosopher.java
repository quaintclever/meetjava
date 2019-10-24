package com.quaint.studyproject.demoTest.thread;

import java.util.Objects;
import java.util.concurrent.CountDownLatch;

/**
 * @Description: 哲学家类，只能取自己左边的一个筷子
 * @author: qi cong
 * @Date: Created in 2019/10/24 11:43
 */
public class Philosopher implements Runnable {

    private Chopsticks left;
    private Chopsticks right;
    private CountDownLatch countDownLatch;


    public Philosopher(Chopsticks left, Chopsticks right, CountDownLatch countDownLatch) {
        this.left = left;
        this.right = right;
        this.countDownLatch = countDownLatch;
    }


    // 拿起左面的筷子
    public Chopsticks getLeft() {

        // 如果左面的筷子可以拿
        if (left.isStatus()) {
            // 改为不可以拿
            left.setName(Thread.currentThread().getName());
            left.setStatus(false);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println(Thread.currentThread().getName()+"-> 拿到了左面的筷子到手中花了0s！");
            return left;
        }
        else if(left.getName().equals(Thread.currentThread().getName())){
            return left;
        }
        else {
            System.out.println(Thread.currentThread().getName()+"-> 没有拿到左面的筷子！");
            return null;
        }
    }

    // 放下左面的筷子
    public void setLeft(Chopsticks left) {
        left.setStatus(true);
        System.out.println(Thread.currentThread().getName()+"-> 放下了左面的筷子！");
    }

    // 拿起右面的筷子
    public Chopsticks getRight() {
        // 如果右面的筷子可以拿
        if (right.isStatus()) {
            // 改为不可以拿
            right.setName(Thread.currentThread().getName());
            right.setStatus(false);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println(Thread.currentThread().getName()+"-> 拿到了右面的筷子到手中花了0s！");
            return right;
        }
        else if(right.getName().equals(Thread.currentThread().getName())){
            return right;
        }
        else {
            System.out.println(Thread.currentThread().getName()+"-> 没有拿到右面的筷子！");
            return null;
        }
    }

    // 放下右面的筷子
    public void setRight(Chopsticks right) {
        right.setStatus(true);
        System.out.println(Thread.currentThread().getName()+"-> 放下了右面的筷子！");
    }

    @Override
    public void run() {

        int i = 0;
        // 尝试100次取筷子 进餐
        while (i<100){
            if (!Objects.isNull(this.getLeft())){
                if (!Objects.isNull(this.getRight())){
                    try {
                        System.out.println(Thread.currentThread().getName()+"-> 正在用一双筷子进餐！");
                        Thread.sleep(10*1000);
                        this.setLeft(left);
                        this.setRight(right);
                        System.out.println(Thread.currentThread().getName()+"-> 进餐完成！放下两双筷子！ 当前尝试次数："+i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    try {
                        Thread.sleep(2*1000);
                        System.out.println(Thread.currentThread().getName()+"-> 休息2s！ 当前尝试次数："+i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            } else {
                try {
                    Thread.sleep(2*1000);
                    System.out.println(Thread.currentThread().getName()+"-> 休息2s！ 当前尝试次数："+i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            i++;
        }

    }
}
