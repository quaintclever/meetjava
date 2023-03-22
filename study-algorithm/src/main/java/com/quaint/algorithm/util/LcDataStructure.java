package com.quaint.algorithm.util;

import java.util.List;

/**
 * @author quaint
 * @since 2023/3/22 21:55
 */
public class LcDataStructure {
    /**
     * mod
     */
    public static int MOD = (int) 1e9 + 7;

    /**
     * Definition for a binary tree node.
     */
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode() {
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

    /**
     * Definition for Employee.
     */
    public class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

}
