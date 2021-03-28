package com.quaint.algorithm.year2021.march;

import java.util.*;

/**
 * @author quaint
 * @date 2021/3/25
 */
public class DailyRd {

    public static void main(String[] args) {
        DailyRd dailyRd = new DailyRd();
        System.out.println(dailyRd.reinitializePermutation(4));
    }

    public int reinitializePermutation(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        int[] perm = arr.clone();
        int count = 0;
        boolean flag = true;
        while (flag) {
            count++;
            int change = 0;
            for (int i = 1; i < n; i++) {
                if (i % 2 == 0) {
                    arr[i] = perm[i / 2];
                } else {
                    arr[i] = perm[n / 2 + (i - 1) / 2];
                }
                if (arr[i] != i) {
                    change++;
                }
            }
            perm = arr.clone();
            flag = change != 0;
        }
        return count;
    }


    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        knowledge.stream().forEach(l -> map.put(l.get(0),l.get(1)));

        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        StringBuilder key = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (flag && s.charAt(i) != ')'){
                key.append(s.charAt(i));
            }
            if (flag && s.charAt(i) == ')') {
                flag = false;
                String s1 = map.get(key.toString());
                key = new StringBuilder();
                sb.append(s1 == null ? "?" : s1);
                continue;
            }
            if (s.charAt(i) != '(') {
                if (!flag) {
                    sb.append(s.charAt(i));
                }
            } else {
                flag = true;
            }
        }
        return sb.toString();
    }


    public int numDifferentIntegers(String word) {
        String[] split = word.split("[a-z]+");
        Set<String> set = new HashSet<>();
        for (int i = 0; i < split.length; i++) {
            if ("".equals(split[i])) {
                continue;
            } else {
                set.add(delPreZero(split[i]));
            }
        }
        System.out.println(Arrays.toString(split));
        System.out.println(set.size());
        return set.size();
    }

    private String delPreZero(String s){
        for(int i = 0; i < s.length(); i++) {
            if ('0' != s.charAt(i)) {
                return s.substring(i);
            }
        }
        return "0";
    }


    /**
     * ✔[42]接雨水
     * 1. 使用stack
     *
     * @param height
     * @return
     */
    public int trap3(int[] height) {
        int ans = 0;
        Deque<Integer> stack = new LinkedList<>();
        int current = 0;
        while (current < height.length) {
            while (!stack.isEmpty() && height[stack.peek()] < height[current]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int dis = current - stack.peek() - 1;
                int h = Math.min(height[stack.peek()], height[current]) - height[top];
                ans += dis * h;
            }
            stack.push(current++);
        }
        return ans;
    }


    /**
     * ✔[42]接雨水
     * 1. 暴力改进
     *
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        int n = height.length;
        if (n < 3) {
            return 0;
        }
        int ans = 0;
        int[] rightMax = new int[n];
        rightMax[n - 2] = height[n - 1];
        for (int i = n - 3; i >= 1; i--) {
            rightMax[i] = Math.max(height[i + 1], rightMax[i + 1]);
        }
        int leftMax = height[0];
        for (int i = 1; i < n - 1; i++) {
            leftMax = Math.max(leftMax, height[i - 1]);
            if (height[i] < leftMax && height[i] < rightMax[i]) {
                ans += (Math.min(leftMax, rightMax[i]) - height[i]);
            }
        }
        return ans;
    }

    /**
     * ✔[42]接雨水
     * 1.暴力法
     *
     * @param height
     * @return
     */
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
                leftMax = Math.max(leftMax, height[j]);
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
