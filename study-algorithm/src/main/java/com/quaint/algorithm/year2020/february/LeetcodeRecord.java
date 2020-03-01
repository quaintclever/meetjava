package com.quaint.algorithm.year2020.february;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author quaint
 * @date 23 February 2020
 * @since master
 */
public class LeetcodeRecord {

    public static void main(String[] args) {

        LeetcodeRecord record = new LeetcodeRecord();


        // 1360. 日期之间隔几天
        System.out.println(record.daysBetweenDates("2000-06-29", "2019-06-30"));

        // 3. 无重复字符的最长子串
        System.out.println(record.lengthOfLongestSubstring("abcabcbb"));

        // 2. 两数相加
        record.addTwoNumbers(new LeetcodeRecord.ListNode(1),new LeetcodeRecord.ListNode(9));

        // 1. 两数之和
        int [] ints = {1,2,3};
        record.twoSum(ints,3);


    }


    /**
     * 1360. 日期之间隔几天
     * @param date1
     * @param date2
     * @return
     */
    public int daysBetweenDates(String date1, String date2) {

//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//        Date d1 = null;
//        Date d2 = null;
//        try {
//            d1 = df.parse(date1);
//            d2 = df.parse(date2);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        Long tempDay = d1.getTime()/24/60/60/1000-d2.getTime()/24/60/60/1000;
//        int day = tempDay.intValue();
//
//        return day>0?day:day*-1;

        LocalDate local1 = LocalDate.parse(date1);
        LocalDate local2 = LocalDate.parse(date2);
        Long tempDay = local1.until(local2, ChronoUnit.DAYS);
        int day = tempDay.intValue();
        return day;
    }


    /**
     * 3. 无重复字符的最长子串
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {

        int maxLen = 0;
        int currentLen = 0;
        Set<Character> set = new HashSet<>();

        for(int i = 0 ; i < s.length(); i++){
            if(set.contains(s.charAt(i))){
                maxLen = maxLen > currentLen ? maxLen : currentLen;
                i-=set.size();
                currentLen = 0;
                set.clear();
            } else {
                currentLen++;
                set.add(s.charAt(i));
            }
        }
        maxLen = maxLen > currentLen ? maxLen : currentLen;
        return maxLen;
    }


    /**
     * 2. 两数相加
     */
    public static class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        ListNode node = head;
        int nextAdd = 0;

        while(l1 != null || l2 != null){

            ListNode next = new ListNode(0);
            node.next = next;
            node = next;

            node.val = nextAdd + (l1!=null?l1.val:0) + (l2!=null?l2.val:0);
            if(node.val >= 10){
                nextAdd = 1;
                node.val -= 10;
            } else {
                nextAdd = 0;
            }
            l1 = l1!=null?l1.next:l1;
            l2 = l2!=null?l2.next:l2;

        }

        if(nextAdd == 1){
            ListNode next = new ListNode(1);
            node.next = next;
            node = next;
        }

        return head.next;

//        ListNode head = new ListNode(0);
//        ListNode node = head;
//        int nextAdd = 0;
//
//        if (l1.val + l2.val + nextAdd >= 10){
//            node.val = nextAdd + l1.val + l2.val -10;
//            nextAdd = 1;
//        } else {
//            node.val = nextAdd+ l1.val + l2.val;
//            nextAdd = 0;
//        }
//        l1 = l1.next;
//        l2 = l2.next;
//
//        while(l1 != null && l2 != null){
//
//            ListNode next = new ListNode(0);
//            node.next = next;
//            node = next;
//
//            if (l1.val + l2.val + nextAdd >= 10){
//                node.val = nextAdd + l1.val + l2.val -10;
//                nextAdd = 1;
//            } else {
//                node.val = nextAdd+ l1.val + l2.val;
//                nextAdd = 0;
//            }
//            l1 = l1.next;
//            l2 = l2.next;
//        }
//
//        while(l1 != null){
//            ListNode next = new ListNode(0);
//            node.next = next;
//            node = next;
//            if (l1.val + nextAdd >= 10){
//                node.val = nextAdd + l1.val -10;
//                nextAdd = 1;
//            } else {
//                node.val = nextAdd+ l1.val;
//                nextAdd = 0;
//            }
//            l1 = l1.next;
//        }
//
//        while(l2 != null){
//            ListNode next = new ListNode(0);
//            node.next = next;
//            node = next;
//            if (l2.val + nextAdd >= 10){
//                node.val = nextAdd + l2.val -10;
//                nextAdd = 1;
//            } else {
//                node.val = nextAdd+ l2.val;
//                nextAdd = 0;
//            }
//            l2 = l2.next;
//        }
//
//        if(nextAdd == 1){
//            ListNode next = new ListNode(1);
//            node.next = next;
//            node = next;
//        }
//
//        return head;
    }

    /**
     * 1. 两数之和
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {

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


        // === 71 ms	39.4 MB ===

        // int[] result = new int[2];
        // for (int i = 0; i < nums.length - 1; i++) {
        //     for (int j = i + 1; j < nums.length; j++) {
        //         if (nums[i] + nums[j] == target && i != j) {
        //             result[0] = i;
        //             result[1] = j;
        //             return result;
        //         }
        //     }
        // }
        // return result;

        // === 171 ms	39.5 MB ===

        // int[] result = new int[2];
        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = 1; j < nums.length; j++) {
        //         if (nums[i]+nums[j]==target && i!=j){
        //             result[0] = i;
        //             result[1] = j;
        //             return result;
        //         }
        //     }
        // }
        // return result;

    }

}
