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
        test2();
    }

    private static void test2() {
        RingQueue<Integer> ringQueue = new RingQueue<>();
        ringQueue.addAndShow(1);
        ringQueue.addAndShow(1);
        ringQueue.addAndShow(2);
        ringQueue.addAndShow(2);
        ringQueue.addAndShow(3);
        ringQueue.addAndShow(4);
        ringQueue.addAndShow(5);
        ringQueue.addAndShow(6);
        ringQueue.pollAndShow();
        ringQueue.pollAndShow();
        ringQueue.pollAndShow();
        ringQueue.addAndShow(7);
        ringQueue.addAndShow(8);
        ringQueue.addAndShow(9);
        ringQueue.addAndShow(9);
    }

}
