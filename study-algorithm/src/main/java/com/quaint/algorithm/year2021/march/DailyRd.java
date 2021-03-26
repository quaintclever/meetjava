package com.quaint.algorithm.year2021.march;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author quaint
 * @date 2021/3/25
 */
public class DailyRd {

    public static void main(String[] args) {
        DailyRd dailyRd = new DailyRd();


    }

    /**
     * ✔[20]有效的括号
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Deque<Integer> stack = new LinkedList<>();
        String left = "([{";
        String right = ")]}";
        char[] chars = s.toCharArray();
        for (char c : chars) {
            int li = left.indexOf(c);
            int ri = right.indexOf(c);
            if (li != -1) {
                stack.push(li);
            } else if (ri != -1) {
                if (stack.isEmpty()) {
                    return false;
                }
                int cs = stack.pop();
                if (cs != ri) {
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }

}
