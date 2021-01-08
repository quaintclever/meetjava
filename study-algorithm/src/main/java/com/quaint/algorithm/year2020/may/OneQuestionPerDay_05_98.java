package com.quaint.algorithm.year2020.may;

/**
 * <p>
 * desc: 98. 验证二叉搜索树
 *
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * </p>
 *
 * @author quaint
 * @since 14 May 2020
 */
public class OneQuestionPerDay_05_98 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(4);
        TreeNode right1 = new TreeNode(3);
        TreeNode right2 = new TreeNode(6);
        root.left = left;
        root.right = right;
//        right.left = right1;
//        right.right = right2;

        System.out.println(isValidBST(root));


    }


    public static boolean isValidBST(TreeNode root) {
        return helper(root,null,null);
    }


    /**
     * 官方解法一
     * @param root
     * @param lower
     * @param upper
     * @return
     */
    public static boolean helper(TreeNode root, Integer lower, Integer upper){
        if (root==null){
            return true;
        }
        if (lower != null && root.val <= lower){
            return false;
        }
        if (upper != null && root.val >= upper){
            return false;
        }

        if (!helper(root.left,lower,root.val)){
            return false;
        }
        if (!helper(root.right,root.val,upper)){
            return false;
        }
        return true;
    }




    /**
     * 自己的解法. 太low 了
     * @param root
     * @return
     */
    public static boolean isValidBST1(TreeNode root) {
        if (root == null){
            return true;
        }
        return recurse(root.left,Long.MIN_VALUE,root.val) && recurse(root.right,root.val,Long.MAX_VALUE);
    }

    public static boolean recurse(TreeNode root, long lower, long upper){

        if (root == null){
            return true;
        }
        boolean leftCheck = true;
        boolean rightCheck = true;

        if (root.val <= lower || root.val >= upper){
            return false;
        }

        if (root.left != null){
            if (root.left.val <= lower || root.left.val >= upper){
                return false;
            } else {
                leftCheck = recurse(root.left, lower ,root.val);
            }
        }

        if (root.right != null){
            if (root.right.val <= lower || root.right.val >= upper){
                return false;
            } else {
                rightCheck = recurse(root.right, root.val, upper);
            }
        }

        return leftCheck && rightCheck;
    }


}
