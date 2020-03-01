package com.quaint.javabase.java8;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * 自定义 collector toList
 * @author quaint
 * @date 2020-01-17 16:59
 */
public class QuaintCollectorToList<T> implements Collector<T, List<T>,List<T>> {

    private void log(String str){
        System.out.println(Thread.currentThread().getName()+ " -> " + str);
    }

    @Override
    public Supplier<List<T>> supplier() {
        log("supplier");
        return ArrayList::new;
    }

    @Override
    public BiConsumer<List<T>, T> accumulator() {
        log("accumulator");
        return List::add;
    }

    @Override
    public BinaryOperator<List<T>> combiner() {
        log("combiner");
        return (left,right)->{
            left.addAll(right);
            return left;
        };
    }

    @Override
    public Function<List<T>, List<T>> finisher() {
        log("finisher");
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        log("characteristics");
        return Collections.unmodifiableSet(
                EnumSet.of(
                    Collector.Characteristics.IDENTITY_FINISH,
                    Characteristics.CONCURRENT
                )
        );
    }


    public static void main(String[] args) {

        QuaintCollectorToList<String> quaint = new QuaintCollectorToList<>();

        List<String> strings = Arrays.asList("quaint", "test", "collector", "auto", "main");

        List<String> quaintCollect = strings.stream().filter(s -> s.length() > 4).collect(quaint);

        Optional.ofNullable(quaintCollect).ifPresent(System.out::println);

    }

}
