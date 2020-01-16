package com.quaint.sp.javabase.java8.function;

import com.quaint.sp.javabase.java8.helper.Book;

import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

/**
 * @author quaint
 * @date 2020-01-05 19:38
 */
public class LambdaFunctionTest<T> {

    protected static void process(Runnable run){
        run.run();
    }

    protected static <T> List filterBook(List<T> list, Predicate<T> predicate){
        return list.stream().filter(predicate).collect(Collectors.toList());
    }

    protected static List<Book> filterBookBi(List<Book> list, BiPredicate<String,Integer> predicate){
        return list.stream().filter(l -> predicate.test(l.getColor(),l.getPage())).collect(Collectors.toList());
    }

    protected static <T> void consumerSimple(List<T> list, Consumer<T> consumer){
        list.forEach(consumer);
    }

    protected static <T> void consumerSimple(String str, List<T> list, BiConsumer<T,String> consumer){
        list.forEach(l->consumer.accept(l,str));
    }

    protected static <T> List addPageFunction(List<T> list, Function<T,T> function){
        return list.stream().map(function).collect(Collectors.toList());
    }

    protected static <T> T addBookFunction(String color, Integer page, BiFunction<String,Integer,T> function){
        return function.apply(color,page);
    }

    protected static <T> T createT(Supplier<T> supplier){
        return supplier.get();
    }

}
