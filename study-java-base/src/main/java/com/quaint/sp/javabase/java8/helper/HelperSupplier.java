package com.quaint.sp.javabase.java8.helper;

import java.util.Arrays;
import java.util.List;

/**
 * @author quaint
 * @date 2020-01-16 16:39
 */
public class HelperSupplier {

    /**
     * 测试book list
     */
    public static final List<Book> bookList = Arrays.asList(
            new Book("red",100),
            new Book("red",60),
            new Book("yellow",30),
            new Book("yellow",20),
            new Book("red",60),
            new Book("green",60),
            new Book("green",70),
            new Book("green",101),
            new Book("blue",101)
    );

    /**
     * 测试box list
     */
    public static final List<Box> boxList = Arrays.asList(
            new Box(new Book("red",100)),
            new Box(new Book("red",99)),
            new Box(),
            new Box(),
            new Box(new Book()),
            new Box(new Book()),
            new Box(new Book("green",30)),
            new Box(new Book("green",50)),
            new Box(new Book("red",70)),
            new Box(new Book("red",77)),
            new Box(new Book("blue",60)),
            new Box(new Book("blue",88))

    );

}
