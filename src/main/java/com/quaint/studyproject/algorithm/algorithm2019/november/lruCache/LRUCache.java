package com.quaint.studyproject.algorithm.algorithm2019.november.lruCache;

import lombok.Data;

import java.util.HashMap;

/**
 * @Description: LRU 缓存机制
 * 设计和实现一个 LRU（最近最少使用）缓存数据结构，使它应该支持一下操作：get 和 put。
 * get(key) - 如果 key 存在于缓存中，则获取 key 的 value（总是正数），否则返回 -1。
 * put(key,value) - 如果 key 不存在，请设置或插入 value。当缓存达到其容量时，它应该在插入新项目之前使最近最少使用的项目作废。
 * @author: qi cong
 * @Date: Created in 2019/11/21 14:47
 */
@Data
public class LRUCache {

    // 缓存 key
    private String key;
    // 缓存 value
    private int value;
    // 缓存容器
    private HashMap<String,Integer> container;
    // 容器大小
    private int containerSize;

    public int get(String key){

//        if ()
//        // 没有找到，返回-1
        return -1;
    }

    public void put(String key,int value){
        if (value<0) return;

    }

}
