package com.quaint.sp.javabase.java8.function;

import com.quaint.sp.javabase.java8.helper.Book;
import com.quaint.sp.javabase.java8.helper.Box;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author quaint
 * @date 2020-01-16 15:35
 */
public class Collectors2FunctionTest {

    protected static void testGroupingByFunction(List<Book> list){
        System.out.println("testGroupingByFunction");
        Optional.ofNullable(list.stream().collect(Collectors.groupingBy(Book::getColor))).ifPresent(System.out::println);
    }

    protected static void testGroupingByAveragingInt(List<Book> list){
        System.out.println("testGroupingByAveragingInt");
        Optional.ofNullable(list.stream()
                .collect(Collectors.groupingBy(Book::getColor,Collectors.averagingInt(Book::getPage))))
                .ifPresent(System.out::println);
    }

    protected static void testCollectingAndThen(List<Box> list){
        System.out.println("testCollectingAndThen");
        Optional<Map<String, List<Book>>> collect = Optional.ofNullable(list.stream()
                .filter(box -> Optional.ofNullable(box.getBook()).isPresent())
                .map(Box::getBook)
                .filter(book -> Optional.ofNullable(book.getColor()).isPresent())
                // 转换为不可修改的list
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList))
                // 通过不可修改的list创建流,分组后产生新的list 可以被修改
                .stream()
                .collect(Collectors.groupingBy(Book::getColor))
        );
        collect.ifPresent(System.out::println);
        System.out.println(collect.orElse(new HashMap<>(8)).get("red").add(new Book()));
    }

    protected static void testCounting(List<Book> list){
        System.out.println("testCounting");

        Optional.ofNullable(list.stream()
                .collect(Collectors.counting()))
                .ifPresent(System.out::println);
        Optional.of(list.stream().count()).ifPresent(System.out::println);
        Optional.of((long) list.size()).ifPresent(System.out::println);
    }



}
