package com.quaint.algorithm.year2020.may;

/**
 * <p>
 * desc: 45. 跳跃游戏 II
 * </p>
 * <p>
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 说明:
 * <p>
 * 假设你总是可以到达数组的最后一个位置。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author quaint
 * @since 04 May 2020
 */
public class OneQuestionPerDay_04_45 {

    public static void main(String[] args) {

        int[] nums = {4, 3, 2, 5, 1, 1, 1, 1, 4};
        int[] nums2 = {2,3,1};
        int[] nums3 = {2,3,1,1,4};
        System.out.println(jump(nums3));


    }


    /**
     * 贪心算法2
     * 时间复杂度 O(n)
     * 从第一个开始看 最远能跳 多远.
     * 然后从 第一个可以跳跃的范围内 找 下次最远能跳多远
     * 每一个 范围的最远, 就可以汇集出 最后的最优解.
     * @param nums
     * @return
     */
    public static int jump(int[] nums) {

        // 目标位置
        int target = nums.length - 1;
        // 跳跃次数
        int steps = 0;
        // 2次最大可跳跃到的位置
        int maxPosition = 0;
        // 第一次可跳跃的 所有地点结束位置
        int end = 0;
        for (int i = 0; i < target; i++) {
            maxPosition = Math.max(maxPosition,i+nums[i]);
            if (maxPosition >= target){
                return ++steps;
            }
            if (i == end){
                end = maxPosition;
                steps++;
            }
        }

        return steps;
    }


    /**
     * 贪心算法 1
     * O(n^2)
     * 从前往后寻找 最早能跳到 结尾的 位置 position
     * 如果这个位置能跳到,那么后面 也很可能跳到.
     * 如何确保这个位置就是最优解呢?
     * 1. 如果后面是最优解的话, 那么 最优解的前一步一定也可以 跳到 position, 所以 position 也是最优解
     * 2. 如果position 为最优解, 后面不一定为最优解
     * @param nums
     * @return
     */
    public static int jump1(int[] nums) {

        int position = nums.length - 1;
        int step = 0;
        while (position > 0) {
            for (int i = 0; i < position; i++) {
                if (nums[i] + i >= position) {
                    position = i;
                    step++;
                    break;
                }
            }
        }
        return step;
    }

}
