package com.quaint.studyproject.annotation.studyAnno;

public class NoBug {

    @Quaint
    public void showNum(){
        System.out.println("1234567890");
    }

    @Quaint
    public void add(){
        System.out.println("1+1="+1+1);
    }

    @Quaint
    public void sub(){
        System.out.println("1-1="+(1-1));
    }

    @Quaint
    public void mul(){
        System.out.println("3 x 5="+ 3*5);
    }

    @Quaint
    public void div(){
        System.out.println("6 / 0="+ 6 / 0);
    }

    public void desc(){
        System.out.println("我写的程序没有 bug!");
    }
}