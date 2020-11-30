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
        RingQueue<Integer> ringQueue = new RingQueue<>(1);
        ringQueue.addAndShow(1);
        ringQueue.pollAndShow();
        ringQueue.addAndShow(2);
        ringQueue.pollAndShow();
        ringQueue.addAndShow(3);
    }

}
