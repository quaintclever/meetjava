package com.quaint.sp.algorithm.year2019.bstTest;

import lombok.Data;

import java.util.Objects;

/**
 * @Description:
 * @author: qi cong
 * @Date: Created in 2019-11-14 16:32
 */
@Data
public class BstTree {

    // 树的结点个数
    private int size;
    private TreeNote root;

    public BstTree(TreeNote root) {
        this.size = 1;
        this.root = root;
    }

    public boolean isNull(TreeNote note){
        return Objects.isNull(note);
    }

    public boolean isNotNull(TreeNote note){
        return !isNull(note);
    }


    public void addNote(TreeNote note,TreeNote root){

        if (note.getVal() >=  (root.getVal())){
            if (isNull(root.getRight())){
                root.setRight(note);
                note.setParent(root);
                size++;
            } else{
                addNote(note,root.getRight());
            }
        } else {
            if (isNull(root.getLeft())){
                root.setLeft(note);
                note.setParent(root);
                size++;
            }else{
                addNote(note,root.getLeft());
            }
        }
    }

    /**
     * 先序遍历树
     * @param root
     */
    public void printNote(TreeNote root){
        if (isNotNull(root.getLeft()))
            printNote(root.getLeft());
        System.out.println(root.getVal());
        if (isNotNull(root.getRight()))
            printNote(root.getRight());
    }

}
