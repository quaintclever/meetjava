package com.quaint.sp.algorithm.year2020.month2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author quaint
 * @date 23 February 2020
 * @since 1.34
 */
public class LeetCodeTest {

    public static void main(String[] args) {

        int[] nums = {3,2,4};
        int target = 6;
        int[] ints = twoSum(nums, target);
        System.out.println(ints[0]);
        System.out.println(ints[1]);

    }

    public static int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0;i < nums.length;i++){
            if(map.containsKey(nums[i])){
                result[1] = i;
                result[0] = map.get(nums[i]);
                return result;
            }
            map.put(target-nums[i],i);
        }
        return result;
    }

}
