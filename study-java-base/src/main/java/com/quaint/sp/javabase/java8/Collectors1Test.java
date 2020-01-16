package com.quaint.sp.javabase.java8;

import com.quaint.sp.javabase.java8.helper.Book;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author quaint
 * @date 2020-01-16 14:35
 */
public class Collectors1Test {

    public final static List<Book> books = Arrays.asList(
            new Book("red",100),
            new Book("red",60),
            new Book("green",60),
            new Book("green",101));

    public static void main(String[] args) {



        System.out.println("以颜色进行分组:");
        System.out.println("normal -->");
        System.out.println(groupByNormal(books));
        System.out.println("lambda -->");
        System.out.println(groupByLambda(books));
        System.out.println("collect -->");
        System.out.println(groupByCollect(books));

    }


    /**
     * 以颜色进行分组 --> 普通写法
     */
    private static Map<String,List<Book>> groupByNormal(List<Book> list){
        Map<String,List<Book>> map = new HashMap<>();
        for (Book book: list) {
            List<Book> books = map.get(book.getColor());
            if (books==null){
                books = new ArrayList<>();
                map.put(book.getColor(),books);
            }
            books.add(book);
        }
        return map;
    }

    /**
     * 以颜色进行分组 --> java8 lambda optional 写法
     */
    private static Map<String,List<Book>> groupByLambda(List<Book> list){
        Map<String,List<Book>> map = new HashMap<>();
        list.forEach(book -> {
            List<Book> books = Optional.ofNullable(map.get(book.getColor())).orElseGet(() -> {
                List<Book> colorBook = new ArrayList<>();
                map.put(book.getColor(), colorBook);
                return colorBook;
            });
            books.add(book);
        });
        return map;
    }

    /**
     * 以颜色进行分组 --> java8 collect 写法
     */
    private static Map<String,List<Book>> groupByCollect(List<Book> list){
        return list.stream().collect(Collectors.groupingBy(Book::getColor));
    }

}
