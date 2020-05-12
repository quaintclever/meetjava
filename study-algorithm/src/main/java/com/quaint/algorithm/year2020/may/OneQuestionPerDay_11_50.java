package com.quaint.algorithm.year2020.may;

/**
 * <p>
 * desc: 50. Pow(x, n)
 * </p>
 * <p>
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 * <p>
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 * <p>
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2^-2 = 1/2^2 = 1/4 = 0.25
 * 说明:
 * <p>
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/powx-n
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author quaint
 * @since 11 May 2020
 */
public class OneQuestionPerDay_11_50 {

    public static void main(String[] args) {

        System.out.println(myPow(2, 10));
        System.out.println(myPow(2.1, 3));
        System.out.println(myPow(2, -2));
        System.out.println(myPow(2.000, -2));

    }

    public static double myPow(double x, int n) {


        if (n == 0 || Math.abs(Math.abs(x) - 1) < 0.000001) {
            return x<0 && n%2==1 ? -1.0 : 1.0;
        }

        if (x == 0 || n == Integer.MIN_VALUE) {
            return 0.0;
        }

        if (n < 0) {
            x = 1 / x;
            n = 0x7fffffff - (n & 0x7fffffff) + 1;
        }

        double ins;
        if (n % 2 == 0) {
            ins = myPow(x, n / 2);
            ins *= ins;
        } else {
            ins = myPow(x, n / 2);
            ins *= ins * x;
        }

        return ins;
    }


    /**
     * 超时 * 2
     *
     * @param x
     * @param n
     * @return
     */
    public static double myPow2(double x, int n) {

//        if (x == 0) {
//            return 0.0;
//        }
//
//        if (n == 0) {
//            return 1.0;
//        }
//
//        if (n == 1) {
//            return x;
//        }
//
//        boolean flag = n < 0;
//        if (flag) {
//            n = n * -1;
//        }
//
//        double ins = myPow(x, (n + 1) / 2) * myPow(x, n / 2);
//
//        return flag ? 1 / ins : ins;
        return 0;
    }


    /**
     * 超时...
     *
     * @param x
     * @param n
     * @return
     */
    public static double myPow1(double x, int n) {

        if (n == 0) {
            return 1.0;
        }

        boolean flag = n < 0;
        if (flag) {
            n = n * -1;
        }
        double ins = x;
        double check = ins;
        for (int i = 1; i < n; i++) {
            ins *= x;
            if (check - ins < 0.0001 && check - ins > -0.0001) {
                break;
            }
            check = ins;
        }

        return flag ? 1 / ins : ins;
    }

}
