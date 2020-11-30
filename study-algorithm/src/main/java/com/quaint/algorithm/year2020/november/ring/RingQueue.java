package com.quaint.algorithm.year2020.november.ring;

/**
 * <p>
 * desc:
 *
 * 队列实现起来相对比栈复杂一点，因为栈的一端是固定的，元素的出和入都在另一端，而队列一边入一边出，导致首尾两端都是移动的。
 *
 * 鉴于这种移动性，我们可以将数组定义为环形数组，将首和尾连接起来。
 *
 * 我们使用一个数组q[0…n-1]来实现一个至多含n-1个元素的队列。队列具有属性head和tail，head指向队列的头，tail指向新元素将会被插入的位置。
 *
 * 于是队列的元素为q[head], q[head+1],…,q[tail-1]，注意，在n-1和0的地方要进行卷绕。
 * 当head=tail时，队列为空，当head=tail+1时，队列是满的。
 *
 * </p>
 *
 * @author quaint
 * @since 30 November 2020
 */
public class RingQueue<T>{

    private static final Object[] DEFAULTCAPACITY_TEN_ELEMENTDATA = new Object[11];
    private Object[] elementData;

    private int head = 0;
    private int tail = 0;
    private int capacity = 11;

    public RingQueue() {
        this.elementData = DEFAULTCAPACITY_TEN_ELEMENTDATA;
    }

    public RingQueue(int initialCapacity) {
        if (initialCapacity > 1) {
            this.elementData = new Object[initialCapacity + 1];
            capacity = initialCapacity + 1;
        } else {
            throw new IllegalArgumentException("Illegal capacity must more than the one: "+ initialCapacity);
        }
    }

    public boolean add(T t) {
        rangeCheck();
        elementData[tail++] = t;
        tail = tail % capacity;
        return true;
    }

    @SuppressWarnings("unchecked")
    public T poll() {
        if (isEmpty()) {
            throw new RuntimeException("RingQueue is Empty!");
        } else {
            int temp = head;
            head ++;
            head = head % capacity;
            return (T) elementData[temp];
        }
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("RingQueue is Empty!");
        } else {
            return (T) elementData[head];
        }
    }

    /**
     * 检查是否为空
     * @return
     */
    public boolean isEmpty() {
        return head == tail;
    }

    /**
     * 检查是否越界
     * h
     * 0 1
     *   t
     */
    private void rangeCheck() {
        if (head == (tail + 1) % capacity) {
            throw new IndexOutOfBoundsException();
        }
    }

    public void showHeadTail() {
        System.out.println("=================");
        System.out.println("|\t" +numIdx(head) + "h");
        System.out.println("|\t" +toString(elementData));
        System.out.println("|\t" +numIdx(tail) + "t");
        System.out.println("=================");
    }

    private static String numIdx(int num) {
        StringBuilder sb = new StringBuilder(" ");
        for (int i = 0; i < num; i++) {
            sb.append("   ");
        }
        return sb.toString();
    }

    private static String toString(Object[] a) {
        if (a == null) {
            return "-";
        }
        int iMax = a.length - 1;
        if (iMax == -1) {
            return "[]";
        }

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(a[i] == null? "-" : a[i]);
            if (i == iMax) {
                return b.append(']').toString();
            }
            b.append(", ");
        }
    }

}
