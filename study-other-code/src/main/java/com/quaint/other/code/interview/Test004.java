package com.quaint.other.code.interview;

public class Test004 {

    private static final int USER_TYPE = 4;

    public static void main(String[] args) {
        System.out.println(isType4(4L));
    }

    public static boolean isType4(Long type) {
        return USER_TYPE == type;
    }
}