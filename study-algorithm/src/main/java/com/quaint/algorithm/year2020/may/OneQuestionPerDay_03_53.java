package com.quaint.algorithm.year2020.may;

/**
 * <p>
 * desc: 53. 最大子序和 Type: Easy
 * </p>
 * <p>
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author quaint
 * @since 03 May 2020
 */
public class OneQuestionPerDay_03_53 {

    public static void main(String[] args) {

        int [] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));

    }

    /**
     * O(n)
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {

        int max = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i] > nums[i] ? sum + nums[i] : nums[i];
            max = max > sum ? max : sum;
        }
        return max;
    }


    /**
     * O(n^2)
     * @param nums
     * @return
     */
    public static int maxSubArray1(int[] nums) {

        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                max = max > nums[i] ? max : nums[i];
                sum = sum + nums[j];
                max = max > sum ? max :sum;
            }
        }

        return max;
    }


}
