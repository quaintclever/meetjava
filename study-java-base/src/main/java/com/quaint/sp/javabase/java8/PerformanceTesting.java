package com.quaint.sp.javabase.java8;

import java.util.function.Consumer;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author quaint
 * @date 2020-01-17 17:45
 */
public class PerformanceTesting {

    public static void main(String[] args) {

        // 12
        System.out.println(Runtime.getRuntime().availableProcessors());

        // normalTest time is:22ms
        System.out.println("normalTest time is:" + selectBestPerformance(PerformanceTesting::normalTest,50_000_000) +"ms");
        // iterateTest time is:432ms
        System.out.println("iterateTest time is:" + selectBestPerformance(PerformanceTesting::iterateTest,50_000_000) +"ms");
        // iterateAndParallelTest time is:950ms
        System.out.println("iterateAndParallelTest time is:" + selectBestPerformance(PerformanceTesting::iterateAndParallelTest,50_000_000) +"ms");
        // iterateAndParallelTest2 time is:749ms
        System.out.println("iterateAndParallelTest2 time is:" + selectBestPerformance(PerformanceTesting::iterateAndParallelTest2,50_000_000) +"ms");
        // iterateAndParallelTest3 time is:3ms [最强]
        System.out.println("iterateAndParallelTest3 time is:" + selectBestPerformance(PerformanceTesting::iterateAndParallelTest3,50_000_000) +"ms");
        // iterateAndParallelTest4 time is:27ms
        System.out.println("iterateAndParallelTest4 time is:" + selectBestPerformance(PerformanceTesting::iterateAndParallelTest4,50_000_000) +"ms");

    }

    private static long selectBestPerformance(Consumer<Long> consumer, long limitNum){

        long time = Long.MAX_VALUE;
        for (int i = 0; i < 7; i++) {
            long startTime = System.currentTimeMillis();
            consumer.accept(limitNum);
            long useTime = System.currentTimeMillis()-startTime;
            time = useTime<time ? useTime : time;
        }
        return time;
    }

    private static void iterateTest(long num){
        Long reduce = Stream.iterate(0L, i -> i + 1)
                .limit(num).reduce(0L, Long::sum);
//        System.out.println("result: -> "+reduce);
    }

    private static void iterateAndParallelTest(long num){
        Stream.iterate(0L, i -> i + 1).parallel()
                .limit(num).reduce(0L, Long::sum);
    }

    private static void iterateAndParallelTest2(long num){
        Stream.iterate(0L, i -> i + 1).mapToLong(Long::longValue).parallel()
                .limit(num).reduce(0L, Long::sum);
    }

    private static void iterateAndParallelTest3(long num){
        LongStream.rangeClosed(0L,num).parallel().sum();
    }

    private static void iterateAndParallelTest4(long num){
        LongStream.rangeClosed(0L,num).parallel().reduce(0L,Long::sum);
    }
    

    private static void normalTest(long num){

        long result = 0;
        for (int i = 0; i < num; i++) {
            result += i;
        }
//        System.out.println("result: -> "+result);
    }


}
