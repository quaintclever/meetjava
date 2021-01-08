package com.quaint.algorithm.year2020.may;

/**
 * <p>
 * desc:  21. 合并两个有序链表
 * <p>
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * </p>
 *
 * @author quaint
 * @since 01 May 2020
 */
public class OneQuestionPerDay_01_21 {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(4);
        l1.next = n1;
        n1.next = n2;

        ListNode l2 = new ListNode(1);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        l2.next = n3;
        n3.next = n4;

        ListNode listNode = mergeTwoLists(l1, l2);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }


    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode result = new ListNode(-1);
        ListNode head = result;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                result.next = l1;
                l1 = l1.next;
            } else {
                result.next = l2;
                l2 = l2.next;
            }
            result = result.next;
        }

        result.next = l1 != null ? l1 : l2;

        return head.next;
    }

}
