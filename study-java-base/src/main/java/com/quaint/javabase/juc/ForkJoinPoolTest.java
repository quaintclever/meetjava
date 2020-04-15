package com.quaint.javabase.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * <p>
 * desc: fork join pool test
 * </p>
 *
 * @author quaint
 * @since 15 April 2020
 */
public class ForkJoinPoolTest {

    public static void main(String[] args) {

        String test = "quaint-test-str,fork-join-pool!";
        int width = 3;

        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        List<String> invoke = forkJoinPool.invoke(new StrTask(test, width));
        invoke.forEach(System.out::println);
    }

    private static class StrTask extends RecursiveTask<List<String>> {

        String str;
        int width;
        List<String> list;

        public StrTask(String str, int width) {
            this.str = str;
            this.width = width;
            this.list = new ArrayList<>();
        }

        @Override
        protected List<String> compute() {
            if (str.length() <= width){
                list.add(str);
                return list;
            }
            int limit = str.length()/2 - str.length()/2 % width;
            limit = limit <= 0 ? width : limit;
            StrTask taskLeft = new StrTask(str.substring(0,limit), width);
            StrTask taskRight = new StrTask(str.substring(limit), width);
            taskLeft.fork();
            taskRight.fork();
            list.addAll(taskLeft.join());
            list.addAll(taskRight.join());
            return list;
        }
    }
}
