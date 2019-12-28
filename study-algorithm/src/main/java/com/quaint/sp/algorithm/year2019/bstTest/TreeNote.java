package com.quaint.sp.algorithm.year2019.bstTest;

import lombok.Data;

/**
 * @Description:
 * @author: qi cong
 * @Date: Created in 2019-11-14 10:56
 */
@Data
public class TreeNote{

    private int val;
    private TreeNote left;
    private TreeNote right;
    private TreeNote parent;

    public TreeNote(int val) {
        this.val = val;
    }

    public int getChildSize(){
        if (left == null && right == null) return 1;
        else return (left==null?0:left.getChildSize()) + (right==null?0:right.getChildSize()) + 1;
    }

}
