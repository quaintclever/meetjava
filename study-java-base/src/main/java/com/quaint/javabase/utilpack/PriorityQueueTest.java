package com.quaint.javabase.utilpack;

import java.util.PriorityQueue;

public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, d) -> d - a);
        pq.add(1);
        pq.add(4);
        pq.add(3);
        pq.add(6);
        pq.add(2);
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }

        // a标识 asc 升序， d 标识 desc，降序， 以前面为主， 相减
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, d) -> a[1] - d[1]);
        heap.add(new int[]{});
    }

}
