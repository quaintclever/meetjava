package com.quaint.algorithm.daytest;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LC_01 {

    public static void main(String[] args) {
        LC_01 lc01 = new LC_01();
        int ans = lc01.maxValue(7132374,
                766527,
                167767740);
        System.out.println(ans);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        Deque<TreeNode> q = new LinkedList<>();
        Deque<TreeNode> q2 = new LinkedList<>();
        q.add(root);
        int level = 0;
        while (!q.isEmpty()) {
            ans.add(new ArrayList<>());
            while (!q.isEmpty()) {
                TreeNode peek = q.peekFirst();
                ans.get(level).add(peek.val);
                q2.offer(q.pollFirst());
            }
            while (!q2.isEmpty()) {
                TreeNode poll = q2.pollFirst();
                if (poll.left != null) {
                    q.offer(poll.left);
                }
                if (poll.right != null) {
                    q.offer(poll.right);
                }
            }
            level++;
        }
        return ans;
    }

    public void bfs(TreeNode node) {
        if (node == null) {
            return;
        }
        List<Integer> l = new ArrayList<>();
        l.add(node.val);

    }


    public int prefixCount(String[] words, String pref) {
        int ans = 0;
        for (String word : words) {
            if (word.indexOf(pref) == 0) {
                ans++;
            }
        }
        return ans;
    }

    public int countPairs(int[] nums, int low, int high) {
        int ans = 0;
        int l = nums.length;
        for (int i = 0; i < l; i++) {
            for (int j = i; j < l; j++) {
                int n = nums[i] ^ nums[j];
                if (n >= low && n <= high) {
                    ans++;
                }
            }
        }
        return ans;
    }

    // https://leetcode.cn/problems/maximum-value-at-a-given-index-in-a-bounded-array/
    public int maxValue(int n, int index, int maxSum) {
        int left = 1, right = maxSum;
        while (left < right) {
            // 检查是否满足 条件
            int mid = left + right + 1 >> 1;
            if (valid(mid, n, index, maxSum)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public boolean valid(int mid, int n, int index, int sumMax) {
        return mid + cal(mid, index) + cal(mid, n - index - 1) <= sumMax;
    }

    public long cal(int val, int len) {
        if (val - 1 > len) {
            int sv = val - len;
            return (long) (val - 1 + sv) * len / 2;
        } else {
            int ones = len - (val - 1);
            return (long) val * (val - 1) / 2 + ones;
        }
    }


}
