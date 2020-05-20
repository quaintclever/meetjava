package com.quaint.javabase.java8;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * desc:
 * </p>
 *
 * @author quaint
 * @since 20 May 2020
 */
public class StreamAndForTest {

    public static void main(String[] args) {

        int limit = 1000000;
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < limit; i++) {
            integerList.add(i);
        }

        long start = System.currentTimeMillis();
        int sum = integerList.parallelStream().mapToInt(i -> i).sum();
        long end = System.currentTimeMillis();
        System.out.println("parallelStream time is ==>\t\t" + (end-start) + "ms \nans is ==>" + sum);

        long start2 = System.currentTimeMillis();
        int sum2 = integerList.stream().mapToInt(i -> i).sum();
        long end2 = System.currentTimeMillis();
        System.out.println("stream time is ==>\t\t" + (end2-start2) + "ms \nans is ==>" + sum2);

        int sum3 = 0;
        long start3 = System.currentTimeMillis();
        for (int i = 0; i < limit; i++) {
            sum3+=integerList.get(i);
        }
        long end3 = System.currentTimeMillis();
        System.out.println("for time is ==>\t\t" + (end3-start3) + "ms \nans is ==>" + sum3);

    }

}
