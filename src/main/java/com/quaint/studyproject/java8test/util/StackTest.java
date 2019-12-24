package com.quaint.studyproject.java8test.util;

import java.util.Stack;

/**
 * @Description:
 * @author: qi cong
 * @Date: Created in 2019-11-13 11:27
 */
public class StackTest {

    public static void main(String[] args) {

        Stack<String> stringStack = new Stack<>();
        stringStack.push("str1");
        stringStack.push("str2");
        stringStack.push("str3");
        stringStack.push("str4");
        System.out.println(stringStack);

        System.out.println(stringStack.peek());
        System.out.println(stringStack);

        System.out.println(stringStack.pop());
        System.out.println(stringStack);

        System.out.println(stringStack.empty());
        System.out.println(stringStack.search("str3"));
        System.out.println(stringStack.search("str4"));

        stringStack.pop();
        stringStack.pop();
        stringStack.pop();
        System.out.println(stringStack);
        // throw a exception
        System.out.println(stringStack.pop());




    }

}
