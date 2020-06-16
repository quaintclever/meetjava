package com.quaint.algorithm.year2020.may;

/**
 * <p>
 * desc: 5. 最长回文子串
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * </p>
 *
 * @author quaint
 * @since 21 May 2020
 */
public class OneQuestionPerDay_21_5 {


    public static void main(String[] args) {

//        System.out.println(longestPalindrome("babad"));
//        System.out.println(longestPalindrome("cbbd"));

    }

//    public static String longestPalindrome(String s) {
//
//        String ans = "";
//        String ans2;
//        int len = s.length();
//        for (int i = 0; i < len; i++) {
//            ans = s.substring(i);
//            ans2 = s.substring(0,len -1 -i);
//            if (isPalindrome(ans)){
//                break;
//            }
//            if (isPalindrome(ans2)){
//                ans = ans2;
//                break;
//            }
//        }
//        return ans;
//    }
//
//    public static boolean isPalindrome(String str){
//        int n = str.length();
//        for (int i = 0; i < n / 2; i++) {
//            if (str.charAt(i)!=str.charAt(n-1-i)){
//                return false;
//            }
//        }
//        return true;
//    }

}
