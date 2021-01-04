package com.quaint.other.code.quaint;

/**
 * @author quaint
 * @date 23 March 2020
 * @since 1.38
 */
public class TempTest {

    public static void main(String[] args) {

        String test = "abc";
        String test1 = reverseString(test);
        System.out.println(test1);

    }


    public static String reverseString(String str) {
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }

}
