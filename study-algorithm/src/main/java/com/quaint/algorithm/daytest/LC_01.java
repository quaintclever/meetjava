package com.quaint.algorithm.daytest;

public class LC_01 {

    public static void main(String[] args) {
        LC_01 lc01 = new LC_01();
        int ans = lc01.maxValue(7132374,
                766527,
                167767740);
        System.out.println(ans);
    }


    // https://leetcode.cn/problems/maximum-value-at-a-given-index-in-a-bounded-array/
    public int maxValue(int n, int index, int maxSum) {
        int left = 1, right = maxSum;
        while (left < right) {
            // 检查是否满足 条件
            int mid = left + right + 1 >> 1;
            if (valid(mid, n, index, maxSum)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public boolean valid(int mid, int n, int index, int sumMax) {
        return mid + cal(mid, index) + cal(mid, n - index - 1) <= sumMax;
    }

    public long cal(int val, int len) {
        if (val - 1 > len) {
            int sv = val - len;
            return (long) (val - 1 + sv) * len / 2;
        } else {
            int ones = len - (val - 1);
            return (long) val * (val - 1) / 2 + ones;
        }
    }


}
