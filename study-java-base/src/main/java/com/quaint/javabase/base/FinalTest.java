package com.quaint.javabase.base;

import java.util.HashMap;
import java.util.Map;

public class FinalTest {

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();

        System.out.println("=======初始化=======");
        map.put("key1", "");
        System.out.println("k1 = " + map.get("key1"));
        System.out.println("k2 = " + map.get("key2"));
        System.out.println("=======执行change01=======");
        change01(map);
        System.out.println("k1 = " + map.get("key1"));
        System.out.println("k2 = " + map.get("key2"));
        System.out.println("=======执行change02=======");
        change02(map);
        System.out.println("k1 = " + map.get("key1"));
        System.out.println("k2 = " + map.get("key2"));
        System.out.println("=======执行change01=======");
        change01(map);
        System.out.println("k1 = " + map.get("key1"));
        System.out.println("k2 = " + map.get("key2"));
    }

    public static void change01(Map<String, Object> map) {
        // 不会对原来的 map 造成影响
        map = new HashMap<>();
        map.put("key1", "_01");
    }

    public static void change02(final Map<String, Object> map) {
        // final 标识变量的引用不可边，修改引用地址中的内容会对形参有影响
        map.put("key2", "_02");
    }
}
