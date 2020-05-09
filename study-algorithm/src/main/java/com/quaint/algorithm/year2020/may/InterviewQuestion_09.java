package com.quaint.algorithm.year2020.may;

import java.util.Stack;

/**
 * <p>
 * desc: 面试题09. 用两个栈实现队列
 *
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。
 * (若队列中没有元素，deleteHead 操作返回 -1 )
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author quaint
 * @since 09 May 2020
 */
public class InterviewQuestion_09 {

    public static void main(String[] args) {

        CQueue2 cQueue = new CQueue2();
        cQueue.appendTail(1);
        cQueue.appendTail(2);
        cQueue.appendTail(3);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        cQueue.appendTail(4);
        System.out.println(cQueue.deleteHead());
        cQueue.appendTail(5);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());

    }

    public static class CQueue2 {

        private Stack<Integer> s1;
        private Stack<Integer> s2;
        private int size;

        public CQueue2() {
            s1 = new Stack<>();
            s2 = new Stack<>();
            size = 0;
        }

        public void appendTail(int value) {
            s1.push(value);
            size++;
        }

        public int deleteHead() {

            if (size==0){
                return -1;
            }

            if (s2.isEmpty()){
                while (!s1.isEmpty()){
                    s2.push(s1.pop());
                }
            }
            size--;
            return s2.pop();

        }
    }


    public static class CQueue {

        private Stack<Integer> s1;
        private Stack<Integer> s2;

        public CQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        public void appendTail(int value) {
            int len = s1.size();
            for (int i = 0; i < len; i++) {
                s2.push(s1.pop());
            }
            s1.push(value);
            for (int i = 0; i < len; i++) {
                s1.push(s2.pop());
            }
        }

        public int deleteHead() {
            return s1.size()>0 ? s1.pop() : -1;
        }
    }


}
