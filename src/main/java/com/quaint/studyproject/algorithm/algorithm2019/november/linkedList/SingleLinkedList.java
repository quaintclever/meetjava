package com.quaint.studyproject.algorithm.algorithm2019.november.linkedList;

import java.util.Stack;

/**
 * @Description: 如何实现一个高效的单向链表 逆序输出
 * @author: qi cong
 * @Date: Created in 2019-11-13 11:10
 */
public class SingleLinkedList {

    // 创建单项列表，并顺序输出
    public static void createList(ListNote<String> head){
        // 创建链表，长度为7
        int i = 7;
        while (i>0){
            ListNote<String> note = new ListNote<>("note"+i);
            note.setNext(head.getNext());
            head.setNext(note);
            i--;
        }
        // 顺序遍历链表
        while(head.getNext()!=null){
            System.out.println(head.getNext().getValue());
            head = head.getNext();
        }
    }

    // 逆序输出 单项链表
    public static void inverseList(ListNote<String> heard){

        Stack<ListNote<String>> noteStack = new Stack<>();
        while (heard.getNext()!=null){
            noteStack.push(heard.getNext());
            heard = heard.getNext();
        }

        while (!noteStack.empty()){
            System.out.println(noteStack.pop().getValue());
        }

    }



    public static void main(String[] args) {

        ListNote<String> head = new ListNote<>("head");
        System.out.println("Positive sequence output list");
        createList(head);
        System.out.println("Reverse output list");
        inverseList(head);

    }

}
