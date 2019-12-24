package com.quaint.studyproject.algorithm.algorithm2019.november.linkedList;

/**
 * @Description:
 * @author: qi cong
 * @Date: Created in 2019-11-13 11:13
 */
public class ListNote<T> {

    private T value;

    private ListNote<T> next;

    public ListNote(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public ListNote<T> getNext() {
        return next;
    }

    public void setNext(ListNote<T> next) {
        this.next = next;
    }
}
