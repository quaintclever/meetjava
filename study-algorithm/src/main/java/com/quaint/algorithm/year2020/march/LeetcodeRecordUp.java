package com.quaint.algorithm.year2020.march;

import java.util.Arrays;

/**
 * 三月份 刷题记录上
 *
 * @author quaint
 * @since 01 March 2020
 */
public class LeetcodeRecordUp {

    public static void main(String[] args) {


        // 1130. 叶值的最小代价生成树
        int[] arr = {5, 2, 3};
        System.out.println(mctFromLeafValues(arr));


    }


    /**
     * 单调栈, dp
     * 1130. 叶值的最小代价生成树
     */
    public static int mctFromLeafValues(int[] arr) {

        int n = arr.length;
        if (n == 0) {
            return 0;
        }
        memoization = new int[n][n];
        return getTreeMinSum(arr, 0, n-1);
    }

    private static int[][] memoization;

    public static int getTreeMinSum(int[] arr, int left, int right) {

        if (right - left == 0) {
            return 0;
        }
        if (memoization[left][right] != 0) {
            return memoization[left][right];
        }

        int minVal = Integer.MAX_VALUE;
        for (int i = left; i < right; i++) {
            int min1 = getTreeMinSum(arr, left, i);
            int min2 = getTreeMinSum(arr, i+1, right);
            int maxValMult = getBranchMax(arr,left,i) * getBranchMax(arr,i+1,right);
            int temp = min1 + min2 + maxValMult;
            minVal = minVal > temp ? temp : minVal;
        }
        memoization[left][right] = minVal;
        return minVal;

    }

    public static int getBranchMax(int[] arr, int left, int right) {

        int max = -1;
        for (int i = left; i <= right; i++) {
            max = max<arr[i]?arr[i]:max;
        }
        return max;
    }


}
