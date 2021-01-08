package com.quaint.algorithm.year2021.january;

import java.util.Arrays;

/**
 * <p>
 * desc:
 * </p>
 *
 * @author quaint
 * @since 08 January 2021
 */
public class LC02 {

    public static void main(String[] args) {
        int[] arr = {1,2};
        int[] arr1 = {1,2,3};
        int[] arr2 = {1,2,3,4};
        int[] arr3 = {1,2,3,4,5};
        int[] arr4 = {1,2,3,4,5,6};
        rotate(arr,2);
        rotate(arr1,2);
        rotate(arr2,2);
        rotate(arr3,2);
        rotate(arr4,2);

    }

    public static void rotate(int[] nums, int k) {

        System.out.println(k + ": ==> start: => " + Arrays.toString(nums));

        int n = nums.length;
        k %= n;

        int swapCount = 0;
        int j = 0;
        while(swapCount < n) {
            int cj = (j+k) % n;
            int temp = nums[cj];
            while(j != cj) {
                nums[(j+k)%n] = nums[j%n];
                j += (n-k);
                j %= n;
                swapCount++;
            }
            nums[(j+k)%n] = temp;
            swapCount++;
            j++;
        }


        System.out.println("end: => " +Arrays.toString(nums));
    }

}
