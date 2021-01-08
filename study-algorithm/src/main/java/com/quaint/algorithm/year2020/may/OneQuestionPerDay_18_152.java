package com.quaint.algorithm.year2020.may;

/**
 * <p>
 * desc: 152. 乘积最大子数组
 *
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * </p>
 *
 * @author quaint
 * @since 18 May 2020
 */
public class OneQuestionPerDay_18_152 {


    public static void main(String[] args) {

        int[] nums1 = {2,3,-2,4};
        int[] nums2 = {-2,0,-1};
        System.out.println(maxProduct(nums2));

    }


    /**
     * 请 继续尝试  O(n) 解法
     * @param nums
     * @return
     */
    public static int maxProduct(int[] nums) {

        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int cache = nums[i];
            max = cache > max ? cache : max;
            for (int j = i+1; j < nums.length; j++) {
                cache *= nums[j];
                max = cache > max ? cache : max;
            }
        }
        return max;
    }

}
