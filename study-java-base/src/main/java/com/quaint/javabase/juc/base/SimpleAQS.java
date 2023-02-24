package com.quaint.javabase.juc.base;

import com.quaint.javabase.jdkutil.JdkClassUtil;
import sun.misc.Unsafe;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleAQS {

    private volatile int state;
    protected transient volatile Node head;
    protected transient volatile Node tail;

    private static final Unsafe unsafe = JdkClassUtil.getUnsafe();
    private static final long stateOffset;
    private static final long headOffset;
    private static final long tailOffset;

    static {
        try {
            stateOffset = unsafe.objectFieldOffset(SimpleAQS.class.getDeclaredField("state"));
            headOffset = unsafe.objectFieldOffset(SimpleAQS.class.getDeclaredField("head"));
            tailOffset = unsafe.objectFieldOffset(SimpleAQS.class.getDeclaredField("tail"));
        } catch (Exception ex) {
            throw new Error(ex);
        }
    }


    private Node enq(final Node node) {
        for (; ; ) {
            Node t = tail;
            if (head == null) {
                if (compareAndSetHead(new Node()))
                    tail = head;
            } else {
                node.prev = tail;
                if (compareAndSetTail(t, node)) {
                    t.next = node;
                    return t;
                }
            }
        }
    }


    static class Node {
        public Thread th;
        public Node prev;
        public Node next;

        public Node() {
        }
    }

    private boolean compareAndSetState(int expect, int update) {
        return unsafe.compareAndSwapInt(this, stateOffset, expect, update);
    }

    private boolean compareAndSetHead(Node head) {
        return unsafe.compareAndSwapObject(this, headOffset, null, head);
    }

    private boolean compareAndSetTail(Node expect, Node update) {
        return unsafe.compareAndSwapObject(this, tailOffset, expect, update);
    }

    public static void main(String[] args) throws InterruptedException {
        SimpleAQS sa = new SimpleAQS();

        ExecutorService es = Executors.newFixedThreadPool(6);
        CountDownLatch cdl = new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            es.execute(() -> {
                Node node = new Node();
                node.th = new Thread();
                sa.enq(node);
                System.out.println(node.th.getName());
            });
            cdl.countDown();
        }
        cdl.await();
        System.out.println("===start===");
        System.out.println("===end===");
        System.out.println("===end2===");
        es.shutdown();
        System.out.println("===es shutdown===");
    }

}
