package com.quaint.algorithm.year2020.november;

import com.quaint.algorithm.year2020.november.ring.RingQueue;

/**
 * <p>
 * desc:
 * </p>
 *
 * @author quaint
 * @since 30 November 2020
 */
public class RingQueueTest {

    public static void main(String[] args) {
        RingQueue<Integer> ringQueue = new RingQueue<>(2);

        System.out.println("add => 1");
        ringQueue.add(1);
        ringQueue.showHeadTail();

        System.out.println("add => 2");
        ringQueue.add(2);
        ringQueue.showHeadTail();

        System.out.println("poll => " + ringQueue.poll());
        ringQueue.showHeadTail();

        System.out.println("add => 3");
        ringQueue.add(3);
        ringQueue.showHeadTail();

        System.out.println("peek => " + ringQueue.peek());
        ringQueue.showHeadTail();

        System.out.println("poll => " + ringQueue.poll());
        ringQueue.showHeadTail();

        System.out.println("peek => " + ringQueue.peek());
        ringQueue.showHeadTail();

        System.out.println("poll => " + ringQueue.poll());
        ringQueue.showHeadTail();

    }

}
