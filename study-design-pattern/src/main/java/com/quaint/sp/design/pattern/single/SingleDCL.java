package com.quaint.sp.design.pattern.single;

/**
 * 双检锁/双重校验锁
 * @author quaint
 * @date 2020-01-17 11:27
 */
public class SingleDCL {

    private volatile static SingleDCL instance;

    private SingleDCL(){}

    public static SingleDCL getInstance(){
        if (instance==null){
            synchronized (SingleDCL.class){
                if (instance==null){
                    instance = new SingleDCL();
                }
            }
        }
        return instance;
    }

    public void showMsg(){
        System.out.println(Thread.currentThread().getName()+" --> "+instance.toString());
    }

}
