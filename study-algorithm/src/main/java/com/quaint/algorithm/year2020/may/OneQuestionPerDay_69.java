package com.quaint.algorithm.year2020.may;

/**
 * <p>
 * desc: 69. x 的平方根
 * </p>
 *
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author quaint
 * @since 09 May 2020
 */
public class OneQuestionPerDay_69 {

    public static void main(String[] args) {

        System.out.println(mySqrt(1));
        System.out.println(mySqrt(3));
        System.out.println(mySqrt(4));
        System.out.println(mySqrt(5));
        System.out.println(mySqrt(7));
        System.out.println(mySqrt(9));
        System.out.println(mySqrt(15));
        System.out.println(mySqrt(16));
        System.out.println(mySqrt(17));
        System.out.println(mySqrt(2147395600));

    }

    public static int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r){
            int middle = l+(r-l)/2;
            if ((long)middle * middle <= x){
                ans = middle;
                l = middle+1;
            } else {
                r = middle-1;
            }
        }
        return ans;
    }

    public static int mySqrt1(int x) {
        long temp = 1L;
        while (temp*temp <= x){
            temp ++;
        }
        int re = (int) temp;
        return x==1 ? 1 : --re;
    }

}
