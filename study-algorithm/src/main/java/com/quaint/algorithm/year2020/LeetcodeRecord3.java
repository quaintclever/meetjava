package com.quaint.algorithm.year2020;

import java.util.*;

/**
 * 三月份 刷题记录
 *
 * @author quaint
 * @since 01 March 2020
 */
public class LeetcodeRecord3 {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode next1 = new ListNode(2);
        ListNode next2 = new ListNode(3);
        head.next = next1;
        next1.next = next2;
        // 倒序输出链表
        ArrayList<Integer> integers = printListFromTailToHead(head);
        System.out.println(integers);


        // 二查数组中的查找
//        int [][] array = {{}};
//        System.out.println(Arrays.deepToString(array));
//        System.out.println(find(16, array));


        // 1130. 叶值的最小代价生成树
//        int[] arr = {5, 2, 3};
//        System.out.println(mctFromLeafValues(arr));




    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        Stack<Integer> stack = new Stack<>();
        while(listNode!=null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> re = new ArrayList<>();
        while(!stack.empty()){
            re.add(stack.pop());
        }
        return re;
    }

    /**
     * 二查数组中的查找
     * @param target
     * @param array
     * @return
     */
    public static boolean find(int target, int [][] array) {
        for(int i = 0;i<array.length;i++){
            if(array[i].length !=0 && array[i][array[i].length-1]<target){
                continue;
            }
            for(int j = 0;j<array[i].length;j++){
                if(array[i][j]==target){
                    return true;
                }
            }

        }
        return false;
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
