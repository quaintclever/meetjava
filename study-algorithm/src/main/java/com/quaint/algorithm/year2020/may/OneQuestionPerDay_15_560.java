package com.quaint.algorithm.year2020.may;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * desc: 560. 和为K的子数组  题目难度: medium
 * </p>
 *
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 示例 1 :
 *
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 *
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarray-sum-equals-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author quaint
 * @since 15 May 2020
 */
public class OneQuestionPerDay_15_560 {

    public static void main(String[] args) {

        int[] nums = {1,1,1};
        System.out.println(subarraySum(nums,2));

    }


    /**
     * hash 前缀法
     * 时间复杂度  O(n)
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum(int[] nums, int k) {

        int ans = 0,pre = 0;
        // 前面的是 和作为键, 值为出现的次数
        Map<Integer,Integer> mp = new HashMap<>(nums.length);
        // 和为0 默认加 1
        mp.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            // 如果pre - k = 0  ans 自增1
            if (mp.containsKey(pre-k)){
                ans += mp.get(pre-k);
            }
            mp.put(pre,mp.getOrDefault(pre,0) + 1);
        }

        return ans;
    }

    /**
     * 暴力枚举法  遍历所有数组的和
     * 时间复杂度  O(n^2)
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum1(int[] nums, int k) {

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if (sum == k){
                ans ++;
            }

            for (int j = i+1; j < nums.length; j++) {

                sum += nums[j];
                if (sum == k){
                    ans++;
                }
            }

        }

        return ans;
    }

}
