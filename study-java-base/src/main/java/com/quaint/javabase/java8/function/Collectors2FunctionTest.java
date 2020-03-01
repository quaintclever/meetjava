package com.quaint.javabase.java8.function;

import com.quaint.javabase.java8.helper.Book;
import com.quaint.javabase.java8.helper.Box;

import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import static com.quaint.javabase.java8.helper.HelperSupplier.bookList;
import static com.quaint.javabase.java8.helper.HelperSupplier.boxList;

/**
 * @author quaint
 * @date 2020-01-16 15:35
 */
public class Collectors2FunctionTest {

    protected static void testSummingLong(){
        System.out.println("testSummingLong");
        Long collect = bookList.stream().collect(Collectors.summingLong(Book::getPage));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    protected static void testSummingInt(){
        System.out.println("testSummingInt");
        Integer collect = bookList.stream().collect(Collectors.summingInt(Book::getPage));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    protected static void testSummingDouble(){
        System.out.println("testSummingDouble");
        Double collect = bookList.stream().collect(Collectors.summingDouble(Book::getPage));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }


    protected static void testSummarizingInt(){
        System.out.println("testSummarizingInt");
        IntSummaryStatistics collect = bookList.stream()
                .collect(Collectors.summarizingInt(Book::getPage));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    protected static void testSummarizingLong(){
        System.out.println("testSummarizingLong");
        LongSummaryStatistics collect = bookList.stream()
                .collect(Collectors.summarizingLong(Book::getPage));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    protected static void testSummarizingDouble(){
        System.out.println("testSummarizingDouble");
        DoubleSummaryStatistics collect = bookList.stream()
                .collect(Collectors.summarizingDouble(Book::getPage));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }


    protected static void testReducingBinaryOperatorWithIdentityAndFunction(){
        System.out.println("testReducingBinaryOperatorWithIdentityAndFunction");
        Integer collect = bookList.stream()
                .collect(Collectors.reducing(0,Book::getPage ,(a,b)->a+b));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }


    protected static void testReducingBinaryOperatorWithIdentity(){
        System.out.println("testReducingBinaryOperatorWithIdentity");
        Integer collect = bookList.stream()
                .map(Book::getPage)
                .collect(Collectors.reducing(0,(a,b)->a+b));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }


    protected static void testReducingBinaryOperator(){
        System.out.println("testReducingBinaryOperator");
        Optional<Book> collect = bookList.stream()
                .collect(Collectors.reducing(BinaryOperator.maxBy(Comparator.comparingInt(Book::getPage))));
        collect.ifPresent(System.out::println);
    }

    protected static void testPartitioningByCollectors(){
        System.out.println("testPartitioningByCollectors");
        Map<Boolean, Double> collect = bookList.stream()
                .collect(Collectors.partitioningBy(b -> "red".equals(b.getColor()),Collectors.averagingInt(Book::getPage)));
        Optional.ofNullable(collect).ifPresent(System.out::println);

    }


    protected static void testPartitioningBy(){
        System.out.println("testPartitioningBy");
        Map<Boolean, List<Book>> collect = bookList.stream()
                .collect(Collectors.partitioningBy(b -> "red".equals(b.getColor())));
        Optional.ofNullable(collect).ifPresent(System.out::println);

    }


    protected static void testMinBy(){
        System.out.println("testMinBy");
        Optional<Book> collect = bookList.stream()
                .collect(Collectors.minBy(Comparator.comparingInt(Book::getPage)));
        collect.ifPresent(System.out::println);
    }


    protected static void testMaxBy(){
        System.out.println("testMaxBy");
        Optional<Book> collect = bookList.stream()
                .collect(Collectors.maxBy(Comparator.comparingInt(Book::getPage)));
        collect.ifPresent(System.out::println);
    }

    protected static void testMapping(){
        System.out.println("testMapping");
        String collect = bookList.stream()
                .collect(Collectors.mapping(Book::getColor, Collectors.joining()));
        Optional.of(collect).ifPresent(System.out::println);
    }

    protected static void testJoiningWithDelimiterAndPrefixAndSuffix(){
        System.out.println("testJoiningWithDelimiterAndPrefixAndSuffix");
        String join = bookList.stream()
                .map(Book::getColor)
                .collect(Collectors.joining("; ","Colors:[ "," ]"));
        Optional.ofNullable(join).ifPresent(System.out::println);
    }

    protected static void testJoiningWithDelimiter(){
        System.out.println("testJoiningWithDelimiter");
        String join = bookList.stream()
                .map(Book::getColor)
                .collect(Collectors.joining("; "));
        Optional.ofNullable(join).ifPresent(System.out::println);
    }

    protected static void testJoining(){
        System.out.println("testJoining");
        String join = bookList.stream()
                .map(Book::getColor)
                .collect(Collectors.joining());
        Optional.ofNullable(join).ifPresent(System.out::println);
    }

    protected static void testGroupingByConcurrentWithCollectorsWithSkipTable(){
        System.out.println("testGroupingByConcurrentWithCollectors");
        ConcurrentMap<String, Double> collect = bookList.stream()
                .collect(Collectors.groupingByConcurrent(Book::getColor, ConcurrentSkipListMap::new,Collectors.averagingInt(Book::getPage)));
        Optional.of(collect).ifPresent(c-> System.out.println(c.getClass()));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    protected static void testGroupingByConcurrent(){
        System.out.println("testGroupingByConcurrent");
        ConcurrentMap<String, List<Book>> collect = bookList.stream()
                .collect(Collectors.groupingByConcurrent(Book::getColor));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    protected static void testGroupingByConcurrentWithCollectors(){
        System.out.println("testGroupingByConcurrentWithCollectors");
        ConcurrentMap<String, Double> collect = bookList.stream()
                .collect(Collectors.groupingByConcurrent(Book::getColor,Collectors.averagingInt(Book::getPage)));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }


    protected static void testGroupingByFunction(){
        System.out.println("testGroupingByFunction");
        Optional.ofNullable(bookList.stream().collect(Collectors.groupingBy(Book::getColor))).ifPresent(System.out::println);
    }

    protected static void testGroupingByAveragingInt(){
        System.out.println("testGroupingByAveragingInt");
        Optional.ofNullable(bookList.stream()
                .collect(Collectors.groupingBy(Book::getColor,Collectors.averagingInt(Book::getPage))))
                .ifPresent(System.out::println);
    }

    protected static void testCollectingAndThen(){
        System.out.println("testCollectingAndThen");
        Optional<Map<String, List<Book>>> collect = Optional.ofNullable(boxList.stream()
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

    protected static void testCounting(){
        System.out.println("testCounting");

        Optional.ofNullable(bookList.stream()
                .collect(Collectors.counting()))
                .ifPresent(System.out::println);
        Optional.of(bookList.stream().count()).ifPresent(System.out::println);
        Optional.of((long) bookList.size()).ifPresent(System.out::println);
    }

    protected static void testGroupingByFunctionAndAveragingInt(){
        System.out.println("testGroupingByFunctionAndAveragingInt");
        Optional.ofNullable(bookList.stream()
                .collect(Collectors.groupingBy(Book::getColor,Collectors.averagingInt(Book::getPage))))
                .ifPresent(System.out::println);
    }

    protected static void testGroupingByFunctionAndMap(){
        System.out.println("testGroupingByFunctionAndMap");
        Optional.ofNullable(bookList.stream()
                .collect(Collectors.groupingBy(Book::getColor,HashMap::new,Collectors.averagingInt(Book::getPage))))
                .ifPresent(System.out::println);
    }


}
