package com.quaint.studyproject.demoTest.thread.philosopher;

import java.util.Objects;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @Description: 哲学家类，只能先取自己左边的一个筷子
 * @author: qi cong
 * @Date: Created in 2019/10/24 11:43
 */
public class Philosopher implements Runnable {

    private Chopsticks left;
    private Chopsticks right;
    private Waiter waiter;
    private CountDownLatch countDownLatch;


    public Philosopher(Chopsticks left, Chopsticks right, CountDownLatch countDownLatch, Waiter waiter) {
        this.left = left;
        this.right = right;
        this.countDownLatch = countDownLatch;
        this.waiter = waiter;
    }


    // 拿起左面的筷子
    public Chopsticks getLeft() {

        // 如果左面的筷子可以拿 ，最多同时拿起4只筷子
        if (left.isStatus() && waiter.getLeftCount()<=4) {
            // 改为不可以拿
            left.setName(Thread.currentThread().getName());
            left.setStatus(false);
            waiter.setLeftCount(waiter.getLeftCount()+1);
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
        waiter.setLeftCount(waiter.getLeftCount()-1);
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

        try {
            Random random = new Random();
            // 随机思考 10s以内
            Thread.sleep(random.nextInt(10)*1000);
            int i = 0;
            // 尝试100次取筷子 进餐
            while (i<100){
                if (!Objects.isNull(this.getLeft())){
                    if (!Objects.isNull(this.getRight())){
                        System.out.println(Thread.currentThread().getName()+"-> 正在用一双筷子进餐！");
                        // 随机进餐 10s以内
                        Thread.sleep(random.nextInt(10)*1000);
                        this.setLeft(left);
                        this.setRight(right);
                        System.out.println(Thread.currentThread().getName()+"-> 进餐完成！放下两双筷子！ 当前尝试次数："+i);
                        // 随机思考 10s以内
                        Thread.sleep(random.nextInt(10)*1000);
                    }else {
                        Thread.sleep(2*1000);
                        System.out.println(Thread.currentThread().getName()+"-> 休息2s！ 当前尝试次数："+i);
                    }

                } else {
                    Thread.sleep(2*1000);
                    System.out.println(Thread.currentThread().getName()+"-> 休息2s！ 当前尝试次数："+i);
                }
                i++;
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
