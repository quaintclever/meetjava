package com.quaint.algorithm.year2021.april;

import java.util.*;

/**
 * <p>
 * desc:
 * </p>
 *
 * @author quaint
 * @since 04 April 2021
 */
public class Comp1 {

    public static void main(String[] args) {
        Comp1 c1 = new Comp1();
    }


    public int countDifferentSubsequenceGCDs(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        List<Integer> list = new ArrayList<>(set);
        Set<Integer> ans = new HashSet<>();
        dfs(ans,new ArrayList<>(), list, 0);
        ans.forEach(System.out::println);
        return ans.size();
    }

    public void dfs(Set<Integer> set, List<Integer> ch, List<Integer> list, int idx){
        if (idx == list.size()) {
            if (ch.size() == 1){
                set.add(ch.get(0));
            } else {
                Optional<Integer> min = ch.stream().min(Integer::compareTo);
                if (min.isPresent()){
                    int y = 1;
                    for (int i = 1; i <= min.get(); i++) {
                        boolean b = true;
                        for (int j = 0; j < ch.size(); j++) {
                            if(ch.get(j) % i != 0) {
                                b = false;
                                break;
                            }
                        }
                        if (b) {
                            y = i;
                        }
                    }
                    set.add(y);
                }
            }
            return;
        }

        ch.add(list.get(idx));
        dfs(set,ch,list,idx + 1);
        ch.remove(ch.size()-1);
        dfs(set, ch, list, idx + 1);
    }


    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int maxIdx = 0;
        int maxVal = Integer.MIN_VALUE;
        int ans = 0;
        for (int i = 0; i < nums1.length; i++) {
            int temp = Math.abs(nums1[i] - nums2[i]);
            temp %= 1000000007;
            if (temp > maxVal) {
                maxVal = temp;
                maxIdx = i;
            }
            ans += temp;
        }
        int minVal = maxVal;
        for (int i = 0 ; i < nums1.length; i++) {
            int temp = Math.abs(nums1[i] - nums2[maxIdx]);
            temp %= 1000000007;
            if (temp < minVal) {
                minVal = temp;
            }
        }
        return (ans - maxVal + minVal) % 1000000007;
    }

    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer,Integer> mp = new HashMap<>();
        Set<String> s = new HashSet<>();
        for(int i = 0; i < logs.length; i ++) {
            String t = logs[i][0] + ":" + logs[i][1];
            if(!s.contains(t)) {
                s.add(t);
                if (mp.get(logs[i][0]) == null){
                    mp.put(logs[i][0],1);
                } else {
                    mp.put(logs[i][0],mp.get(logs[i][0]) + 1);
                }
            }
        }
        int[] ans = new int[k];
        Arrays.fill(ans,0);
        mp.forEach((ke,v) -> {
            if (v != null) {
                ans[v-1] = ans[v-1] + 1;
            }
        });
        return ans;
    }


    public String truncateSentence(String s, int k) {
        String[] s1 = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k - 1; i++) {
            sb.append(s1[i]).append(" ");
        }
        sb.append(s1[k-1]);
        return sb.toString();
    }




}
