package com.quaint.studyproject.algorithm.algorithm2019.november.lruCache;

import lombok.Data;

/**
 * @Description: 双向链表实现
 * @author: qi cong
 * @Date: Created in 2019/11/21 15:00
 */
public class TwoWayLinked<T> {

    // 头节点
    private Note<T> first;
    // 尾节点
    private Note<T> last;
    // 队列长度
    private int size;

    // 在链表之前添加
    public void addFirst(T obj){
        Note note = new Note(obj);
        if (size == 0) {
            first = note;
            last = note;
        } else{
            note.next=first;
            first.prev = note;
            first = note;
        }
        size++;
    }

    // 在链表之后添加
    public void addLast(T obj){
        Note note = new Note(obj);
        if (size == 0) {
            first = note;
            last = note;
        } else{
            note.prev=last;
            last.next = note;
            last = note;
        }
        size++;
    }

    // 移除链表元素
    public void remove(T obj){
        Note note = this.first;
        for (int i = 0; i < size; i++) {
            if (!note.obj.equals(obj)){
                if (note.next == null) {
                    return;
                }
                note = note.next;
            }
        }
        if (note == this.first){
            this.first = first.next;
            first.prev = null;
        } else if (note == this.last){
            this.last = last.prev;
            last.next = null;
        } else {
            note.prev.next = note.next;
            note.next.prev = note.prev;
        }
        size--;
    }

    // 移除最后一个元素
    public void removeLast(){
        if (size<2) return;
        else this.last.prev.next=null;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        StringBuffer sb = new StringBuffer("[");
        Note note = this.first;
        for (int i = 0; i < size-1; i++) {
            sb.append(note.obj.toString());
            if (i!=size-1) sb.append(",");
            else sb.append("]");
            note = note.next;
        }
        return sb.toString();
    }

    @Data
    class Note<T>{
        private T obj;
        private Note prev;
        private Note next;

        public Note() {
        }

        public Note(T obj) {
            this.obj = obj;
        }
    }

}
