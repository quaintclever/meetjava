package com.quaint.other.code.interview;

public class Counter01 {

    public static void main(String[] args) {
        System.out.println(f1(2, 2));
//        System.out.println(f3( 2, 2l));
    }


    public static boolean f1(Number num1, Number num2) {
        return num1 == num2;
    }

    public static boolean f3(Number num1, Number num2) {
        return num1.equals(num2);
    }

}