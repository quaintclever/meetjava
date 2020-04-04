package com.quaint.javabase.utilpack;

import java.util.Map;
import java.util.Scanner;
import java.util.WeakHashMap;

/**
 * @author quaint
 * 04 April 2020
 * @since 1.26
 */
public class WeakHashMapTest {

    static class TestBody{

        String name;

        public TestBody(String name) {
            this.name = name;
        }

        @Override
        public void finalize() throws Throwable {
            System.out.println(name+": finalize!");
            super.finalize();
        }
    }

    public static void main(String[] args) {

        Map<String,TestBody> map = new WeakHashMap<>();

        map.put("test",new TestBody("ymq"));
        map.put("test",new TestBody("quaint"));

        map.put("test2",new TestBody("caiji"));
        map.put("test2",new TestBody("wjs"));

        // 虚引用,当没有强引用时.调用gc 会干掉虚引用
        System.gc();

        Scanner in = new Scanner(System.in);
        String next = in.next();
        System.out.println(next);

    }

}
