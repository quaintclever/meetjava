package com.quaint.studyproject.algorithmTest.algorithm_2019.november.bstTest;

import lombok.Data;

/**
 * @Description:
 * @author: qi cong
 * @Date: Created in 2019-11-14 10:56
 */
@Data
public class TreeNote{

    private int val;
    // 有几个子节点
    private int size;
    private TreeNote left;
    private TreeNote right;
    private TreeNote prent;

    public TreeNote(int val) {
        this.val = val;
        this.size = 0;
    }

    public int getChildSize(){
        if (left == null && right == null) return 1;
        else return (left==null?0:left.getChildSize()) + (right==null?0:right.getChildSize());
    }

}
