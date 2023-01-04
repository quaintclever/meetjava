package com.quaint.algorithm.year2019.bstTest;
/**
 * @Description:
 * @author: qi cong
 * @Date: Created in 2019-11-14 10:56
 */
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

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNote getLeft() {
        return left;
    }

    public void setLeft(TreeNote left) {
        this.left = left;
    }

    public TreeNote getRight() {
        return right;
    }

    public void setRight(TreeNote right) {
        this.right = right;
    }

    public TreeNote getParent() {
        return parent;
    }

    public void setParent(TreeNote parent) {
        this.parent = parent;
    }
}
