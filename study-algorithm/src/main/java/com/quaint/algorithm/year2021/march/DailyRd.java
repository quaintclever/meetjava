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


    public int trap1(int[] height) {
        int n = height.length;
        if (n < 3) {
            return 0;
        }

        int ans = 0;
        int leftMax = height[0];
        for (int i = 1; i < n - 1; i++) {
            // 遍历左面
            for (int j = i - 1; j < i; j++) {
                leftMax = Math.max(leftMax,height[j]);
            }
            // 遍历右面
            int rightMax = height[i + 1];
            for (int j = i + 2; j < n; j++) {
                rightMax = Math.max(height[j], rightMax);
            }
            if (height[i] < leftMax && height[i] < rightMax) {
                ans += Math.min(leftMax - height[i], rightMax - height[i]);
            }
        }
        return ans;
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
