package com.quaint.algorithm.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * leetcode 数据处理 工具类
 *
 * @author quaint
 * @since 2023/3/22 21:53
 */
public class LcDataProcessUtil extends LcDataStructure {

    /**
     * 获取 一维 int 数组
     *
     * @param arr 字符串数组  eg:  [1,2,3,4,5]  or 1,2,3,4,5
     * @return int[]
     */
    public static int[] get1dArr(String arr) {
        if ("[]".equals(arr) || "".equals(arr)) {
            return new int[]{};
        }
        String str;
        if (arr.startsWith("[") && arr.endsWith("]")) {
            str = arr.substring(1, arr.length() - 1);
        } else {
            str = arr;
        }
        String[] strArr = str.split(",");
        int[] res = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            res[i] = Integer.parseInt(strArr[i]);
        }
        return res;
    }

    /**
     * 获取 一维 字符串 数组
     *
     * @param arr 字符串数组  eg:  "[\"i\", \"love\", \"leetcode\", \"i\", \"love\", \"coding\"]"
     * @return String[]
     */
    public static String[] get1dArrStr(String arr) {
        if ("[]".equals(arr) || "".equals(arr)) {
            return new String[]{};
        }
        // 去掉引号
        arr = arr.replace("\"", "");
        arr = arr.replace(" ", "");
        String str;
        if (arr.startsWith("[") && arr.endsWith("]")) {
            str = arr.substring(1, arr.length() - 1);
        } else {
            str = arr;
        }
        return str.split(",");
    }

    /**
     * 获取 二维 int 数组
     *
     * @param arr 字符串数组  eg:  "[[1,2,3,4,5]]"
     * @return int[][]
     */
    public static int[][] get2dArr(String arr) {
        if ("[[]]".equals(arr) || "".equals(arr)) {
            return new int[][]{};
        }

        // 处理字符串
        String str = arr.substring(1, arr.length() - 2);
        str = str.replace("[", "");
        String[] strArr = str.split("],");

        // 定义数组大小
        int m = strArr.length;
        int n = 0;
        for (String s : strArr) {
            n = Math.max(s.split(",").length, n);
        }

        // 给数组赋值.
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            String[] inArr = strArr[i].split(",");
            for (int j = 0; j < n && j < inArr.length; j++) {
                res[i][j] = Integer.parseInt(inArr[j]);
            }
        }
        return res;
    }

    /**
     * 获取 二维 List
     *
     * @param arr 字符串数组  eg:  "[[1,2,3,4,5]]"
     * @return List<List < Integer>>
     */
    public static List<List<Integer>> get2dList(String arr) {
        if ("[[]]".equals(arr) || "".equals(arr)) {
            return new ArrayList<>();
        }

        // 处理字符串
        String str = arr.substring(1, arr.length() - 2);
        str = str.replace("[", "");
        String[] strArr = str.split("],");

        // 准备返回数据
        List<List<Integer>> res = new ArrayList<>();
        for (String s1 : strArr) {
            List<Integer> cur = new ArrayList<>();
            String[] inArr = s1.split(",");
            for (String s2 : inArr) {
                cur.add(Integer.parseInt(s2));
            }
            res.add(cur);
        }
        return res;
    }

    /**
     * 获取 TreeNode
     * eg:
     * [3,5,1,6,2,9,8,null,null,7,4]
     * <p>
     * 3
     * /   \
     * 5      1
     * / \    / \
     * 6  2   9   8
     * / \
     * 7  4
     *
     * @param str 字符串数组
     * @return tree
     */
    @SuppressWarnings("all")
    public static TreeNode getTree(String str) {
        // 返回空树
        if ("[]".equals(str) || str.length() < 3) {
            return null;
        }
        // 处理数据
        String treeStr = str.substring(1, str.length() - 1);
        String[] treeStrArr = treeStr.split(",");
        if ("null".equals(treeStrArr[0])) {
            return null;
        }

        // 创建树
        TreeNode root = new TreeNode();
        root.val = Integer.parseInt(treeStrArr[0]);
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        TreeNode node = null;
        for (int i = 1; i < treeStrArr.length; i++) {
            if ((i & 1) == 1) {
                node = que.poll();
            }
            if (!"null".equals(treeStrArr[i])) {
                TreeNode subNode = new TreeNode();
                subNode.val = Integer.parseInt(treeStrArr[i]);
                if ((i & 1) == 1) {
                    node.left = subNode;
                } else {
                    node.right = subNode;
                }
                que.offer(subNode);
            }
        }
        return root;
    }


}
