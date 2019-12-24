package com.quaint.studyproject.algorithm.algorithm2019.november.bstTest;

import java.util.*;

/**
 * @Description:
 * @author: qi cong
 * @Date: Created in 2019-11-14 10:52
 * #### **题目**：给定一个二叉搜索树(BST)，找到树中第 K 小的节点。
 * ##### * 考察点
 * 1. 基础数据结构的理解和编码能力
 * 2. 递归使用
 * ##### * 示例
 * ```
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 *  ```
 * 说明：保证输入的 K 满足 1<=K<=(节点数目）
 */
public class BstTest {

    /**
     * 生成 二叉搜索树
     * @return
     */
    public static BstTree createBst(){

        // 生成随机 插入树的 int 值
        Random random = new Random();
        Set sets = new HashSet();
        do {
            sets.add(random.nextInt(20));
        } while (sets.size() < 10);
        Iterator it = sets.iterator();

        // 创建一颗树
        BstTree bstTree = new BstTree(new TreeNote((int) it.next()));
        while (it.hasNext()){
            Integer num = (Integer)it.next();
            bstTree.addNote(new TreeNote(num),bstTree.getRoot());
        }
        return bstTree;
    }

    public static int findKMinNote(TreeNote root, int k){

        if (root.getLeft()!=null){
            int left = root.getLeft().getChildSize();
            if (left == k-1)
                return root.getVal();
            else if (left > k-1)
                return findKMinNote(root.getLeft(),k);
            else
                return findKMinNote(root.getRight(),k-left-1);
        } else {
            if (k==1)
                return root.getVal();
            return findKMinNote(root.getRight(),k-1);
        }
    }


    public static void main(String[] args) {

        BstTree bstTree = createBst();
        // 先序遍历
        bstTree.printNote(bstTree.getRoot());
        System.out.println("根节点的值："+bstTree.getRoot().getVal());
        System.out.println("根节点下的节点个数："+bstTree.getRoot().getChildSize());

        System.out.println("请输入要寻找的第k小的数字（1~10）：");
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int val = findKMinNote(bstTree.getRoot(),k);
        System.out.println("-----------");
        System.out.println(val);

    }

}
