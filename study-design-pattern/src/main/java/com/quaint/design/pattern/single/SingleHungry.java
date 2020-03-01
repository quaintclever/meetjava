package com.quaint.design.pattern.single;

/**
 * 饿汉式
 * @author quaint
 * @date 2020-01-17 10:38
 */
public class SingleHungry {

    private static SingleHungry instance = new SingleHungry();

    private SingleHungry() {
    }

    public static SingleHungry getInstance() {
        return instance;
    }

    public void showMsg(){
        System.out.println(Thread.currentThread().getName()+" --> "+instance.toString());
    }

}
