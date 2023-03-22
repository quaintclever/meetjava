package com.quaint.algorithm.classify;

/**
 * dp 练习
 *
 * @author quaint
 * @since 2023/3/22 22:15
 */
public class Dp {

    /**
     * <a href="https://leetcode.cn/problems/trapping-rain-water/">...</a>
     * 42. 接雨水
     */
    public int trap(int[] height) {
        int len = height.length;
        int[] arr1 = new int[len + 2];
        int[] arr2 = new int[len + 2];
        for (int i = 1; i < len; i++) {
            arr1[i] = Math.max(arr1[i - 1], height[i - 1]);
        }
        for (int i = len - 2; i > 0; i--) {
            arr2[i] = Math.max(arr2[i + 1], height[i + 1]);
        }
        int sum = 0;
        for (int i = 0; i < len; i++) {
            int min = Math.min(arr1[i], arr2[i]);
            if (height[i] < min) {
                sum += min - height[i];
            }
        }
        return sum;
    }


}
