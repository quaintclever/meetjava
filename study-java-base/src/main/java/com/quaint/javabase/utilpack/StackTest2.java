package com.quaint.javabase.utilpack;

import java.util.Stack;

/**
 * <p>
 * desc: 测试error
 * </p>
 *
 * @author quaint
 * @since 18 April 2020
 */
public class StackTest2 {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        for (Integer i: stack) {

            System.out.println("---");
            System.out.println(i);
            if (i < stack.size()){
                System.out.println("执行pop 之前");
                stack.pop();
                System.out.println("执行pop 之后");
            } else {
                break;
            }
            System.out.println("---");
        }

        System.out.println("hello");

    }

}
