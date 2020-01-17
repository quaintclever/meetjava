package com.quaint.sp.design.pattern.single;

/**
 * 懒汉式
 * @author quaint
 * @date 2020-01-17 10:40
 */
public class SingleLazy {

    private static SingleLazy instance;

    private SingleLazy(){}

    public static SingleLazy getInstance(){
        if (instance == null){
            instance = new SingleLazy();
        }
        return instance;
    }

    public void showMsg(){
        System.out.println(Thread.currentThread().getName()+" --> "+instance.toString());
    }

}
