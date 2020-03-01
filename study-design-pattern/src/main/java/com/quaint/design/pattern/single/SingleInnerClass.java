package com.quaint.design.pattern.single;

/**
 * 登记式/静态内部类
 * @author quaint
 * @date 2020-01-17 11:49
 */
public class SingleInnerClass {

    public void showMsg(){
        System.out.println(Thread.currentThread().getName()+" --> "+this.toString());
    }

    private static class InnerClass{
        private final static SingleInnerClass INSTANCE = new SingleInnerClass();
    }

    private SingleInnerClass(){}

    public static SingleInnerClass getInstance(){
        return InnerClass.INSTANCE;
    }


}
