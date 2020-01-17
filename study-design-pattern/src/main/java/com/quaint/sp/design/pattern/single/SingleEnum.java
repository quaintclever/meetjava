package com.quaint.sp.design.pattern.single;

/**
 * @author quaint
 * @date 2020-01-17 11:56
 */
public class SingleEnum {

    public void showMsg(){
        System.out.println(Thread.currentThread().getName()+" --> "+this.toString());
    }

    private SingleEnum(){}

    public static SingleEnum getInstance(){
        return InnerEnum.INSTANCE.getInstance();
    }

    private enum InnerEnum{

        /**
         * 单利实例
         */
        INSTANCE;

        private SingleEnum instance;

        InnerEnum() {
            this.instance = new SingleEnum();
        }

        public SingleEnum getInstance(){
            return instance;
        }
    }

}
