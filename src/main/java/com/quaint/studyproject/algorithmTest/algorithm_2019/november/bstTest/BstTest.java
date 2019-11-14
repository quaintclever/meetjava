package com.quaint.studyproject.algorithmTest.algorithm_2019.november.bstTest;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

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
        for (int i = 0; i < 10; i++) {
            sets.add(random.nextInt(20));
        }
        Iterator it = sets.iterator();

        // 创建一颗树
        BstTree bstTree = new BstTree(new TreeNote((int) it.next()));
        while (it.hasNext()){
            Integer num = (Integer)it.next();
            bstTree.addNote(new TreeNote(num),bstTree.getRoot());
        }
        return bstTree;
    }


    public static void main(String[] args) {

        BstTree bstTree = createBst();


    }

}
