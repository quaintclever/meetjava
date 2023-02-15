package com.quaint.algorithm.jzoffer;

import java.util.HashMap;
import java.util.Map;

public class JZ_01 {

    public static void main(String[] args) {
        JZ_01 jz = new JZ_01();
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // 链表的入环节点
    public ListNode detectCycle(ListNode head) {
        Map<ListNode, Integer> cache = new HashMap<>();
        int cnt = 0;
        while (head != null) {
            if (cache.containsKey(head)) {
                return head;
            }
            cache.put(head, cnt);
            head = head.next;
            cnt++;
        }
        return null;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }


    // 复制复杂链表
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node oldHead = head;
        Node newNode = new Node(head.val);
        Map<Node, Node> cache = new HashMap<>();

        cache.put(head, newNode);
        while (head.next != null) {
            newNode.next = new Node(head.next.val);
            cache.put(head.next, newNode.next);
            head = head.next;
            newNode = newNode.next;
        }

        head = oldHead;
        while (head != null) {
            cache.get(head).random = cache.get(head.random);
            head = head.next;
        }

        return cache.get(oldHead);
    }
}
